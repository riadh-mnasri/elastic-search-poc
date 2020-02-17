package com.riadh

import org.elasticsearch.client.RestHighLevelClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.support.DefaultConversionService
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration
import org.springframework.data.elasticsearch.core.ElasticsearchEntityMapper
import org.springframework.data.elasticsearch.core.EntityMapper


@Configuration
class ElasticSearchConfig: AbstractElasticsearchConfiguration() {

    @Bean
    override fun elasticsearchClient(): RestHighLevelClient? {
        val clientConfiguration = ClientConfiguration.builder()
                .connectedToLocalhost()
                //.connectedTo("localhost:9200")
                .build()
        return RestClients.create(clientConfiguration).rest()
    }

    @Bean
    override fun entityMapper(): EntityMapper? {
        val entityMapper = ElasticsearchEntityMapper(
                elasticsearchMappingContext(), DefaultConversionService()
        )
        entityMapper.setConversions(elasticsearchCustomConversions())
        return entityMapper
    }
}