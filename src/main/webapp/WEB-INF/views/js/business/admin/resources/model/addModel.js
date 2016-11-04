/**
 * Created by Administrator on 2016/11/3.
 */
define(['comm/http'], function (http) {
    function saveResource(options) {
        http.httpRequest({
            url: "/admin/resource/add",
            type: "post",
            data: options.data,
            success: function (data) {
                options.callBack(data);
            },
            error: options.error
        });
    }

    return {
        saveResource: saveResource
    }
});