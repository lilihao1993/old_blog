layui.define(['layer', 'form'], function(exports){
    var layer = layui.layer
        ,form = layui.form();

    require(['business/system/view/systemView'], function (view) {
        view.init(layer);
    });


    exports('index', {}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});