package com.jmengxy.exam

import com.jmengxy.exam.base.id.StudentId
import com.jmengxy.exam.base.ioc.Dependency
import com.jmengxy.exam.domains.model.blankquiz.BlankQuiz
import com.jmengxy.exam.domains.model.examination.Examination
import com.jmengxy.exam.domains.model.examsheet.ExamSheet
import com.jmengxy.exam.domains.model.paper.Paper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.util.Assert
import java.time.Instant

@SpringBootTest
class ExamApplicationTests {

    private val blankQuizRepository = Dependency.blankQuizRepository
    private val paperRepository = Dependency.paperRepository
    private val examinationRepository = Dependency.examinationRepository
    private val examSheetRepository = Dependency.examSheetRepository

    @BeforeEach
    fun prepareData() {
        for (i in 0..9) {
            val blankQuizId = blankQuizRepository.nextBlankQuizId()
            blankQuizRepository.save(BlankQuiz(blankQuizId, "question_$i", "answer_$i"))
        }
    }

    @Test
    fun happy_path() {
        // create and save paper
        val findAll = blankQuizRepository.findAll()
        val quizzes = findAll.subList(0, 10).map { com.jmengxy.exam.domains.model.paper.BlankQuiz(it.blankQuizId, 10) }

        val paperId = paperRepository.nextPaperId()
        val paper = Paper.assemble(paperId, quizzes)
        paperRepository.save(paper)

        // create and save examination
        val examinationId = examinationRepository.nextExaminationId()
        val examination = Examination.create(examinationId, paperId, 120, Instant.now().toEpochMilli(), Instant.now().toEpochMilli() + 120 * 60 * 1000)

        examinationRepository.save(examination)

        // create examSheet and test
        val examSheetId = examSheetRepository.nextExamSheetId()
        val examSheet = ExamSheet.assign(examSheetId, examinationId, StudentId("123"))
        examSheet.submit(0, "answer_0") // right
        examSheet.submit(1, "answer_1") // right
        examSheet.submit(2, "answer_8") // wrong

        examSheet.handIn()

        Assert.isTrue(examSheet.totalScore == 20, "totalScore incorrect")
    }
}
