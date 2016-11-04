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
            el: '.open',
            event: 'click',
            handler: function () {
                var open = $(this).next();
                var status = open.css("display");
                if (status == 'none') {
                    open.show(500);
                } else {
                    open.hide(500);
                }
            }
        }, {
            el: 'li',
            event: 'click',
            handler: function () {
                var url = $(this).attr("js-url");
                if (url == '#') {
                    layer.msg("请为此子级设置连接！", {icon: 0, time: 500});
                    return;
                }
                $("iframe").attr("src", url);
            }
        }
        ]);
    }

    return {
        init: init
    };
});