package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import system.mapper.ArticleMapper;
import system.model.Article;
import system.service.IArticleService;

import java.util.Date;

/**
 * Created by Administrator on 2016/10/28.
 */
@Service
public class AriticleServiceImpl implements IArticleService {

    /**
     * mapper 注入
     */
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 描述：根据id 获取文章
     *
     * @param id 文章唯一标识
     * @return
     * @throws Exception
     */
    @Override
    public Article get(String id) throws Exception {
        return articleMapper.selectByPrimaryKey(id);
    }

    /**
     * 描述：修改或者新增文章
     *
     * @param article 文章model
     * @throws Exception
     */
    @Override
    public void saveOrModify(Article article) throws Exception {
        //1.设置操作时间
        article.setOperateTime(new Date());
        //2.如果文章id为空 新增文章
        if (StringUtils.isEmpty(article.getId())) {
            article.setCreateTime(article.getOperateTime());
            //插入文章
            articleMapper.insert(article);
        } else {
            //修改文章
            articleMapper.updateByPrimaryKey(article);
        }
    }
}
