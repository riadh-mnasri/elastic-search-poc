package com.riadh

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ElasticSearchSampleApplication

fun main(args: Array<String>) {
	runApplication<ElasticSearchSampleApplication>(*args)
}
