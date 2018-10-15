define(["jquery"],function($){
    function request(url, data, success, type){
        $.ajax({
            url: url,
            data: data,
            type: type == null ? "post" : type,
            timeout: 10000,
            dataType: "json",
            success: function(res){
                if(typeof(success) == "function")
                    success(res.responseText)
            },
            error: function(res){
                if(typeof(success) == "function")
                    success(res.responseText)
            }
        })
    }

    return{
        request: request
    }
})