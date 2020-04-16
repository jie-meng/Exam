package com.jmengxy.exam.base.id

import com.jmengxy.exam.base.type.ValueObject

class AnswerId(id: String) : ValueObject<AnswerId> {

    var id = id
        private set

    override fun sameValueAs(other: AnswerId): Boolean {
        return this.id == other.id
    }
}