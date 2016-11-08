package service;

import comm.config.SpringTestAutowired;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.IndicesExists;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.mapper.ResourceMapper;
import system.model.Resource;
import system.model.ResourceExample;

import java.io.IOException;
import java.util.List;

/**
 * 描述：ES测试
 */
public class ESTest extends SpringTestAutowired {
    private static String indexName = "test";

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private JestClient jestClient;

    /**
     * 描述：插入索引
     *
     * @throws Exception
     */
    @Test
//    @Ignore
    public void testSetIndex() throws Exception {
        long start = System.currentTimeMillis();
        IndicesExists indicesExists = new IndicesExists.Builder(indexName).build();
        JestResult isIndexExist = jestClient.execute(indicesExists);
        //1.判断索引是否存在，存在删除，不存在不处理
        if (isIndexExist != null && !isIndexExist.isSucceeded()) {
            System.out.println("===索引不存在");
            //不存在 不处理
        } else {
            DeleteIndex index = new DeleteIndex.Builder(indexName).build();
            JestResult result = jestClient.execute(index);
            System.out.println("===索引删除成功");
        }

        //2.创建索引
        JestResult result = jestClient.execute(new CreateIndex.Builder(indexName).build());

        //3.判断索引创建是否成功
        if (result == null || !result.isSucceeded()) {
            throw new Exception(result.getErrorMessage() + "创建索引失败!");
        }
        Bulk.Builder bulk = new Bulk.Builder();
        //4.查找数据
        List<Resource> resources = resourceMapper.selectByExample(new ResourceExample());
        for (Resource resource:resources) {
            Index index = new Index.Builder(resource).index(indexName)
                    .type(indexName).build();
            bulk.addAction(index);
        }

        jestClient.execute(bulk.build());
        long end = System.currentTimeMillis();
        System.out.println("共用时间   " + (end - start) + " 毫秒");
    }

    /**
     * 描述：搜索数据
     *
     * @throws Exception
     */
    @Test
    public void testGetIndex() throws Exception {
        try {
            long start = System.currentTimeMillis();
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(QueryBuilders.queryStringQuery("管理"));

            Search search = new Search.Builder(searchSourceBuilder.toString())
                    // multiple index or types can be added.
                    .addIndex("test")
                    .addIndex("test")
                    .build();
            JestResult result = jestClient.execute(search);
            long end = System.currentTimeMillis();
            System.out.println("条记录中,搜索新闻,共用时间 -->> " + (end - start) + " 毫秒");
            List<Resource> sourceAsObjectList = result.getSourceAsObjectList(Resource.class);
            for (Resource resource:sourceAsObjectList) {
                System.out.println(resource.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

