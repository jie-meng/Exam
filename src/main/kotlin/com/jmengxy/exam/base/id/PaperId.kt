package com.jmengxy.exam.base.id

import com.jmengxy.exam.base.type.ValueObject

class PaperId(id: String) : ValueObject<PaperId> {

    var id = id
        private set

    override fun sameValueAs(other: PaperId): Boolean {
        return this.id == other.id
    }
}