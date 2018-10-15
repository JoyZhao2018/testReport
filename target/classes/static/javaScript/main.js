require.config({

    paths: {
        "jquery": "/jquery/jquery-3.3.1",
        "bootstarp": "/bootstrap-3.3.7-dist/js/bootstrap.min",
        "yorkeJS": "/yorkeJS/yorkeJS"
    },
    shim: {

        'jquery':{
            exports: 'jquery'
        },

        'bootstarp': {
            deps: ['jquery','bootstarp'],
            exports: 'bootstarp'
        }
    }
});

require(['/javaScript/welcome.js',"jquery"], function (welcome,$) {

    $(function(){
        $("#login").bind("click",welcome.render);

    })

    // function commitData () {
    //     welcome.commitData();
    // }

    // return {
    //     render:welcome.render
    // }
});