package io.pivotal.cf.broker.es;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Value("${hostname}")
    private String hostname;

//    @Bean
//    ElasticsearchClient client() throws UnknownHostException {
//        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("search-jarednav-t6bwfsrzhvfufhwugtxacskuue.us-east-1.es.amazonaws.com"), 9300));
//
//        return client;
//    }

    @Bean
    JestClient client() {
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig.Builder(hostname)
                .multiThreaded(true)
                .build());
        JestClient client = factory.getObject();
        return client;
    }
}
