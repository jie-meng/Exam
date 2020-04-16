package com.jmengxy.exam.domains.model.paper

import com.jmengxy.exam.base.exception.TooManyQuizzesException
import com.jmengxy.exam.base.id.PaperId
import com.jmengxy.exam.base.type.Entity
import java.util.*

class Paper(val paperId: PaperId, blankQuizzes: List<BlankQuiz>) : Entity<Paper> {

    val blankQuizzes: MutableList<BlankQuiz> = mutableListOf()
        get() = Collections.unmodifiableList(field)

    init {
        reassemble(blankQuizzes)
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