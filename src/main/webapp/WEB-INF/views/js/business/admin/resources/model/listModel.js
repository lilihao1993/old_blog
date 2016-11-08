/**
 * Created by Administrator on 2016/11/7.
 */
define(['comm/http'], function (http) {

    /**
     * 描述：获取树
     * @param options
     */
    function getTree(options) {
        http.httpRequest({
            url: "/admin/resource/gethomelist",
            data: options.data,
            success: function (data) {
                options.callBack(data);
            },
            error: options.error
        });
    }

    /**
     * 描述：获取资源
     * @param options
     */
    function getResource(options) {
        http.httpRequest({
            url: "/admin/resource/get",
            data: options.data,
            success: function (data) {
                options.callBack(data);
            },
            error: options.error
        });
    }

    return {
        getTree: getTree,
        getResource: getResource
    }
});