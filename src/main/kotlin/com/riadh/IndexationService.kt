package com.riadh

import org.elasticsearch.action.index.IndexRequest
import org.elasticsearch.action.index.IndexResponse
import org.elasticsearch.action.support.WriteRequest
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RestHighLevelClient
import org.springframework.stereotype.Service
import java.util.Collections.singletonMap


@Service
class IndexationService(val elasticsearchClient: RestHighLevelClient) {

    fun requestIndex(): IndexResponse {
        val request: IndexRequest = IndexRequest("spring-data", "elasticsearch", "testId")
                .source(singletonMap("feature", "high-level-rest-client"))
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)

        return elasticsearchClient.index(request, RequestOptions.DEFAULT)
    }
}