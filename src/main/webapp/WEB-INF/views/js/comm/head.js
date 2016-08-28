$(function () {
    /*弹出登录框*/
    $('#show').click(function(){
        $("#form-div").removeClass("hidden");
        var html ='</div><div id="bg"></div>';
        var left = ($(document).width() - $('#windows').width())  /2;
        $('#form-div').css({left:left});
        $('body').append(html);
        $('#bg').show().height( $(document).height() ).css({'opacity':0.7});

    });


    /*关闭登录按钮*/
    $("#form-div img").click(function () {
        $("#form-div").addClass("hidden");
        $('#bg').remove();
    });
});
