package system.service;

import system.model.Article;
import system.model.ArticleExample;

import java.util.List;

/**
 * 描述:文章service
 */
public interface IArticleService {

    /**
     * 描述：获取文章列表
     *
     * @return
     */
    List<Article> getArticleList(ArticleExample articleExample) throws Exception;

    /**
     * 描述：插入文章
     *
     * @return
     * @throws Exception
     */
    boolean insertArticle(Article article) throws Exception;

    /**
     * 描述：根据id删除文章
     *
     * @return
     * @throws Exception
     */
    boolean deleteArticle(String id) throws Exception;

    /**
     * 描述：修改文章信息
     *
     * @param article
     * @return
     * @throws Exception
     */
    boolean modifyArticle(Article article) throws Exception;

}
