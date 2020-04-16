package com.jmengxy.exam.base.exception

import com.jmengxy.exam.base.id.BlankQuizId

class NoSuchBlankQuizException(blankQuizId: BlankQuizId) : Exception("Cannot find BlankQuiz with id: ${blankQuizId.id}")