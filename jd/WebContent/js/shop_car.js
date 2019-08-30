$(
    function(){
    	$("#goOrder").mouseover(
			function () {
				if($("#orderNum").html() == "0种"){
					$("#goOrder").attr("disabled",true);
				}
			}	
        );
    	$("#clearShop").mouseover(
			function () {
				if($("#orderNum").html() == "0种"){
					$("#clearShop").attr("disabled",true);
				}
			}	
        )
    }
);