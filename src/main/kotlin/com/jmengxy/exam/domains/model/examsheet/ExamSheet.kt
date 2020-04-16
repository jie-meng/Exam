package com.jmengxy.exam.domains.model.examsheet

import com.jmengxy.exam.base.id.ExamSheetId
import com.jmengxy.exam.base.id.ExaminationId
import com.jmengxy.exam.base.id.StudentId
import com.jmengxy.exam.base.ioc.Dependency
import com.jmengxy.exam.base.type.Entity

class ExamSheet(
        val examSheetId: ExamSheetId,
        private val examinationId: ExaminationId,
        private val studentId: StudentId,
        private val leftMinutes: Int,
        private val answers: List<Answer>
) : Entity<ExamSheet> {

    companion object {
        fun assign(examSheetId: ExamSheetId, examinationId: ExaminationId, studentId: StudentId) {
            val examination = Dependency.examinationRepository.find(examinationId)
        }
    }
}