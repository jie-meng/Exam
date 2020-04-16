package com.jmengxy.exam.base.id

import com.jmengxy.exam.base.type.ValueObject

class ExaminationId(id: String) : ValueObject<ExaminationId> {

    var id = id
        private set

    override fun sameValueAs(other: ExaminationId): Boolean {
        return this.id == other.id

    }
}