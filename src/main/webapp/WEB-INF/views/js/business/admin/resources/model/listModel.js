/**
 * Created by Administrator on 2016/11/7.
 */
define(['comm/http'], function (http) {

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

    return {
        getTree: getTree
    }
});