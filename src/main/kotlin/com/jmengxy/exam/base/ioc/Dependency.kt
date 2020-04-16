package com.jmengxy.exam.base.ioc

import com.jmengxy.exam.domains.model.blankquiz.data.MemoryBlankQuizRepository
import com.jmengxy.exam.domains.model.examination.data.MemoryExaminationRepository
import com.jmengxy.exam.domains.model.examsheet.data.MemoryExamSheetRepository
import com.jmengxy.exam.domains.model.paper.data.MemoryPaperRepository

object Dependency {
    val blankQuizRepository = MemoryBlankQuizRepository()

    val paperRepository = MemoryPaperRepository()

    val examinationRepository = MemoryExaminationRepository()

    val examSheetRepository = MemoryExamSheetRepository()
}