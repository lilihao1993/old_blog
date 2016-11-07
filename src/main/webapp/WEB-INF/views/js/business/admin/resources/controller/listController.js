/**
 * Created by Administrator on 2016/11/7.
 */
layui.define(['layer', 'form','tree'], function (exports) {

    var layer = layui.layer
        , form = layui.form();

    require(['business/admin/resources/view/listView'], function (view) {
        view.init(layer);
    });


    exports('resources', {}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});