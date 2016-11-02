/**
 * Created by Administrator on 2016/10/26.
 */
/**
 * 通用基础js
 */
define(['jquery', 'comm/util', 'laydate', 'layedit', 'jquery.validate'], function ($, util) {

    /**
     * 渲染
     */
    function init(layer) {
        //事件绑定
        _bind(layer);

    }

    /**
     * 事件绑定
     * @private
     */
    function _bind(layer) {
        var laydate = layui.laydate;
        util.bindEvents([{
            el: 'div ul li',
            event: 'click',
            handler: function () {
                $(this).children("ul").toggle("normal");
            }
        }]);
    }
    
    return {
        init: init
    };
});