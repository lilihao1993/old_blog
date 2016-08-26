package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.mapper.ArticleMapper;
import system.model.Article;
import system.model.ArticleExample;
import system.service.IArticleService;

import java.util.List;

/**
 * 描述：文章service
 */
@Service
public class ArticleService implements IArticleService {

    /**
     * 注入
     */
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 描述：获取文章列表
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Article> getArticleList(ArticleExample articleExample) throws Exception {
        List<Article> list = articleMapper.selectByExample(articleExample);
        return list;
    }

    /**
     * 描述：插入文章
     *
     * @param article
     * @return
     * @throws Exception
     */
    @Override
    public boolean insertArticle(Article article) throws Exception {
        int flg = articleMapper.insert(article);
        return flg == 0 ? false : true;
    }

    /**
     * 描述：根据id删除文章
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteArticle(String id) throws Exception {
        int flg = articleMapper.deleteByPrimaryKey(id);
        return flg == 0 ? false : true;
    }

    /**
     * 描述：修改文章
     *
     * @param article
     * @return
     * @throws Exception
     */
    @Override
    public boolean modifyArticle(Article article) throws Exception {
        int flg = articleMapper.updateByPrimaryKey(article);
        return flg == 0 ? false : true;
    }
}
