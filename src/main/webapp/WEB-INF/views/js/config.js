require.config({
    baseUrl: '/js',
    paths: {
        'jquery': 'jquery',
        'layui': 'lib/layui/layui',
        'layer1': 'lib/layer/layer',
        'simplemde':"simplemde.min",
        'laydate': "lib/layui/lay/modules/laydate",
        'layedit': "lib/layui/lay/modules/layedit",
        'handlebars': 'lib/handlebars-1.0.0',
        'pagination': 'lib/pagination/jquery.pagination',
        'jquery.validate': 'lib/validate/jquery.validate.min',
        
    },
    shim: {
        'layer1': {
            deps: ['jquery']
        }, 'pagination': {
            deps: ['jquery', 'lib/css!lib/pagination/pagination.css']
        }, 'laydate': {
            deps: ['jquery']
        }
    }
});