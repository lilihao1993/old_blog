package system.elastucsearch.common;


import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：初始化连接es服务端
 */
@Configuration
public class InitES {


    /**
     * 配置jest客户端,到时使用spring时,可以用配置方式 ,现在暂时使用new ...
     *
     * @return
     */
    @Bean
    public HttpClientConfig httpClientConfig() {
        String connectionUrl = "http://localhost:9200";
//        String connectionUrl = "http://192.168.5.115:9200";
        HttpClientConfig httpClientConfig = new HttpClientConfig.Builder(connectionUrl).multiThreaded(true).build();
        return httpClientConfig;
    }

    /**
     * 描述：获取一个jest的对象
     *
     * @return
     */
    @Bean
    public JestClient jestClient() {
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(httpClientConfig());
        return factory.getObject();
    }
}
