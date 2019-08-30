function validateUser(name) {
	$(
		function(){
			if(name.value == "" || name.value == null){
				$("#tips").html("Please enter a user name");
			} else {
				$("#tips").load("../login.do?method="+name.value+":loginCheck");
			}
		}
	);
}
$(
    function(){
    	$("#delUser").click(
            function(){
                $.ajax({
                    type: "POST",
                    url: "../login.do?method="+$("#name").val()+":delUser",
                    data: $("#name").val(),
                    success: function (msg) {
                    	$("#tips").html(msg);
                    }
                });
            }
        );
    }
);
$(
    function(){
    	$("#trunAllTable").click(
            function(){
                $.ajax({
                    type: "POST",
                    url: "../login.do?method=trunAllTable",
                    data: $("#name").val(),
                    success: function (msg) {
                    	$("#tips").html(msg);
                    }
                });
            }
        );
    }
);
$(
    function(){
		$("#delUser").mouseover(
			function () {
				if($("#name").val() == $("#user").html()){
					$("#delUser").attr("disabled",true);
				}
			}	
	    );
    }
);
$(
    function(){
    	$(".exitlogin").click(
            function(){
                $.ajax({
                    type: "POST",
                    url: "../login.do?method=exitLogin",
                    data: $("#form2").serialize(),
                    success: function (msg) {
                        window.location.href="../html/jd_home.html";	
                    }
                });
            }
        );
    }
);
