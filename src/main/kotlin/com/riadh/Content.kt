package com.riadh

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "demo")
data class Content(@Id val id: Long, val text: String)