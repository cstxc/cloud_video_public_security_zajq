package com.zjxc.video.etldata.online.esClient;/*
 *@ClassName  esClientTest
 *@description    TODO
 *@author     cs_txc@aliyun.com
 *@date   2021/4/12  14:38
 *@version 1.0
 */

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;


public class esClientSearchTest {
    public static void main(String[] args) throws IOException {
        //创建客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("60.191.244.45", 9200, "http"))
        );

        GetRequest request = new GetRequest();
//        request.

//        restHighLevelClient.get()

        //关闭
        restHighLevelClient.close();

    }
}
