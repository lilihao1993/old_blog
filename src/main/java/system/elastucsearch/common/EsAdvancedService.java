package system.elastucsearch.common;

import com.google.gson.JsonObject;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.*;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.mapping.GetMapping;
import org.elasticsearch.Build;
import org.elasticsearch.action.admin.indices.create.CreateIndexAction;
import org.elasticsearch.index.translog.Translog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 描述：ES 工具类
 */
@Service
public class EsAdvancedService {
    private static final String PWDKEY = "X-SCE-ES-PASSWORD";
    private static Logger logger = LoggerFactory.getLogger(EsAdvancedService.class);

    @Autowired
    private JestClient jestClient;

    /**
     * 创建索引
     *
     * @param indexName
     * @return
     */
    public boolean createIndex(String indexName) {
        CreateIndex createIndex = new CreateIndex.Builder(indexName).build();
        try {
            JestResult result = jestClient.execute(createIndex);
            if (result == null || !result.isSucceeded()) {
                throw new Exception(result.getErrorMessage() + "创建索引失败!");
            }
        } catch (Exception e) {
            logger.error("", e);
            return false;
        }
        return true;
    }

    /**
     * 描述：创建类型
     * @param indexName
     * @param indexType
     * @return
     */
    public boolean CreateType(String indexName,String indexType)throws Exception{
        Cat.IndicesBuilder indicesBuilder = new Cat.IndicesBuilder().addIndex(indexName).addType(indexType);
        CatResult execute = jestClient.execute(indicesBuilder.build());
        System.out.println(execute.getJsonObject().toString());
        return true;
    }

    /**
     * 手动创建类型(map一旦定义创建，field只能新增，不能修改)
     *
     * @param indexName
     * @param indexType
     * @param mappingString
     * @return
     */
    public boolean createType(String indexName, String indexType, Object mappingString) {
        Bulk.Builder bulk = new Bulk.Builder();
        Index index = new Index.Builder(mappingString).index(indexName).type(indexType).build();
        bulk.addAction(index);
        try {
            BulkResult execute = jestClient.execute(bulk.build());
            if (!execute.isSucceeded()) {
                System.out.println(execute.getSourceAsObject(JsonObject.class).toString());
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取索引类型mapping
     *
     * @param typeName 类型名称
     * @return
     */
    public String getMapping(String indexName, String typeName) {
        GetMapping.Builder builder = new GetMapping.Builder();
        builder.addIndex(indexName).addType(typeName);
        try {
            JestResult result = jestClient.execute(builder.build());
            if (result != null && result.isSucceeded()) {
                Map<String,Map<String,String>> map = result.getSourceAsObject(Map.class);

                return result.getSourceAsObject(JsonObject.class).toString();
            }
            logger.error("es get mapping Exception ", result.getErrorMessage());
        } catch (Exception e) {
            logger.error("", e);
        }
        return null;
    }

    /**
     * 删除文档
     *
     * @param indexId
     * @param indexName
     * @param indexType
     */
    public boolean deleteDoc(String indexId, String indexName, String indexType) {
        Delete.Builder builder = new Delete.Builder(indexId);
        builder.refresh(true);
        Delete delete = builder.index(indexName).type(indexType).build();
        try {
            JestResult result = jestClient.execute(delete);
            if (result != null && !result.isSucceeded()) {
                throw new RuntimeException(result.getErrorMessage() + "删除文档失败!");
            }
        } catch (Exception e) {
            logger.error("", e);
            return false;
        }
        return true;
    }

    /**
     * 删除类型
     * 未完善
     * @param indexName
     * @param indexType
     */
    public boolean deleteType(String indexName, String indexType) {
        DeleteIndex delete = new DeleteIndex.Builder(indexName).type(indexType).build();

        try {
            JestResult result = jestClient.execute(delete);
            if (!result.isSucceeded()) {
                throw new RuntimeException(result.getErrorMessage() + "删除类型失败!");
            }
        } catch (Exception e) {
            logger.error("", e);
            return false;
        }
        return true;
    }

    /**
     * 删除索引
     *
     * @param indexName
     */
    public boolean deleteIndex(String indexName) {

        DeleteIndex builder = new DeleteIndex.Builder(indexName).build();
        try {
            JestResult execute = jestClient.execute(builder);
            if (!execute.isSucceeded()) {
                throw new RuntimeException(execute.getErrorMessage() + "删除索引失败!");
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 插入或更新文档
     *
     * @param indexId
     * @param indexObject
     * @param indexName
     * @param indexType
     * @return
     */
    public boolean insertOrUpdateDoc(String indexId, Object indexObject, String indexName, String indexType) {
        Index.Builder builder = new Index.Builder(indexObject);
        builder.id(indexId);
        builder.refresh(true);
        Index index = builder.index(indexName).type(indexType).build();
        try {
            JestResult result = jestClient.execute(index);
            if (result != null && !result.isSucceeded()) {
                throw new RuntimeException(result.getErrorMessage() + "插入更新索引失败!");
            }
        } catch (Exception e) {
            logger.error("", e);
            return false;
        }
        return true;
    }

//    /**
//     * 通过一次查询就可获取查询的结果（分页）及总条数
//     *
//     * @param classType
//     * @param indexName
//     * @param indexType
//     * @param esQuery
//     * @return
//     */
//    public <T extends Result> EsResult<T> search(Class<T> classType, String indexName, String indexType, Page esQuery) {
//        try {
//
//            Search.Builder builder = new Search.Builder(getQueryString(esQuery));
//            builder.addIndex(indexName)
//                    .addType(indexType)
//                    .setParameter("from", esQuery.getPageNum())
//                    .setParameter("size", esQuery.getPageSize())
//            ;
//            if (esQuery.getSort() != null) {
//                builder.addSort(esQuery.getSort());
//            }
//            JestResult jestResult = jestClient.execute(builder.build());
//            int hitCount = jestResult.getJsonObject().get("hits").getAsJsonObject().get("total").getAsInt();
//            EsResult<T> result = new EsResult<T>();
//            result.setTotalNum(hitCount);
//            result.setResultList(jestResult.getSourceAsObjectList(classType));
//            return result;
//        } catch (Exception e) {
//            throw new EsSearchException(e);
//        }
//    }
//
//    private String getQueryString(Page esQuery) {
//        return "{\"query\":" + esQuery.buildQuery().toString() + "}";
//    }
//
//    protected static String getSecret() {
//        long time = System.currentTimeMillis() / 1000;
//        return time + "," + DigestUtils.md5Hex(time + ES_INDEX_PASSWORD).toUpperCase();
//    }
}
