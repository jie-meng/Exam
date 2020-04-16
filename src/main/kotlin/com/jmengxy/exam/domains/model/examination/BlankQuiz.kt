package com.jmengxy.exam.domains.model.examination

import com.jmengxy.exam.base.id.BlankQuizId
import com.jmengxy.exam.base.type.ValueObject

class BlankQuiz(
        val blankQuiId: BlankQuizId,
        val question: String,
        val referenceAnswer: String,
        val score: Int
) : ValueObject<BlankQuiz> {

    override fun sameValueAs(other: BlankQuiz): Boolean {
        if (this === other) {
            return true
        }

        return this.blankQuiId.sameValueAs(other.blankQuiId)
                && this.score == other.score
                && this.question == other.question
                && this.referenceAnswer == other.referenceAnswer
    }
}
