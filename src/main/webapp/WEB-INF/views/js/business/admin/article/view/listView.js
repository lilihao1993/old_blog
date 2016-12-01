/**
 * Created by Administrator on 2016/11/22.
 */
/**
 * 通用基础js
 */
define(['business/admin/article/model/listModel', 'comm/util', 'handlebars', 'jquery', 'laydate', 'layedit', 'comm/hbsHelper', 'pagination', 'jquery.validate', 'comm/validateRules'], function (model, util, handlebars) {
    var pageSize = 5;
    var layer = '';

    /**
     * 渲染
     */
    function init(layers) {
        layer = layers;
        //初始化分页条
        _getFirstPage();
        //事件绑定
        _bind();
    }

    /**
     * 事件绑定
     * @private
     */
    function _bind() {
        util.bindEvents([
            {
                el: '.delete',
                event: 'click',
                handler: function () {
                    var id = $(this).attr("article-id");
                    window.parent.layer.confirm("确认删除本类别？", {icon: 3, title: "提示"}, function () {
                        _delArticle(id);
                        layer.closeAll('dialog');
                        window.location.reload();
                    });
                }
            }
        ])
    }


    /**
     * 删除文章
     * @param id 文章id
     * @private
     */
    function _delArticle(id) {
        model.delArticle({
            data: {
                id: id
            }, callBack: function (data) {
                if (data) {
                    window.parent.layer.alert("文章已删除！")
                } else {
                    window.parent.layer.alert("删除失败,请重试");
                }
            }, error: function (jqXHR) {
                window.parent.layer.alert('操作失败，请重试');
            }
        });
    }

    /**
     * 分页配置参数
     * @param data
     * @param index
     * @private
     */
    function _pagination(total, index) {
        $('#pagination').pagination(total, {
            items_per_page: pageSize,
            prev_text: '<i class="icon-triangle-left"></i>上一页',
            next_text: '下一页<i class="icon-triangle-right"></i>',
            num_display_entries: 6,
            num_edge_entries: 2,
            current_page: index,
            link_to: 'javascript:void(0)',
            ellipse_text: '...',
            first_text: '首页',
            last_text: '末页',
            callback: _pageSelectCallback
        });
    }


    /**
     * 描述：分页获取文章列表
     * @param pageNum
     * @private
     */
    function _getArticleList(pageNum) {
        model.getArticleList({
            data: {
                pageNum: pageNum + 1,
                pageSize: pageSize
            }, callBack: function (data) {
                //总条数
                var total = data.data.total;
                //创建模板
                var template = handlebars.compile($('#listTemplate').html());
                //插入模板
                $('#js-tbody').html(template(data.data));
                //分页
                _pagination(total, pageNum);
            }, error: function (jqXHR) {
                window.parent.layer.alert('操作失败，请重试');
            }
        });
    }

    /**
     * 点击分页的回调函数
     * @param pageNum   当前点击的那个分页的页数索引值
     * @param jq        装载容器
     * @private
     */
    function _pageSelectCallback(pageNum, jq) {
        $('html,body').animate({scrollTop: 0}, 10);
        _getArticleList(pageNum);
    }


    /**
     * 渲染初始分页首页
     * @private
     */
    function _getFirstPage() {
        var itemCount = $("#itemCount").text();
        _pagination(itemCount, 0);
    }

    return {
        init: init
    };
});