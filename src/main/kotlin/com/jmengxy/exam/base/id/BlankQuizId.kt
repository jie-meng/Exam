package com.jmengxy.exam.base.id

import com.jmengxy.exam.base.type.ValueObject

class BlankQuizId(id: String) : ValueObject<BlankQuizId> {

    var id = id
        private set

    override fun sameValueAs(other: BlankQuizId): Boolean {
        return this.id == other.id
    }
}