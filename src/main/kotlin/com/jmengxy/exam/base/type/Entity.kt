package com.jmengxy.exam.base.type

interface Entity<T> {
    fun sameIdentityAs(other: T): Boolean {
        return this === other
    }
}