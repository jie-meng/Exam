package com.jmengxy.exam.base.id

import com.jmengxy.exam.base.type.ValueObject

class ExamSheetId(id: String) : ValueObject<ExamSheetId> {

    var id = id
        private set

    override fun sameValueAs(other: ExamSheetId): Boolean {
        return this.id == other.id
    }
}