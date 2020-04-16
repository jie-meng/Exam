package com.jmengxy.exam.domains.model.paper.data

import com.jmengxy.exam.base.id.PaperId
import com.jmengxy.exam.domains.model.paper.Paper
import java.util.*

class MemoryPaperRepository : PaperRepository {

    private val papers = mutableListOf<Paper>()

    override fun find(paperId: PaperId): Paper? {
        return papers.firstOrNull {
            it.paperId.sameValueAs(paperId)
        }
    }

    override fun save(paper: Paper) {
        papers.add(paper)
    }

    override fun nextPaperId(): PaperId {
        return PaperId("Paper_${UUID.randomUUID()}")
    }
}