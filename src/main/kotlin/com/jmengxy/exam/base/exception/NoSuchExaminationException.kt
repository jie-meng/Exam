package com.jmengxy.exam.base.exception

import com.jmengxy.exam.base.id.ExaminationId

class NoSuchExaminationException(examinationId: ExaminationId) : Exception("Cannot find Examination with id: ${examinationId.id}")