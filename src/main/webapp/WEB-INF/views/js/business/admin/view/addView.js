/**
 * 通用基础js
 */
define(['business/admin/model/addModel', 'comm/util', 'jquery', 'laydate', 'layedit', 'pagination', 'jquery.validate', 'comm/validateRules'], function (model, util) {

    /**
     * 渲染
     */
    function init(layer) {
        //初始化分页条
        _getFirstPage();
        //事件绑定
        _bind(layer);
    }


    /**
     * 事件绑定
     * @private
     */
    function _bind(layer) {
        util.bindEvents([
            {
                el: '#add',
                event: 'click',
                handler: function () {
                    if (_formValid().form()) {
                        // 保存类别
                        _saveLabel($("#name").val(), layer);
                    }
                }
            }
        ])
    }

    /**
     * 描述：保存类别
     * @private
     */
    function _saveLabel(name, layer) {
        model.saveLabel({
            data: {
                name: name
            },
            callBack: function (data) {
                if (data.data) {
                    //跳转到list页面
                    layer.alert("保存成功");
                } else {
                    //弹出保存错误信息
                    layer.alert("保存失败,请重试", {time: 500});
                }
            },
            error: function (jqXHR) {
                layer.alert('操作失败，请重试');
            }
        });
    }

    /**
     * 描述：validate验证
     * @private
     */
    function _formValid() {
        return $('#label-form').validate({
            rules: {
                name: {
                    isChinese: true,
                    required: true,
                    minlength: 2
                }
            }, messages: {
                name: {
                    isChinese: "必须是中文",
                    required: "不可为空",
                    minlength: "不可少于2个字符"

                }
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
