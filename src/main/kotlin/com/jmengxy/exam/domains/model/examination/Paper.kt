package com.jmengxy.exam.domains.model.examination

import com.jmengxy.exam.base.id.PaperId
import com.jmengxy.exam.base.ioc.Dependency
import com.jmengxy.exam.base.type.ValueObject
import java.util.*

class Paper : ValueObject<Paper> {

    private var blankQuizzes: MutableList<BlankQuiz> = mutableListOf()
        get() = Collections.unmodifiableList(field)

    private val paperId: PaperId

    private constructor(paperId: PaperId) {
        this.paperId = paperId

        val paper = Dependency.paperRepository.find(paperId)
        paper?.let { p ->
            this.blankQuizzes.addAll(p.blankQuizzes.map { BlankQuiz(it.blankQuizId, it.question, it.referenceAnswer, it.score) })
        }
    }

    override fun sameValueAs(other: Paper): Boolean {
        if (this === other) {
            return true
        }

        return paperId.sameValueAs(other.paperId) &&
                sameBlankQuizzes(other.blankQuizzes)
    }

    private fun sameBlankQuizzes(blankQuizzes: List<BlankQuiz>): Boolean {
        if (this.blankQuizzes.size != blankQuizzes.size) {
            return false
        }

        this.blankQuizzes.forEachIndexed { index, value ->
            if (!value.sameValueAs(blankQuizzes[index])) {
                return false
            }
        }

        return true
    }
}

