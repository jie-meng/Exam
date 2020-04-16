package com.jmengxy.exam.domains.model.examsheet.data

import com.jmengxy.exam.base.id.ExamSheetId
import com.jmengxy.exam.domains.model.examsheet.ExamSheet
import java.util.*

class MemoryExamSheetRepository : ExamSheetRepository {

    private val examSheets = mutableListOf<ExamSheet>()

    override fun find(examSheetId: ExamSheetId): ExamSheet? {
        return examSheets.firstOrNull {
            it.examSheetId.sameValueAs(examSheetId)
        }
    }

    override fun save(examSheet: ExamSheet) {
        examSheets.add(examSheet)
    }

    override fun nextExamSheetId(): ExamSheetId {
        return ExamSheetId("ExamSheet_${UUID.randomUUID()}")
    }
}