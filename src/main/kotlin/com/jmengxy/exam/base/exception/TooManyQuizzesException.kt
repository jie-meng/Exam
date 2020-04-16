package com.jmengxy.exam.base.exception

import java.lang.IllegalArgumentException

class TooManyQuizzesException(count: Int) : IllegalArgumentException("quizzes count $count bigger than 20")
