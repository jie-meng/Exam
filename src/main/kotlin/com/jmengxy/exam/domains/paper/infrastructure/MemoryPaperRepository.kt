package com.jmengxy.exam.domains.paper.infrastructure

import com.jmengxy.exam.base.id.PaperId
import com.jmengxy.exam.domains.paper.model.Paper
import com.jmengxy.exam.domains.paper.model.PaperRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class MemoryPaperRepository : PaperRepository {

    private val papers = mutableListOf<Paper>()

    override fun find(paperId: PaperId): Paper? {
        return papers.firstOrNull {
            it.paperId.sameValueAs(paperId)
        }
    }

    override fun findAll(): List<Paper> {
        return papers
    }

    override fun save(paper: Paper) {
        papers.add(paper)
    }

    override fun nextPaperId(): PaperId {
        return PaperId("Paper_${UUID.randomUUID()}")
    }
}