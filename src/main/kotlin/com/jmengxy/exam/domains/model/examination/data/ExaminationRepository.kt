package com.jmengxy.exam.domains.model.examination.data

import com.jmengxy.exam.base.id.ExaminationId
import com.jmengxy.exam.domains.model.examination.Examination

interface ExaminationRepository {
    fun find(examinationId: ExaminationId): Examination?
    fun save(examination: Examination)
    fun nextExaminationId(): ExaminationId
}