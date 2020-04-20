package com.jmengxy.exam.domains.paper.model

import com.jmengxy.exam.base.id.PaperId

interface PaperRepository {
    fun find(paperId: PaperId): Paper?
    fun findAll(): List<Paper>
    fun save(paper: Paper)
    fun nextPaperId(): PaperId
}