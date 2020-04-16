package com.jmengxy.exam.base.exception

import java.lang.IllegalArgumentException

class IllegalScoreException(private val score: Int) : IllegalArgumentException("score $score bigger than 100")