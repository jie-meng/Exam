package com.jmengxy.exam.domains.paper.application

data class AssemblePaperRequest(val blankQuizzes: List<Quiz>) {
    class Quiz {
        val id: String = ""
        val score = 0
    }
}