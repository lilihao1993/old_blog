$(function () {
    //点击ul显示列表
    $("div ul li").click(function () {
        var t = $(this).children("ul");
        $(this).children("ul").toggle("normal");
    });

});