package service;

import comm.config.SpringTestAutowired;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.junit.Test;
import system.elastucsearch.client.CreateES;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by Administrator on 2016/11/10.
 */
public class NoJestTest extends SpringTestAutowired {
    private static Settings settings = Settings.settingsBuilder()
            .put("client.transport.sniff", true)//这个客户端可以嗅到集群的其它部分，并将它们加入到机器列表。为了开启该功能，设置client.transport.sniff为true。
            .put("cluster.name", "video")
            .build();
    private Client client = TransportClient.builder().settings(settings).build().addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9200));

    public NoJestTest() throws UnknownHostException {
    }

    /**
     * 描述：创建Es
     *
     * @throws Exception
     */
    @Test
    public void testCreateEs() throws Exception {
        CreateES client = new CreateES();
    }


    /**
     * 描述：创建索引
     *
     * @throws Exception
     */
    @Test
    public void testCreateIndex() throws Exception {
        XContentBuilder builder = jsonBuilder()
                .startObject()
                .field("user", "kimchy")
                .field("postDate", new Date())
                .field("message", "trying out Elasticsearch")
                .endObject();
        client.prepareIndex("one", "temp").setSource(builder).get();
    }

}
