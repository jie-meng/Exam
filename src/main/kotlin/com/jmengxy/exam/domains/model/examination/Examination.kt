package com.jmengxy.exam.domains.model.examination

import com.jmengxy.exam.base.id.ExaminationId
import com.jmengxy.exam.base.id.PaperId
import com.jmengxy.exam.base.type.Entity

class Examination(val examinationId: ExaminationId,
                  paperId: PaperId,
                  val examMinutes: Int,
                  val startDate: Long,
                  val endDate: Long
) : Entity<Examination> {

    val paper: Paper = Paper(paperId)

    companion object {
        fun create(
                examinationId: ExaminationId,
                paperId: PaperId,
                examMinutes: Int,
                startDate: Long,
                endDate: Long
        ): Examination {
            return Examination(examinationId, paperId, examMinutes, startDate, endDate)
        }
    }
}