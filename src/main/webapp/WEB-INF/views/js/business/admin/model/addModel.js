/**
 * Created by Administrator on 2016/10/31.
 */
define(['comm/http'], function (http) {

    function saveLabel(options) {
        http.httpRequest({
            url: "/admin/label/delete",
            type: "post",
            data: options.data,
            success: function (data) {
                options.callBack(data);
            },
            error: options.error
        });
    }


    return {
        saveLabel: saveLabel
    }
});