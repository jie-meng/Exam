package com.jmengxy.exam.base.exception

import com.jmengxy.exam.base.id.PaperId

class NoSuchPaperException(paperId: PaperId) : Exception("Cannot find Paper with id: ${paperId.id}")