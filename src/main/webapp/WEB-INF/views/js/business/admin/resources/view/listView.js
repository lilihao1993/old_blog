/**
 * Created by Administrator on 2016/11/7.
 */
define(['business/admin/resources/model/listModel', 'comm/util', 'handlebars', 'jquery', 'laydate', 'layedit', 'pagination', 'jquery.validate', 'comm/validateRules'], function (model, util, handlebars) {
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
                //生成树
                layui.tree({
                    elem: '#tree',
                    nodes: data.data,
                    click: function (node) {
                        //点击显示资源
                        _getResource(node.id);
                    }
                });

            }, error: function (jqXHR) {
                layer.alert('操作失败，请重试');
            }
        });
    }

    /**
     * 描述：获取资源
     * @param id
     * @private
     */
    function _getResource(id) {
        model.getResource({
            data: {id: id},
            callBack: function (data) {
                var resource = data.data.resource;
                var temp = [];
                temp.push({iname:resource.name,iid:resource.id,iurl:resource.url,istatus:resource.status,ilevel:resource.level,iparentid:resource.parentId,
                    list:data.list})
                console.log(temp);
                //创建模板
                var template = handlebars.compile($('#listTemplate').html());
                //插入模板
                $('#resource').html(template(temp[0]));
            }, error: function (jqXHR) {
                window.parent.layer.alert('操作失败，请重试');
            }
        });
    }

    return {
        init: init
    };
});