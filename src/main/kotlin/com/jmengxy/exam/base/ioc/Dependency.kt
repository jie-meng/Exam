package com.jmengxy.exam.base.ioc

import com.jmengxy.exam.domains.blankquiz.infrastructure.MemoryBlankQuizRepository
import com.jmengxy.exam.domains.examination.infrastructure.MemoryExaminationRepository
import com.jmengxy.exam.domains.examsheet.infrastructure.MemoryExamSheetRepository
import com.jmengxy.exam.domains.paper.infrastructure.MemoryPaperRepository

object Dependency {
    val blankQuizRepository = MemoryBlankQuizRepository()

    val paperRepository = MemoryPaperRepository()

    val examinationRepository = MemoryExaminationRepository()

    val examSheetRepository = MemoryExamSheetRepository()
}