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
        )
    }
);

function fun1(){
	goodbye1();
}
 
function goodbye1(){
    //进入后台一定要用ajax，window.location.href不管用！！
	$.ajax({
        url:"../login.do?method=exitLogin",
        type:"get",
        success:function(data){
        	window.location.href="../html/jd_home.html";	
        },
    }); 
}
function show_loc(str){
    if(str == "loc"){
    	$("#location").css("visibility","visible");
    	$("#local").css("backgroundColor","white");
    	$("#jd_logo").css("visibility","hidden");
    } else if(str == "wb"){
    	$("#website").css("visibility","visible");
    	$("#web").css("backgroundColor","white");
    	$("#search").css("visibility","hidden");
    	$("#img").css("visibility","hidden");
    } else if(str == "ser"){
    	$("#kefu").css("visibility","visible");
    	$("#service").css("backgroundColor","white");
    	$("#img").css("visibility","hidden");
    }else if(str == "phjd"){
    	$("#phjd").css("visibility","visible");
    	$("#ph_jd").css("backgroundColor","white");
    	$("#img").css("visibility","hidden");
    }
}
function hide_loc(str){
    if(str == "loc"){
    	$("#location").css("visibility","hidden");
    	$("#local").css("backgroundColor","rgb(228, 227, 227)");
    } else if(str == "wb"){
    	$("#website").css("visibility","hidden");
    	$("#web").css("backgroundColor","rgb(228, 227, 227)");
    } else if(str == "ser"){
    	$("#kefu").css("visibility","hidden");
    	$("#service").css("backgroundColor","rgb(228, 227, 227)");
    } else if(str == "phjd"){
    	$("#phjd").css("visibility","hidden");
    	$("#ph_jd").css("backgroundColor","rgb(228, 227, 227)");
    }
	$("#jd_logo").css("visibility","visible");
	$("#search").css("visibility","visible");
	$("#img").css("visibility","visible");
}

i = 8;
setInterval(autoplay, 2000);
setInterval(showTime, 1000);
function autoplay() {
    if(i >= 1){
        document.getElementById("picture" + i).style.visibility = "hidden";
                        for(j = 1; j < 9; j++){
                            document.getElementById("li" + j).style.backgroundColor = "black";
                        }

        i--;
        if(i == 0){
            for( j = 1; j < 9; j++){
                document.getElementById("picture" + j).style.visibility = "visible";
            }
            i = 8;
        }
        document.getElementById("li" + (9-i)).style.backgroundColor = "orange";
    }
}

function showTime(){
    //获取时间
    var now = new Date();
    var sec = now.getSeconds();
    var min = now.getMinutes();
    var hour = now.getHours();
    var temp;
    if(hour%2 == 0){
        document.getElementById("time").innerHTML = hour + 2 + ":00";
        temp = hour + 2;
    } else {
        document.getElementById("time").innerHTML = hour + 1 + ":00";
        temp = hour + 1;
    }
    document.getElementById("hou").value = temp-hour-1;
    document.getElementById("min").value = 60 - min;
    document.getElementById("sec").value = 60 - sec;
}
