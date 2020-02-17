#POC Elastic Search with Spring
This project allows Indexing and searching for a content
## Prerequisites
Launch Elastic Search in Docker

```
docker pull docker.elastic.co/elasticsearch/elasticsearch:7.5.2

docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.5.2


```

Launch followings urls via Postman :

```
http://localhost:8181/demo/content

{
"id": 1,
"text": "test"
}

http://localhost:8181/demo/content/1

```