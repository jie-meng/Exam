package com.jmengxy.exam.domains.model.paper

import com.jmengxy.exam.base.exception.IllegalScoreException
import com.jmengxy.exam.base.exception.NoSuchBlankQuizException
import com.jmengxy.exam.base.id.BlankQuizId
import com.jmengxy.exam.base.ioc.Dependency
import com.jmengxy.exam.base.type.ValueObject

class BlankQuiz(
        val blankQuizId: BlankQuizId,
        score: Int
) : ValueObject<BlankQuiz> {

    val question: String
    val referenceAnswer: String
    var score: Int = 0
        set(value) {
            if (value > 100) {
                throw IllegalScoreException(score)
            }
            field = value
        }

    init {
        this.score = score

        val blankQuiz = Dependency.blankQuizRepository.find(blankQuizId) ?: throw NoSuchBlankQuizException(blankQuizId)
        blankQuiz.let {
            this.question = it.question
            this.referenceAnswer = it.referenceAnswer
        }
    }

    override fun sameValueAs(other: BlankQuiz): Boolean {
        if (this === other) {
            return true
        }

        return this.blankQuizId.sameValueAs(other.blankQuizId)
                && this.score == other.score
                && this.question == other.question
                && this.referenceAnswer == other.referenceAnswer
    }
}
