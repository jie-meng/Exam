package com.jmengxy.exam.domains.examsheet

import com.jmengxy.exam.base.id.ExamSheetId
import com.jmengxy.exam.domains.examsheet.ExamSheet

interface ExamSheetRepository {
    fun find(examSheetId: ExamSheetId): ExamSheet?
    fun save(examSheet: ExamSheet)
    fun nextExamSheetId(): ExamSheetId
}