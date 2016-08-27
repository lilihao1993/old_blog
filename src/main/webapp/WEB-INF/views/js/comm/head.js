$(function () {
    $('#show').click(function(){
        $("form").removeClass("hidden");
        var html ='</div><div id="bg"></div>';
        var left = ($(document).width() - $('#windows').width())  /2;
        $('form').css({left:left});
        $('body').append(html);
        $('#bg').show().height( $(document).height() ).css({'opacity':0.7});

    });

    /*弹出登录框*/

});
