/**
 * http请求工具
 */
define(['jquery', 'layer1', 'comm/util', 'comm/dom'], function ($, layer, util, dom) {

    layer.config({
        path: '/js/lib/layer/' //layer.js所在的目录，可以是绝对目录，也可以是相对目录
    });

    // http请求队列
    var httpQueue = [];

    // 默认值
    var defaultOpt = {
        async: true,
        dataType: 'json',
        type: 'get',
        serializable: false
    };

    /**
     * 组装http请求参数
     * @param options
     * {
     *  interface: 接口名称
     *  type:get/post  请求类型
     *  data:{},  业务参数
     *  serializable:true/false,  是否需要序列号
     *  actionConfig:{   默认动作配置
     *      dom:xxx,
     *      type:1/2/3
     *      }
     * }
     * *  actionErrorConfig:{   默认异常配置
     *      dom:xxx,
     *      type:1/2/3
     *      }
     * }
     * @returns {void|*}
     */
    function generateHttpParam(options) {
        // 参数合并
        var opt = $.extend({}, defaultOpt, options);

        //执行默认动作
        if (opt.actionConfig) {
            opt.beforeSend = function () {
                dom.showPlaceholder(opt.actionConfig.dom, opt.actionConfig.type);
            }
        }

        // 获取请求地址
        opt.url = generateUrl(options.url);
        // 成功回调
        opt.success = function (data) {
            // 执行默认动作
            if (opt.actionConfig) {
                dom.removePlaceholder(opt.actionConfig.dom);
            }

            // 执行默认异常动作
            if (opt.actionConfig && data.status != '200') {
                dom.showPlaceholder(opt.actionConfig.dom, opt.actionConfig.type);
                return;
            }

            // 成功回调
            options.success && options.success(data);
        };
        // 失败回调
        opt.error = function (jqXHR, textStatus, errorThrown) {
            // 登录状态失效
            if (jqXHR.status == 401) {
                layer.msg(jqXHR.responseText, {time: 2000, icon: 2,shade: 0.3}, function () {
                    window.location.href = __LINKSGOOD_EINVOICE__.root_url + "logout";
                });
                return;
            }

            if (opt.actionErrorConfig) {
                dom.showPlaceholder(opt.actionErrorConfig.dom, opt.actionErrorConfig.type);
            }

            options.error && options.error(jqXHR, textStatus, errorThrown);
        };
        // json参数序列化
        if (opt.serializable) {
            opt.contentType = 'application/json';
            opt.data = JSON.stringify(opt.data);
        }

        //返回
        return opt;
    }

    /**
     * 组装http请求url
     * @param interface
     */
    function generateUrl(url) {
        var p = {
            // 增加时间戳，解决IE浏览器ajax请求缓存问题
            _t: new Date().getTime()
        };
        var operator = /\?/gi.test(url) ? '&' : '?';
        return url + operator + $.param(p);
    }

    /**
     * http get请求
     * @param options
     */
    function httpRequest(options) {
        var ajax = $.ajax(generateHttpParam(options));
        httpQueue.push(ajax);
        return ajax;
    }

    // 返回
    return {
        httpRequest: httpRequest
    };
});