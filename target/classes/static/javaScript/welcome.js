define(["jquery", "yorkeJS"], function($, yorkeJS) {
    function render(){
        var data = {"username": $("#username").val(), "password": $("#password").val()};
        // $.ajax({
        //     url: "/loadPage/login",
        //     data: data,
        //     type: "post",
        //     success: function (result) {
        //         $("#header").html(result);
        //         event();
        //     }
        // })
        yorkeJS.request("/loadPage/login", data, function (result) {
                     $("#header").html(result);
                     event();
                 });
    }

    function event(){
        $("#exit").bind("click",exit);
    }

    function exit(){
        yorkeJS.request("/loadPage/exit", null, function (result) {
            $("#header").html(result);
        });
    }
    return{
        render:render
    }

})