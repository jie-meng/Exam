package com.jmengxy.exam.domains.blankquiz.application

import com.jmengxy.exam.base.id.BlankQuizId
import com.jmengxy.exam.domains.blankquiz.model.BlankQuiz
import com.jmengxy.exam.domains.blankquiz.model.BlankQuizRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BlankQuizService @Autowired constructor(private val blankQuizeRepository: BlankQuizRepository) {

    fun createBlankQuiz(request: CreateBlankQuizRequest): BlankQuizId {
        val blankQuizId = blankQuizeRepository.nextBlankQuizId()
        blankQuizeRepository.save(BlankQuiz(blankQuizId, request.question, request.referenceAnswer))
        return blankQuizId
    }

    fun fetchAllBlankQuizzes(): List<BlankQuiz> {
        return blankQuizeRepository.findAll()
    }
}