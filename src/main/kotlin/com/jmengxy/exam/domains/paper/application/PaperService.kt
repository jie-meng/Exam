package com.jmengxy.exam.domains.paper.application

import com.jmengxy.exam.base.exception.NoSuchBlankQuizException
import com.jmengxy.exam.base.exception.NoSuchPaperException
import com.jmengxy.exam.base.id.BlankQuizId
import com.jmengxy.exam.base.id.PaperId
import com.jmengxy.exam.domains.blankquiz.model.BlankQuizRepository
import com.jmengxy.exam.domains.paper.model.BlankQuiz
import com.jmengxy.exam.domains.paper.model.Paper
import com.jmengxy.exam.domains.paper.model.PaperRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class PaperService @Autowired constructor(
        private val paperRepository: PaperRepository,
        private val blankquizRepository: BlankQuizRepository) {

    fun assemblePaper(request: AssemblePaperRequest): PaperId {
        val blankQuizzes: List<BlankQuiz> = blankQuizFrom(request)
        val paperId = paperRepository.nextPaperId()
        val paper: Paper = Paper.assemble(paperId, blankQuizzes)
        paperRepository.save(paper)
        return paperId
    }

    fun fetchAllPapers(): List<Paper> {
        return paperRepository.findAll()
    }

    fun reassemblePaper(paperId: String, request: AssemblePaperRequest) {
        val paper: Paper? = paperRepository.find(PaperId(paperId))
        paper?.let {
            val blankQuizzes: List<BlankQuiz> = blankQuizFrom(request)
            paper.reassemble(blankQuizzes)
        } ?: throw NoSuchPaperException(PaperId(paperId))
    }

    private fun blankQuizFrom(request: AssemblePaperRequest): List<BlankQuiz> {
        return request.blankQuizzes.map { quiz -> blankquizRepository.find(BlankQuizId(quiz.id))?.let { BlankQuiz(it.blankQuizId, it.question, it.referenceAnswer, quiz.score) } ?: throw NoSuchBlankQuizException(BlankQuizId(quiz.id)) }
    }
}