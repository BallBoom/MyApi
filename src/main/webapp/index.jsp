<html>
<head>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
<h2>Hello World!</h2>
<div>
    <p>
        <input type="text" id="phone">
    </p>
    <p>
        <input type="text" id="pw">
    </p>
    <p>
        <input type="button" id="btn" onclick="sb()" value="登录">
    </p>
</div>
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

    function chexkCookie() {
        var myphone=document.cookie;
        var index=myphone.indexOf('=');
        var phone=myphone.substring(index+1);
        console.log(phone);
    }






</script>