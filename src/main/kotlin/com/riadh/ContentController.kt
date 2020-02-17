package com.riadh

import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.query.GetQuery
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/demo")
class ContentController(private val elasticsearchOperations: ElasticsearchOperations,
                        private val indexationService: IndexationService) {

    @PostMapping("/content")
    fun save(@RequestBody content: Content): String? {
        val indexQuery = IndexQueryBuilder()
                .withId(content.id.toString())
                .withObject(content)
                .build()
        return elasticsearchOperations.index(indexQuery)
    }

    @GetMapping("/content/{id}")
    fun findById(@PathVariable("id") id: Long): Content? {
        return elasticsearchOperations
                .queryForObject(GetQuery.getById(id.toString()), Content::class.java)
    }


    @PostMapping("/request-index")
    fun requestIndex(@RequestBody content: Content): String? {
        return indexationService.requestIndex().toString()
    }

}