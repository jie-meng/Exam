package com.jmengxy.exam.domains.examination

import com.jmengxy.exam.base.exception.NoSuchPaperException
import com.jmengxy.exam.base.id.PaperId
import com.jmengxy.exam.base.ioc.Dependency
import com.jmengxy.exam.base.type.ValueObject

class Paper(val paperId: PaperId) : ValueObject<Paper> {

    val blankQuizzes: List<BlankQuiz>

    init {
        val paper = Dependency.paperRepository.find(paperId) ?: throw NoSuchPaperException(paperId)
        paper.let { p ->
            this.blankQuizzes = p.getBlankQuizzes().map { BlankQuiz(it.blankQuizId, it.question, it.referenceAnswer, it.score) }
        }
    }

    override fun sameValueAs(other: Paper): Boolean {
        if (this === other) {
            return true
        }

        return paperId.sameValueAs(other.paperId) &&
                sameBlankQuizzes(other.blankQuizzes)
    }

    private fun sameBlankQuizzes(blankQuizzes: List<BlankQuiz>): Boolean {
        if (this.blankQuizzes.size != blankQuizzes.size) {
            return false
        }

        this.blankQuizzes.forEachIndexed { index, value ->
            if (!value.sameValueAs(blankQuizzes[index])) {
                return false
            }
        }

        return true
    }
}

