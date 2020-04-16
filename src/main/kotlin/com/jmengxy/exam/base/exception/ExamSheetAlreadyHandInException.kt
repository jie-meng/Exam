package com.jmengxy.exam.base.exception

import com.jmengxy.exam.base.id.ExamSheetId

class ExamSheetAlreadyHandInException(examSheetId: ExamSheetId) : Exception("ExamSheet ${examSheetId.id} already hand in")