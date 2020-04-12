package com.jmengxy.exam.domains.paper

data class BlankQuiz(
        var Id: Long,
        var question: String,
        var referenceAnswer: String,
        var score: Int
)