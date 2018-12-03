<html>
<head>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>

<body>
<h2>Hello World!</h2>
<div>
    <p>
        <input type="text" id="phone"/>
    </p>
    <p>
        <input type="text" id="pw"/>
    </p>
    <p>
        <input type="button" id="btn" onclick="sb()" value="登录"/>
    </p>
</div>
<div id="overload"></div>
</body>
</html>
<script>
    function sb() {
        var datas={
            "phone":$("#phone").val(),
            "pw":$("#pw").val()
        };
        console.log(datas);
        $.ajax({
            url:"/user/login",
            type:"post",
            data:datas,
            dataType:"json",
            success:function (data) {
                console.log(data.msg);
                chexkCookie();
            }
        })
    }

    //数据加载遮罩层

    var docHeight = $(document).height(); //获取窗口高度

    $('#overload')
        .height(docHeight)
        .css({
            'opacity': .9, //透明度
            'position': 'absolute',
            'top': 0,
            'left': 0,
            'background-color': 'black',
            'width': '100%',
            'z-index': 5000 //保证这个悬浮层位于其它内容之上
        });

    setTimeout(function(){$('#overload').fadeOut('slow')}, 1000); //设置3秒后覆盖层自动淡出

</script>