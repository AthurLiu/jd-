var str;
$(
    function(){
        $("#countryID").change(
            function(){
                $("#province").load("../login.do?method="+$(this).val()+":countryToProvince");
                $("#address").val($("#countryID").val());
            }
        )
    }
);
function getCity(val) {
	$(
       function(){
           $("#city").load("../login.do?method="+val.value+":provinceToCity");
           str = $("#countryID").val() + "-" + val.value;
           $("#address").val(str);
       }
    );
}
function showCity(val) {
	$(
       function(){
           $("#address").val(str + "-" + val.value);
       }
    );
}
function validateUser(name) {
	$(
		function(){
			if(name.value == "" || name.value == null){
				$("#tips").html("请输入用户名！");
			} else {
				$("#tips").load("../login.do?method="+name.value+":registCheck");
			}
		}
	);
}
function validatePass(pass) {
	$(
		function(){
			if(pass.value == "" || pass.value == null){
				$("#tips").html("请输入用户密码！");
			}
		}
	);
}
function validatePass1(pass1) {
	$(
		function(){
			if(pass1.value == "" || pass1.value == null){
				$("#tips").html("请输入确认密码！");
			} else {
				if($("#pass").val() != $("#pass1").val()){
					$("#tips").html("密码与确认密码不一致！");
				} else {
					$("#tips").html("密码与确认密码一致！");
				}
			}
		}
	);
}
function validatePhone(phone) {
	$(
		function(){
			if(phone.value == "" || phone.value == null){
				$("#tips").html("请输入电话号码！");
			} else {
				if(!validate_phone(phone.value)){
					$("#tips").html("电话号码格式错误！");
				} else {
					$("#tips").html("电话号码格式正确！");
				}
			}
		}
	);
}
function validateEmail(email) {
	$(
		function(){
			if(email.value == "" || email.value == null){
				$("#tips").html("请输入邮箱号码！");
			} else {
				if(!validate_from(email.value)){
					$("#tips").html("邮箱号码格式错误！");
				} else {
					$("#tips").html("邮箱号码格式正确！");
				}
			}
		}
	);
}

function register(){
    var name = document.getElementById("user").value;
    var pwsd = document.getElementById("pass").value;
    var pwsd1 = document.getElementById("pass1").value;
    var phone = document.getElementById("phone").value;
    var email = document.getElementById("email").value;
    if(name == "" || name == null){
        alert("请输入用户名");
    } else if(pwsd == "" || pwsd == null){
        alert("请输入密码");
    } else if(pwsd1 == "" || pwsd1 == null){
        alert("请输入确认密码");
    } else if(phone == "" || phone == null){
        alert("请输入电话号码");
    } else if(email == "" || email == null){
        alert("请输入邮箱");
    } else if(pwsd1 != pwsd){
        alert("密码与确认密码不一致");
    }
    if(validate_phone(phone)){
        if(validate_from(email)){
            $.ajax({
                type: "POST",
                url: "../login.do?method=register",
                data: $("#form2").serialize(),
                success: function (msg) {
                    if (msg.length == 6) 
                    	window.location.href="register.jsp?message=注册失败，用户名已存在!";	
                    else 
                    	window.location.href="register.jsp?message=注册成功！";
                }
            });
        } else {
            alert("邮箱地址错误");
        }
    } else {
        alert("电话号码不是11位的整数");
    }
}
/*
 * 验证邮箱地址是否正确
 */
function validate_from(emailvalue){
    var x = emailvalue.indexOf("@");
    var y = emailvalue.indexOf(".");
    //x表示@出现的位置，y表示.出现的位置
    //@不能作为邮箱的首字母，indexOf出现在字符串的开始位置，下标从0开始
    if(x < 1 || y < x){
        return false;
    } else {
        return true;
    }
}

/*
 * 验证电话号码是否正确
 */
function validate_phone(phone){
    if(phone.length == 11){
        var number = phone.replace(/[^0-9]/ig, "");
        if(number.length == phone.length){
            return true;
        }
    }
    return false;
}

function login_put(msg){
    var temp = document.getElementById(msg).value;
    if(msg == "user" && temp != null && temp != ""){
        document.getElementById("span1").style.visibility = "hidden";
    } else if(msg == "pass" && temp != null && temp != ""){
        document.getElementById("span2").style.visibility = "hidden";
    } else if(msg == "pass1" && temp != null && temp != ""){
        document.getElementById("span3").style.visibility = "hidden";
    } else if(msg == "phone" && temp != null && temp != ""){
        document.getElementById("span4").style.visibility = "hidden";
    } else if(msg == "email" && temp != null && temp != ""){
        document.getElementById("span5").style.visibility = "hidden";
    } 
}
