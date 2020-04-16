package com.jmengxy.exam.domains.model.examsheet

import com.jmengxy.exam.base.id.AnswerId
import com.jmengxy.exam.base.type.Entity

class Answer(
        val answerId: AnswerId,
        answer: String
) : Entity<Answer> {

    var answer = answer
        private set

    fun submit(answer: String) {
        this.answer = answer
    }
}