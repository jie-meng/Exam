package com.jmengxy.exam.base.type

interface ValueObject<T> {
    fun sameValueAs(other: T): Boolean
}