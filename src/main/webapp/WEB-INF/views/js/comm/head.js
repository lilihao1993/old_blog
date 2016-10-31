$(function () {
    /*弹出登录框*/
    $('#show').click(function () {
        pop();
    });

    function pop() {
        $("#form-div").removeClass("hidden");
        var html = '</div><div id="bg"></div>';
        var left = ($(document).width() - $('#windows').width()) / 2;
        $('#form-div').css({left: left});
        $('body').append(html);
        $('#bg').show().height($(document).height()).css({'opacity': 0.7});
    }


    /*关闭登录按钮*/
    $("#form-div img").click(function () {
        $("#form-div").addClass("hidden");
        $('#bg').remove();
    });


    /*鼠标点击 登录ajax*/

    $("#login").click(function () {
        login();
    });

    /*回车调用login ajax事件*/
    document.onkeydown = function (event) {
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if (e && e.keyCode == 13) {
            login()
        }
    };

    /*login ajax事件*/
    function login() {
        $.ajax({
            url: "/client/login",
            data: {userName: $("#username").val(), password: $("#password").val()},
            success: function (a) {
                var errorcode = a.error;
                if (errorcode === "0") {
                    $("form").submit();
                } else {
                    /*返回错误信息*/
                    $("form .row span").html(errorcode);
                }
            }
        });
    }

});
