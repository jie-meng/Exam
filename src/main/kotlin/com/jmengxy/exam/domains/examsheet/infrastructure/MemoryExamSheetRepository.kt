package com.jmengxy.exam.domains.examsheet.infrastructure

import com.jmengxy.exam.base.id.ExamSheetId
import com.jmengxy.exam.domains.examsheet.ExamSheet
import com.jmengxy.exam.domains.examsheet.ExamSheetRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
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