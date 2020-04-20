package com.jmengxy.exam.domains.examsheet

import com.jmengxy.exam.base.exception.ExamSheetAlreadyHandInException
import com.jmengxy.exam.base.exception.NoSuchExaminationException
import com.jmengxy.exam.base.id.ExamSheetId
import com.jmengxy.exam.base.id.ExaminationId
import com.jmengxy.exam.base.id.StudentId
import com.jmengxy.exam.base.ioc.Dependency
import com.jmengxy.exam.base.type.Entity

class ExamSheet(
        val examSheetId: ExamSheetId,
        private val examinationId: ExaminationId,
        private val studentId: StudentId
) : Entity<ExamSheet> {

    private val examination = Dependency.examinationRepository.find(examinationId)
            ?: throw NoSuchExaminationException(examinationId)
    private val answers: List<Answer>
    var totalScore = 0
        private set

    private var alreadyHandIn = false
    private val leftMinutes: Int

    init {
        leftMinutes = examination.examMinutes
        answers = examination.paper.blankQuizzes.map { Answer.create() }
    }

    fun submit(index: Int, answer: String) {
        if (alreadyHandIn) {
            throw ExamSheetAlreadyHandInException(examSheetId)
        }

        answers[index].submit(answer)
    }

    fun handIn() {
        examination.paper.blankQuizzes.forEachIndexed { index, blankQuiz ->
            if (blankQuiz.referenceAnswer.trim() == answers[index].answer.trim()) {
                this.totalScore += blankQuiz.score
            }
        }

        this.alreadyHandIn = true
    }

    companion object {
        fun assign(examSheetId: ExamSheetId, examinationId: ExaminationId, studentId: StudentId): ExamSheet {
            return ExamSheet(examSheetId, examinationId, studentId)
        }
    }
}