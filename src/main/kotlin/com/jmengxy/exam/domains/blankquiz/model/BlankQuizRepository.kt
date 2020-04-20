package com.jmengxy.exam.domains.blankquiz.model

import com.jmengxy.exam.base.id.BlankQuizId
import com.jmengxy.exam.domains.blankquiz.model.BlankQuiz

interface BlankQuizRepository {
    fun find(blankQuizId: BlankQuizId): BlankQuiz?
    fun find(blankQuizIds: List<BlankQuizId>): List<BlankQuiz>
    fun findAll(): List<BlankQuiz>
    fun save(blankQuiz: BlankQuiz)
    fun nextBlankQuizId(): BlankQuizId
}