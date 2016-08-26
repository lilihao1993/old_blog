package system.service;

import comm.config.SpringTestAutowired;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.enums.EArticle;
import system.model.Article;
import system.model.ArticleExample;

import java.util.Date;
import java.util.List;

/**
 * 文章service测试
 */
public class ArticleServiceTest extends SpringTestAutowired {

    /**
     * 注入
     */
    @Autowired
    private IArticleService articleService;


    /**
     * 描述：插入文章
     */
    @Test
    public void TestInsertArticle() throws Exception {
        Article article = new Article();
        article.setUserId("12341");
        article.setTitle("文章标题springmvc技巧...");
        article.setLabelId("springmvc");
        article.setAriticleType(EArticle.Article_Type_Language.getValue());
        article.setContent("文章内容......");
        article.setUrl("url");
        article.setCreateTime(new Date());
        article.setOperationTime(new Date());
        article.setSummary("摘要信息");
        article.setReadAmount(0);
        boolean flg = articleService.insertArticle(article);
        System.out.println(flg?"插入成功":"插入失败");
    }

    /**
     * 描述：查询文章列表
     * @throws Exception
     */
    @Test
    public void TestSelectArticleList()throws Exception{
        ArticleExample articleExample = new ArticleExample();
        articleExample.setDistinct(true);
        articleExample.setOrderByClause("BA_CREATE_TIME");
        List<Article> articleList = articleService.getArticleList(articleExample);
        for (Article article: articleList) {
            System.out.println(article.toString());
        }
    }
}
