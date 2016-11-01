define(['handlebars'], function (handlebars) {

    //表格序号索引+1
    handlebars.registerHelper("addOne", function (index) {
        //返回+1之后的结果
        return index + 1;
    });

    //注册判断器
    handlebars.registerHelper('ifCond', function (v1, operator, v2, options) {
        switch (operator) {
            case '!=':
                return (v1 != v2) ? options.fn(this) : options.inverse(this);
                break;
            case '==':
                return (v1 == v2) ? options.fn(this) : options.inverse(this);
                break;
            case '===':
                return (v1 === v2) ? options.fn(this) : options.inverse(this);
                break;
            case '<':
                return (v1 < v2) ? options.fn(this) : options.inverse(this);
                break;
            case '<=':
                return (v1 <= v2) ? options.fn(this) : options.inverse(this);
                break;
            case '>':
                return (v1 > v2) ? options.fn(this) : options.inverse(this);
                break;
            case '>=':
                return (v1 >= v2) ? options.fn(this) : options.inverse(this);
                break;
            case '&&':
                return (v1 && v2) ? options.fn(this) : options.inverse(this);
                break;
            case '||':
                return (v1 || v2) ? options.fn(this) : options.inverse(this);
                break;
            case 'length':
                return v1.length === v2 ? options.fn(this) : options.inverse(this);
                break;
            default:
                return options.inverse(this);
                break;
        }
    });

    //注册计算器
    handlebars.registerHelper("math", function (v1, operator, v2) {
        if (operator == "+") {
            return v1 + v2;
        }
        if (operator == "-") {
            return v1 - v2;
        }
        if (operator == "*") {
            return v1 * v2;
        }
        if (operator == "/") {
            return v1 / v2;
        }
        if (operator == "%") {
            return v1 % v2;
        }
    });

    //时间：年月日
    handlebars.registerHelper("prettifyDate", function (timestamp) {
        // return timestamp ? new Date(parseInt(timestamp) * 1000).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " "): null;
        // return timestamp ? timestamp.substring(0, 10) : null;
        var date = new Date(timestamp);
       return new Date(timestamp).Format('yyyy-MM-dd');
    });


    //增加Date format 
    Date.prototype.Format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "h+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }
})

