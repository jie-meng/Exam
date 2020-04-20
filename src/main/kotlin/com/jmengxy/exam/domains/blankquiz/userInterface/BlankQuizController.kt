package com.jmengxy.exam.domains.blankquiz.userInterface

import com.jmengxy.exam.domains.blankquiz.application.BlankQuizService
import com.jmengxy.exam.domains.blankquiz.application.CreateBlankQuizRequest
import com.jmengxy.exam.domains.blankquiz.model.BlankQuiz
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class BlankQuizController @Autowired constructor(private val blankQuizeService: BlankQuizService) {

    @PostMapping("/blankquiz")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: CreateBlankQuizRequest): BlankQuizDTO {
        val blankQuizId = blankQuizeService.createBlankQuiz(request)
        return BlankQuizDTO(blankQuizId.id)
    }

    @GetMapping("/blankquiz")
    fun getAll(): List<BlankQuiz> {
        return blankQuizeService.fetchAllBlankQuizzes()
    }
}