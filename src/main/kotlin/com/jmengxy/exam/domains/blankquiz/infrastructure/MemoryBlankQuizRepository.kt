package com.jmengxy.exam.domains.blankquiz.infrastructure

import com.jmengxy.exam.base.id.BlankQuizId
import com.jmengxy.exam.domains.blankquiz.model.BlankQuiz
import com.jmengxy.exam.domains.blankquiz.model.BlankQuizRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
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