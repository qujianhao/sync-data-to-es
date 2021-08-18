package com.miao.cloud.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author qujianhao
 * @date 2021/8/17 15:54
 */
@Configuration
public class ElasticSearchConfig{

    private String USERNAME = "cloud";
    private String PASSWORD = "fUZMy8n#";
    private String URLS = "127.0.0.1:9001";// 多个用逗号分割

    @Bean
    public RestHighLevelClient restHighLevelClient() {

//        RestHighLevelClient client = new RestHighLevelClient(
//                RestClient.builder(
//                        new HttpHost("127.0.0.1", 9200, "http")));


        if (StringUtils.isEmpty(URLS)) {
            throw new RuntimeException("配置有问题，elasticsearch.urls为空");
        }
        String[] urls = URLS.split(",");
        HttpHost[] httpHostArr = new HttpHost[urls.length];
        for (int i=0; i<urls.length; i++) {
            String urlStr = urls[i];
            if(StringUtils.isEmpty(urlStr)) {
                continue;
            }
            httpHostArr[i] = HttpHost.create(urlStr);
        }

        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(USERNAME, PASSWORD));  //es账号密码
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(httpHostArr)
                        .setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
                            @Override
                            public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
                                httpClientBuilder.disableAuthCaching();
                                return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
                            }
                        }));
        return client;
    }

}
