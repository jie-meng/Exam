package com.jmengxy.exam.domains.model.paper.data

import com.jmengxy.exam.base.id.PaperId
import com.jmengxy.exam.domains.model.paper.Paper

interface PaperRepository {
    fun find(paperId: PaperId): Paper?
    fun save(paper: Paper)
    fun nextPaperId(): PaperId
}