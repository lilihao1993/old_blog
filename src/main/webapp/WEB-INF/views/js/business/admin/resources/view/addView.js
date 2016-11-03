/**
 * Created by Administrator on 2016/11/3.
 */
define(['business/admin/label/model/addModel', 'comm/util', 'jquery', 'laydate', 'layedit', 'pagination', 'jquery.validate', 'comm/validateRules'], function (model, util) {

    var layer = '';

    /**
     * 渲染
     */
    function init(layers) {
        layer = layers;
        //事件绑定
        _bind(layer);
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
                    if (_formValid().form()) {
                        // 保存类别
                        _saveResource($("#name").val(),$("#url").val(),$("#status"));
                    }
                }
            }
        ])
    }


    function _saveResource() {

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
                },
                url: {
                    required: true,
                    minlength: 2
                }
            }, messages: {
                name: {
                    isChinese: "必须是中文",
                    required: "不可为空",
                    minlength: "不可少于2个字符"

                },
                url: {
                    required: "不可为空",
                    minlength: "不可少于2个字符"
                }
            }
        });
    }


    return {
        init: init
    };
});