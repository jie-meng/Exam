package com.jmengxy.exam.domains.examination

import com.jmengxy.exam.base.id.ExaminationId
import com.jmengxy.exam.domains.examination.Examination

interface ExaminationRepository {
    fun find(examinationId: ExaminationId): Examination?
    fun save(examination: Examination)
    fun nextExaminationId(): ExaminationId
}