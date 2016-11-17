/**
 * Created by Administrator on 2016/11/3.
 */
define(['business/admin/resources/model/addModel', 'comm/util', 'jquery', 'laydate', 'layedit', 'pagination', 'jquery.validate', 'comm/validateRules'], function (model, util) {

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
                        _saveResource($("#name").val(), $("#url").val(), $("#status input:checked").val(), $("#level input:checked").val(), $("select option:selected").val());
                    }
                }
            }
        ])
    }

    /**
     * 描述：保存资源
     * @param name
     * @param url
     * @param status
     * @param level
     * @private
     */
    function _saveResource(name, url, status, level, parentId) {
        model.saveResource({
            data: {
                name: name,
                url: url,
                status: status,
                level: level,
                parentId: parentId
            },
            callBack: function (data) {
                if (data.data) {
                    layer.msg("保存成功", {icon: 1, time: 500}, function () {
                        top.location = "/admin/system?id=57c78c22a4bc11e6a2c0fcaa14e16be9";
                    });

                } else {
                    layer.msg("保存失败", {icon: 0, tion: 500})
                }
            }, error: function (jqXHR) {
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
                },
                url: {
                    required: true
                }
            }, messages: {
                name: {
                    isChinese: "必须是中文",
                    required: "不可为空",
                    minlength: "不可少于2个字符"

                },
                url: {
                    required: "不可为空"
                }
            }
        });
    }


    return {
        init: init
    };
});