package com.jmengxy.exam.domains.paper.model

import com.jmengxy.exam.base.exception.TooManyQuizzesException
import com.jmengxy.exam.base.id.PaperId
import com.jmengxy.exam.base.type.Entity
import java.util.*

class Paper(val paperId: PaperId, blankQuizzes: List<BlankQuiz>) : Entity<Paper> {

    private val blankQuizzes: MutableList<BlankQuiz> = mutableListOf()

    init {
        reassemble(blankQuizzes)
    }

    fun getBlankQuizzes(): List<BlankQuiz> {
        return Collections.unmodifiableList(blankQuizzes)
    }

    fun reassemble(blankQuizzes: List<BlankQuiz>) {
        if (blankQuizzes.size > 20) {
            throw TooManyQuizzesException(blankQuizzes.size)
        }

        this.blankQuizzes.apply {
            clear()
            addAll(blankQuizzes)
        }
    }

    companion object {
        fun assemble(paperId: PaperId, blankQuizzes: List<BlankQuiz>): Paper {
            return Paper(paperId, blankQuizzes)
        }
    }
}