package com.jmengxy.exam.base.id

import com.jmengxy.exam.base.type.ValueObject

class StudentId(id: String) : ValueObject<StudentId> {

    var id = id
        private set

    override fun sameValueAs(other: StudentId): Boolean {
        return this.id == other.id
    }
}
