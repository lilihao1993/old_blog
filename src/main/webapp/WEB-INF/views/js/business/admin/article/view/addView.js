/**
 * Created by Administrator on 2016/11/21.
 */
/**
 * 通用基础js
 */
define(['business/admin/label/model/addModel', 'comm/util', 'jquery', 'laydate', 'layedit', 'pagination', 'jquery.validate', 'comm/validateRules'], function (model, util) {

    /**
     * 渲染
     */
    function init() {
        //百度编辑器
        _ueditor();
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

                    if (_formValid()) {

                        $("#label-form").submit();
                    }
                }
            }, {
                el: '#cancel',
                event: 'click',
                handler: function () {
                    //跳转至文章列表页
                    top.location = "/admin/system?id=dd224137ac9711e685e3fcaa14e16be9";
                }
            }
        ])
    }

    /**
     * 描述：百度编辑器
     * @private
     */
    function _ueditor() {
        var ue = UE.getEditor('container', {
            // toolbars: [
            //     ['fullscreen', 'source', 'undo', 'redo', 'bold']
            // ],
            // autoHeightEnabled: true,
            // autoFloatEnabled: true,
            initialFrameHeight: 300
        });

    }

    /**
     * 描述：validate验证
     * @private
     */
    function _formValid() {
        return $('#label-form').validate({
            rules: {
                title: {
                    required: true
                },
                summary: {
                    required: true
                },
                content: {
                    require: true
                }
            }, messages: {
                title: {
                    required: "不可为空"
                },
                summary: {
                    required: "不可为空"
                },
                content: {
                    required: "不可为空"
                }
            }
        }).form();
    }

    return {
        init: init
    };
});