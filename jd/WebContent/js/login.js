function validateUser(name) {
	$(
		function(){
			if(name.value == "" || name.value == null){
				$("#tips").html("请输入用户名！");
			} else {
				$("#tips").load("../login.do?method="+name.value+":loginCheck");
			}
		}
	);
}
function validatePass(pass) {
	$(
		function(){
			if(pass.value == "" || pass.value == null){
				$("#tips").html("请输入密码！");
			}
		}
	);
}
function validateYzm(yzm) {
	$(
		function(){
			if(yzm.value == "" || yzm.value == null){
				$("#tips").html("请输入验证码！");
			} else {
				if(yzm.value != $("#number").html()){
					$("#tips").html("验证码输入错误！");
				} else {
					$("#tips").html("验证码输入正确！");
				}
			}
		}
	);
}
$(
	function() {
		$("#hide_pass").click(
			function() {
				if($("#pwd").attr("type") == "password"){
					$("#pwd").attr("type","text");
					$("img").attr("title","隐藏密码");
				} else {
					$("#pwd").attr("type","password");
					$("img").attr("title","显示密码");
				}
			}
		)
	}	
);
function login(){
    var name = document.getElementById("name").value;
    var pwsd = document.getElementById("pwd").value;
    var yzm = document.getElementById("yzm").value;
    var number = document.getElementById("number").innerHTML;
    if(name == "" || name == null){
        alert("用户名输入为空！");
    } else if(pwsd == "" || pwsd == null){
        alert("密码输入为空！");
    } else if(yzm == "" || yzm == null){
        alert("验证码输入为空");
    } else if(yzm != number){
        alert("验证码输入正确");
    } else{
    	$.ajax({
            type: "POST",
            url: "../login.do?method=login",
            data: $("#form1").serialize(),
            success: function (msg) {
                if (msg.length == 6) {
                	window.location.href="login.jsp?message=登录失败，密码错误!";
                } else if (msg.length == 7){
                	window.location.href="super_user.jsp";
                } else if (msg.length == 9){
                	window.location.href="user_page.jsp";
                } else {
                	window.location.href="login.jsp?message=登录失败，重复登录!";
                }
            }
        });
    }
}
var temp = (Math.random()*8888+1000);
temp1 = temp >> 0;
document.getElementById("number").innerHTML = temp1;  
var flag = true;

function change(){
	if(flag){
		var temp = (Math.random()*8888+1000);
	    //右移位操作导致小数部分丢失,
	    temp1 = temp >> 0;
	    document.getElementById("number").innerHTML = temp1;
	    flag = false;
	    var time = 60;
	    var timer = setInterval(function() {
			time--;
			$("#yzm_time").text(time+"s后重换");
			$("#yzm_time").css("color","red");
			$("p").attr("disabled",true);
			if(time == 0){
				clearInterval(timer);
				$("#yzm_time").text("");
				$("#yzm_time").css("color","black");
				flag = true;
			}
		},1000) 	
	}
}