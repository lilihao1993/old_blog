/**
 * 通用基础js
 */
define(['jquery','comm/util','laydate','layedit','jquery.validate'], function ($,util) {

    /**
     * 渲染
     */
    function init(layer) {
        //表单验证
        _queryFormValid();
        //编辑器
        _edit();
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
            el: '#btn',
            event: 'click',
            handler: function () {
                layer.msg("成功调用", {icon: 1, time: 1000});
            }},{
            el: '#LAY_demorange_s',
            event: 'click',
            handler: function () {
                var start = {
                    min: laydate.now()
                    ,max: '2099-06-16 23:59:59'
                    ,istoday: false
                    ,choose: function(datas){
                        // end.min = datas; //开始日选好后，重置结束日的最小日期
                        // end.start = datas; //将结束日的初始值设定为开始日
                        //
                    }
                };
                start.elem = this;
                laydate(start);
            }
             },{
            el: '#LAY_demorange_e',
            event: 'click',
            handler: function () {
                var end = {
                    min: laydate.now()
                    ,max: '2099-06-16 23:59:59'
                    ,istoday: false
                    ,choose: function(datas){
                        // start.max = datas; //结束日选好后，重置开始日的最大日期
                    }
                };
                end.elem = this;
                laydate(end);
            }
        }]);
    }

    /**
     * 描述：编辑器
     * @private
     */
    function _edit() {
        var layedit = layui.layedit;
        layedit.build('Lay_docDemo_layedit',{
            height:180
        });
    }

    /**
     * 描述：表单验证
     * @private
     */
    function _queryFormValid() {
        return $("#queryForm").validate({
            rules:{
                title:{
                    required:true
                },
                password:{
                    required:true
                },
                city:{
                    required:true
                },
                switch:{
                    required:true
                }
            },
            onfocusout: false,
            messages:{
                title:{
                    required:"不可为空",
                },
                password:{
                    required:"不可为空",
                },
                city:{
                    required:"不可为空",
                },
                switch:{
                    required:"不可为空",
                }
            }
        });
    }

    return {
        init: init
    };

});