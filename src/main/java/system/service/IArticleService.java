package system.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import system.model.Article;

/**
 * Created by Administrator on 2016/10/28.
 */
public interface IArticleService {

    /**
     * 描述：根据id获取文章
     *
     * @param id 文章唯一标识
     * @return
     * @throws Exception
     */
    Article get(String id) throws Exception;


    /**
     * 描述：修改或者新增文章
     *
     * @param article 文章model
     * @throws Exception
     */
    void saveOrModify(Article article) throws Exception;

    /**
     * 描述：分页获取文章列表
     *
     * @param pageNum  页码
     * @param pageSize 页数
     * @return
     * @throws Exception
     */
    PageInfo<Article> getList(int pageNum, int pageSize) throws Exception;

    /**
     * 描述：删除文章
     *
     * @param id 文章id
     * @return
     * @throws Exception
     */
    boolean remove(String id) throws Exception;
}
