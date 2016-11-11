package system.elastucsearch.client;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 描述：ES非jest
 */
public class CreateES {

    private Client client;
    public static Settings settings = Settings.settingsBuilder()
            .put("client.transport.sniff", true)//这个客户端可以嗅到集群的其它部分，并将它们加入到机器列表。为了开启该功能，设置client.transport.sniff为true。
            .put("cluster.name", "video")
            .build();

    public CreateES() throws UnknownHostException {
        client = TransportClient.builder()
                .settings(settings)
                .build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9200));
    }

    public Client getClient() {
        return client;
    }
}
