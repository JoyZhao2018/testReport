var exit = function(){
    var data = {"username":$("#username").val(),"password":$("#password").val()};
    $.ajax({
        url: "/loadPage/loadWelcome",
        data: data,
        type: "post",
        success: function(result){
            $("#header").html(result);
        }
    })
}