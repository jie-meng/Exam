package com.jmengxy.exam.domains.paper.userInterface

import com.jmengxy.exam.domains.paper.model.Paper
import com.jmengxy.exam.domains.paper.application.AssemblePaperRequest
import com.jmengxy.exam.domains.paper.application.PaperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
class PaperController @Autowired constructor(private val paperService: PaperService) {

    @PostMapping("/paper")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    fun assemble(@RequestBody request: AssemblePaperRequest): PaperDTO {
        val paperId = paperService.assemblePaper(request)
        return PaperDTO(paperId.id)
    }

    @GetMapping("/paper")
    fun getAll(): List<Paper> {
        return paperService.fetchAllPapers()
    }

    @PutMapping("/paper/{paperId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun reassemble(@PathVariable paperId: String, @RequestBody request: AssemblePaperRequest) {
        paperService.reassemblePaper(paperId, request)
    }
}