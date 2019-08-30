function add(price){
    var number = document.getElementById("number").value;
    number ++;
    price = price * number;
    document.getElementById("number").value = number;
    document.getElementById("total_price").value = price;
}
function mul(price){
    var number = document.getElementById("number").value;
    number --;
    price = price * number;
    if(number > 0){
        document.getElementById("number").value = number;
        document.getElementById("total_price").value = price;
        number --;
    }
}

function change_bk(str,name){
	if(name == "philips"){
		if(str == "p1"){
            document.getElementById("back_g").style.backgroundImage = "url('../product/philips1.jpg')";
        } else if (str == "p2"){
            document.getElementById("back_g").style.backgroundImage = "url('../product/philips2.jpg')";
        } else if (str == "p3"){
            document.getElementById("back_g").style.backgroundImage = "url('../product/philips3.jpg')";
        } else if (str == "p4"){
            document.getElementById("back_g").style.backgroundImage = "url('../product/philips4.jpg')";
        } else{
            document.getElementById("back_g").style.backgroundImage = "url('../product/philips5.jpg')";
        }
	} else if(name == "package"){
		if(str == "p1"){
            document.getElementById("back_g").style.backgroundImage = "url('../product/package1.jpg')";
        } else if (str == "p2"){
            document.getElementById("back_g").style.backgroundImage = "url('../product/package2.jpg')";
        } else if (str == "p3"){
            document.getElementById("back_g").style.backgroundImage = "url('../product/package3.jpg')";
        } else if (str == "p4"){
            document.getElementById("back_g").style.backgroundImage = "url('../product/package4.jpg')";
        } else{
            document.getElementById("back_g").style.backgroundImage = "url('../product/package5.jpg')";
        }
	} else if(name == "bag"){
        if(str == "p1"){
            document.getElementById("back_g").style.backgroundImage = "url('../product/bag1.jpg')";
        } else if (str == "p2"){
            document.getElementById("back_g").style.backgroundImage = "url('../product/bag2.jpg')";
        } else if (str == "p3"){
            document.getElementById("back_g").style.backgroundImage = "url('../product/bag3.jpg')";
        } else if (str == "p4"){
            document.getElementById("back_g").style.backgroundImage = "url('../product/bag4.jpg')";
        } else{
            document.getElementById("back_g").style.backgroundImage = "url('../product/bag5.jpg')";
        }
	} else {
		if(str == "p1"){
            document.getElementById("back_g").style.backgroundImage = "url('../product/phone1.png')";
        } else if (str == "p2"){
            document.getElementById("back_g").style.backgroundImage = "url('../product/phone2.jpg')";
        } else if (str == "p3"){
            document.getElementById("back_g").style.backgroundImage = "url('../product/phone3.jpg')";
        } else if (str == "p4"){
            document.getElementById("back_g").style.backgroundImage = "url('../product/phone4.jpg')";
        } else{
            document.getElementById("back_g").style.backgroundImage = "url('../product/phone5.jpg')";
        }
	}
}