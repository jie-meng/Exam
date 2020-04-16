package com.jmengxy.exam.domains.model.blankquiz.data

import com.jmengxy.exam.base.id.BlankQuizId
import com.jmengxy.exam.domains.model.blankquiz.BlankQuiz
import java.util.*

class MemoryBlankQuizRepository : BlankQuizRepository {

    private val blankQuizzes = mutableListOf<BlankQuiz>()

    override fun find(blankQuizId: BlankQuizId): BlankQuiz? {
        return blankQuizzes.firstOrNull {
            it.blankQuizId.sameValueAs(blankQuizId)
        }
    }

    override fun find(blankQuizIds: List<BlankQuizId>): List<BlankQuiz> {
        return blankQuizzes.filter { dbItem ->
            blankQuizIds.firstOrNull { dbItem.blankQuizId.id == it.id } != null
        }
    }

    override fun findAll(): List<BlankQuiz> {
        return blankQuizzes.toList()
    }

    override fun save(blankQuiz: BlankQuiz) {
        blankQuizzes.add(blankQuiz)
    }

    override fun nextBlankQuizId(): BlankQuizId {
        return BlankQuizId("BlankQuiz_${UUID.randomUUID()}")
    }
}