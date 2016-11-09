package service;

import comm.config.SpringTestAutowired;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.*;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.IndicesExists;
import io.searchbox.indices.type.TypeExist;
import io.searchbox.snapshot.CreateSnapshot;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.elastucsearch.common.EsAdvancedService;
import system.elastucsearch.common.RandomHan;
import system.elastucsearch.model.Article;
import system.mapper.ResourceMapper;

import system.model.Resource;
import system.model.ResourceExample;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * 描述：ES测试
 */
public class ESTest extends SpringTestAutowired {
    private static String indexName = "article";
    private static String indexName1 = "blog";
    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private JestClient jestClient;

    @Autowired
    private EsAdvancedService esAdvancedService;

    /**
     * 描述：插入索引
     *
     * @throws Exception
     */
    @Test
//    @Ignore
    public void testSetIndex() throws Exception {
        long start = System.currentTimeMillis();
        IndicesExists indicesExists = new IndicesExists.Builder(indexName1).build();
        JestResult isIndexExist = jestClient.execute(indicesExists);
        //1.判断索引是否存在，存在删除，不存在不处理
        if (isIndexExist != null && !isIndexExist.isSucceeded()) {
            System.out.println("===索引不存在");
            //不存在 不处理
        } else {
            DeleteIndex index = new DeleteIndex.Builder(indexName1).build();
            JestResult result = jestClient.execute(index);
            System.out.println("===索引删除成功");
        }

        //2.创建索引
        JestResult result = jestClient.execute(new CreateIndex.Builder(indexName1).build());

        //3.判断索引创建是否成功
        if (result == null || !result.isSucceeded()) {
            throw new Exception(result.getErrorMessage() + "创建索引失败!");
        }

        //批量插入========================
        Bulk.Builder bulk = new Bulk.Builder();
        //4.插入找数据
        List<Resource> resources = resourceMapper.selectByExample(new ResourceExample());
        for (Resource resource : resources) {
            Index index = new Index.Builder(resource).index(indexName1)
                    .type(indexName1).build();
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
            searchSourceBuilder.query(QueryBuilders.queryStringQuery("虎"));

            Search search = new Search.Builder(searchSourceBuilder.toString())
                    // multiple index or types can be added.
                    .addIndex("blog").addType("type")
                    .build();
            JestResult result = jestClient.execute(search);
            long end = System.currentTimeMillis();
            System.out.println("条记录中,搜索新闻,共用时间 -->> " + (end - start) + " 毫秒");
            List<Resource> sourceAsObjectList = result.getSourceAsObjectList(Resource.class);
            for (Resource resource : sourceAsObjectList) {
                System.out.println(resource.toString());
            }
            System.out.println(result.getSourceAsString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 描述：手动创建类型
     *
     * @throws Exception
     */
    @Test
    public void handCreateType() throws Exception {
        IndicesExists indicesExists = new IndicesExists.Builder(indexName1).build();
        JestResult isIndexExist = jestClient.execute(indicesExists);
        //1.判断索引是否存在，存在删除，不存在不处理
        if (isIndexExist != null && !isIndexExist.isSucceeded()) {
            System.out.println("===索引不存在");
            //不存在 不处理
        } else {
            System.out.println("====索引存在,创建类型");
            //1.创建索引
            Bulk.Builder bulk = new Bulk.Builder();
            Map<String, Object> map = new HashMap<>();
            map.put("天", "为哦哦");
            map.put("地", "tyy");
            Index index = new Index.Builder(map).index(indexName1).type(indexName).build();
            bulk.addAction(index);
            jestClient.execute(bulk.build());
        }
//        //1.创建索引
//        JestResult result = jestClient.execute(new CreateIndex.Builder(indexName1).build());
//        //2.添加值
//        Bulk.Builder bulk = new Bulk.Builder();
//        Map<String, String> map = new HashMap<>();
//        map.put("1", "星期一");
//        map.put("2", "星期二");
//        Index index = new Index.Builder(map).index(indexName1).type(indexName1).build();
//        bulk.addAction(index);
//        jestClient.execute(bulk.build());
//        System.out.println("创建成功");
    }


    /**
     * 描述：删除索引
     *
     * @throws Exception
     */
    @Test
    public void testDeleteIndex() throws Exception {
        boolean falg = esAdvancedService.deleteIndex("article");
        System.out.println(falg ? "删除成功" : "删除失败");
    }

    /**
     * 描述：删除文章
     *
     * @throws Exception
     */
    @Test
    public void testDeleteID() throws Exception {
        esAdvancedService.deleteDoc("AVhIBR12ZzAtJZLzhEHB", "article", "article");
    }

    /**
     * 描述：修改文章/新增文章
     *
     * @throws Exception
     */
    @Test
    public void testUpdata() throws Exception {
        Article article = new Article("123", "123", "123", "123", 123, 123, new Date(), new BigDecimal(1.1));

        esAdvancedService.insertOrUpdateDoc("AVhIBR12ZzAtJZLzhEHC", article, indexName, indexName);
    }

    /**
     * l
     * 描述：删除类型
     *
     * @throws Exception
     */
    @Test
    public void testDeleteType() throws Exception {
        //1.删除类型
        boolean falg = esAdvancedService.deleteType("blog", indexName);
        System.out.println(falg ? "删除成功" : "删除失败");
        //2.判断类型是否存在
        TypeExist typeExist = new TypeExist.Builder("blog").addType(indexName).build();
        JestResult isIndexExist = jestClient.execute(typeExist);
        if (!isIndexExist.isSucceeded()) {
            System.out.println("类型不存在");
        } else {
            System.out.println("类型存在");
        }

    }

    /**
     * 描述：创建索引
     *
     * @throws Exception
     */
    @Test
    public void testCreatIndex() throws Exception {
        boolean flag = esAdvancedService.createIndex("blog");
        System.out.println(flag ? "创建索引成功" : "创建索引失败");
    }

    /**
     * 描述：创建类型数据
     *
     * @throws Exception
     */
    @Test
    public void testCreateType() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("1", "小虎");
        map.put("2", "小猫");
        map.put("3", "小炮");
        boolean flag = esAdvancedService.createType("blog", "type", map);
        System.out.println(flag ? "创建成功" : "创建失败");
    }

    /**
     * 描述：获取索引类型
     *
     * @throws Exception
     */
    @Test
    public void testGetMapping() throws Exception {
        String indexName = "blog";
        String typeName = "type";
        System.out.println(esAdvancedService.getMapping(indexName, typeName));
    }


    /**
     * 描述：创建文章数据
     *
     * @throws Exception
     */
    @Test
    public void testCreateIndex() throws Exception {
        //1.创建索引
        JestResult result = jestClient.execute(new CreateIndex.Builder(indexName).build());
        Bulk.Builder bulk = new Bulk.Builder();

        for (int i = 0; i < 1000; i++) {
            Article article = new Article(String.valueOf(i), RandomHan.getRandomJianHan(100), RandomHan.getRandomJianHan(500), "author" + i, i, i, new Date(), new BigDecimal(1.1));
            Index index = new Index.Builder(article).index(indexName).type(indexName).build();
            bulk.addAction(index);
        }

        jestClient.execute(bulk.build());
    }

    /**
     * 描述：查询文章数据
     *
     * @throws Exception
     */
    @Test
    public void testQueryArticle() throws Exception {

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.queryStringQuery("加书"));
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//                searchSourceBuilder.query(QueryBuilders.multiMatchQuery("加书","title"));
        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex("article").addType("article").setParameter("from",1).setParameter("size",20)
                .build();

//        CreateSnapshot createSnapShot = new CreateSnapshot.Builder("article", "li").build();
//        JestResult execute = jestClient.execute(createSnapShot);
//        System.out.println(execute.getJsonString());
//
//        SearchScroll.Builder builder = new SearchScroll.Builder("12", "加书");
//        Search search = new Search.Builder(builder.toString())
//                .addIndex("article").addType("article")
//                .build();
        JestResult result = jestClient.execute(search);
        System.out.println(result.getJsonObject());

        Update update = new Update.Builder("").build();

        List<Article> sourceAsObjectList = result.getSourceAsObjectList(Article.class);
        for (Article article : sourceAsObjectList) {
            System.out.println(article.toString());
        }

    }
}

