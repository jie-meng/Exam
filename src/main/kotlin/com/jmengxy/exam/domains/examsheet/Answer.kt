package com.jmengxy.exam.domains.examsheet

import com.jmengxy.exam.base.id.AnswerId
import com.jmengxy.exam.base.type.Entity
import java.util.*

class Answer(
        val answerId: AnswerId,
        answer: String
) : Entity<Answer> {

    var answer = answer
        private set

    fun submit(answer: String) {
        this.answer = answer
    }

    companion object {
        fun create(): Answer {
            val answerId = AnswerId("Answer_${UUID.randomUUID()}")
            return Answer(answerId, "")
        }
    }
}