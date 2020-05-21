/**
 * 登录界面优化
 */

		//相关登录界面改善
		
		//登录界面

        function checkUser() {
            var result1 = document.getElementById("s-text").value;
            var result2 = document.getElementById("s-password").value;
            var result3 = document.getElementById("s-code").value;
            if (result1 == "") {
                alert("账号不能为空");
                return false;
            }
            else if (result2 == "") {
                alert("密码不能为空");
                return false;
            }
            else if (result3 == "") {
                alert("验证码不能为空");
                return false;
            }
            else {
                return true;
            }
        }
            
       //注册界面

        function checkrUser() {
        	var result1 = document.getElementById("r-text").value;
            var result = document.getElementById("r-name").value;
            var password = document.getElementById("r-password").value;
            var password1 = document.getElementById("r-surepassword").value;
            if(result1 == ""){
            	alert("邀请码不能为空");
            	return false;
            }
            else if (result == "") {
                alert("用户名不能为空");
                return false;
            }
            else if (password == "") {
                alert("密码不能为空");
                return false;
            }
            else if(password!=password1){
            	alert("两次密码不一致");
            	return false;
            }
            else{
            	return true;
            }
        }
        
        //忘记密码界面
        function checkfUser() {
        	var result1 = document.getElementById("rvcinAction").value;
            var password = document.getElementById("f-password").value;
            var password1 = document.getElementById("f-surepassword").value;
            if(result1 == ""){
            	alert("验证码不能为空");
            	return false;
            }
            else if (password == "") {
                alert("密码不能为空");
                return false;
            }
            else if(password!=password1){
            	alert("两次密码不一致");
            	return false;
            }
            else{
            	return true;
            }
        }