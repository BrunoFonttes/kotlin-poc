package com.poc.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface Logging

fun getLogger(forClass: Class<*>): Logger =
    LoggerFactory.getLogger(forClass)

inline fun <reified T : Logging> T.logger(): Logger =
    getLogger(T::class.java)