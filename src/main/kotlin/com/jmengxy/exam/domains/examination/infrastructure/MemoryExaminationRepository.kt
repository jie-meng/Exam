package com.jmengxy.exam.domains.examination.infrastructure

import com.jmengxy.exam.base.id.ExaminationId
import com.jmengxy.exam.domains.examination.Examination
import com.jmengxy.exam.domains.examination.ExaminationRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class MemoryExaminationRepository : ExaminationRepository {

    private val examinations = mutableListOf<Examination>()

    override fun find(examinationId: ExaminationId): Examination? {
        return examinations.firstOrNull {
            it.examinationId.sameValueAs(examinationId)
        }
    }

    override fun save(examination: Examination) {
        examinations.add(examination)
    }

    override fun nextExaminationId(): ExaminationId {
        return ExaminationId("Examination_${UUID.randomUUID()}")
    }
}