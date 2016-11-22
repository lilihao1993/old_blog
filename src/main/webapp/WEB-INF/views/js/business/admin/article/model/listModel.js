/**
 * Created by Administrator on 2016/11/21.
 */
define(['comm/http'], function (http) {

    /**
     * 描述：删除文章
     * @param options
     */
    function delArticle(options) {
        http.httpRequest({
            url: "/admin/article/delete",
            type: "post",
            data: options.data,
            success: function (data) {
                options.callBack(data);
            },
            error: options.error
        });
    }

    /**
     * 描述：分页获取列表
     * @param options
     */
    function getArticleList(options) {
        http.httpRequest({
            url: "/admin/article/pagelist",
            type: "get",
            data: options.data,
            success: function (data) {
                options.callBack(data);
            },
            error: options.error
        });
    }

    return {
        delArticle: delArticle,
        getArticleList: getArticleList
    }
});