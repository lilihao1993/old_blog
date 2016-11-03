/**
 * 通用基础js
 */
define(['business/admin/label/model/listModel', 'comm/util', 'handlebars', 'laydate', 'comm/hbsHelper', 'layedit', 'pagination', 'jquery.validate', 'comm/validateRules'], function (model, util, handlebars) {

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
                el: '#add',
                event: 'click',
                handler: function () {

                }
            }, {
                el: '.js-del',
                event: 'click',
                handler: function () {
                    var id = $(this).attr("label-id")
                    layer.confirm("确认删除本类别？", {icon: 3, title: "提示"}, function () {
                        _delLabel(id);
                        layer.closeAll('dialog');
                        window.location.reload();
                    });
                }
            }
        ])
    }

    /**
     * 描述：删除类别
     * @param id 类别id
     * @private
     */
    function _delLabel(id) {
        model.delLabel({
            data: {
                id: id
            }, callBack: function (data) {
                if (data) {
                    return true;
                } else {
                    layer.alert("删除失败,请重试");
                }
            }, error: function (jqXHR) {
                layer.alert('操作失败，请重试');
            }
        });
    }


    /**
     * 描述：分页获取类别列表
     * @private
     */
    function _getLabelList(pageNum) {

        model.getLabelList({
            data: {
                pageNum: pageNum + 1,
                pageSize: pageSize
            }, callBack: function (data) {
                //总条数
                var total = data.data.total;
                //创建模板
                var template = handlebars.compile($('#listTemplate').html());
                //插入模板
                $('.js-tbody').html(template(data.data));
                //分页
                _pagination(total, pageNum);
            }, error: function (jqXHR) {
                layer.alert('操作失败，请重试');
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
     * 点击分页的回调函数
     * @param pageNum   当前点击的那个分页的页数索引值
     * @param jq        装载容器
     * @private
     */
    function _pageSelectCallback(pageNum, jq) {
        $('html,body').animate({scrollTop: 0}, 10);
        _getLabelList(pageNum);
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
