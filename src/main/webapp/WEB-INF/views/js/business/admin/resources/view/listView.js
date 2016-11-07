/**
 * Created by Administrator on 2016/11/7.
 */
define(['business/admin/resources/model/listModel', 'comm/util', 'jquery', 'laydate', 'layedit', 'pagination', 'jquery.validate', 'comm/validateRules'], function (model, util) {
    var layer = '';

    /**
     * 渲染
     */
    function init(layers) {
        layer = layers;
        //树形
        _tree();
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
                el: '',
                event: '',
                handler: function () {

                }
            }
        ])
    }

    /**
     * 描述：树形
     * @param layer
     * @private
     */
    function _tree() {
        model.getTree({
            callBack: function (data) {
                console.log(JSON.stringify(data.data));
                layui.tree({
                    elem: '#tree',
                    nodes: [JSON.stringify(data.data)]
                });

            }, error: function (jqXHR) {
                layer.alert('操作失败，请重试');
            }
        });
    }

    return {
        init: init
    };
});