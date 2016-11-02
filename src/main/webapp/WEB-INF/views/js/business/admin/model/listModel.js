/**
 * Created by Administrator on 2016/11/1.
 */
define(['comm/http'], function (http) {

    /**
     * 描述：获取类别列表
     * @param options
     */
    function getLabelList(options) {
        http.httpRequest({
            url: "/admin/label/page",
            data: options.data,
            success: function (data) {
                options.callBack(data);
            },
            error: options.error
        });
    }

    /**
     * 描述：删除类别
     * @param options
     */
    function delLabel(options) {
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
        getLabelList: getLabelList,
        delLabel: delLabel
    }
});