package com.jmengxy.exam.domains.paper.model

import com.jmengxy.exam.base.exception.IllegalScoreException
import com.jmengxy.exam.base.id.BlankQuizId
import com.jmengxy.exam.base.type.ValueObject

class BlankQuiz(
        val blankQuizId: BlankQuizId,
        val question: String,
        val referenceAnswer: String,
        score: Int
) : ValueObject<BlankQuiz> {

    var score: Int = 0
        set(value) {
            if (value > 100) {
                throw IllegalScoreException(score)
            }
            field = value
        }

    init {
        this.score = score
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
