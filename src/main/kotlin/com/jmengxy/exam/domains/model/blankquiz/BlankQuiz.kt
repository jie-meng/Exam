package com.jmengxy.exam.domains.model.blankquiz

import com.jmengxy.exam.base.id.BlankQuizId
import com.jmengxy.exam.base.type.Entity

class BlankQuiz(
        val blankQuizId: BlankQuizId,
        var question: String,
        var referenceAnswer: String
) : Entity<BlankQuiz>
