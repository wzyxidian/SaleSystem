/*
(function(w,d,u){
    var loginForm = util.get('loginForm');
    if(!loginForm){
        return;
    }
    var userName = loginForm['userName'];
    var password = loginForm['userPassword'];
    var isSubmiting = false;
    var loading = new Loading();
    var page = {
        init:function(){
            loginForm.addEventListener('submit',function(e){
                if(!isSubmiting && this.check()){
                    var value1 = userName.value;
                    var value2 = md5(password.value);
                    isSubmiting = true;
                    loading.show();

                    // ajax({
                    //     data:{userName:value1,password:value2},
                    //     url:'/api/loginCheck',
                    //     success:function(result){
                    //         // loading.hide();
                    //         // location.href = './';
                    //         location.href="";
                    //         console.log(result);
                    //     },
                    //     error:function(message){
                    //         loading.result(message||'登录失败');
                    //         isSubmiting = false;
                    //     }
                    // });
                    $.ajax({
                        type : "POST",  //提交方式
                        url : "loginCheck",//路径
                        data : {
                            userName : value1,
                            password : value2
                        },//数据，这里使用的是Json格式进行传输

                        success : function(result) {//返回数据根据结果进行相应的处理
                            alert(result);
                            if (result == "true" ) {
                              location.href= "product/buy";
                            } else {
                                alert("用户名或密码不正确");
                                location.href = "login";
                            }
                        }
                    });
                }
            }.bind(this),false);
            [userName,password].forEach(function(item){
                item.addEventListener('input',function(e){
                    item.classList.remove('z-err');
                }.bind(this),false);
            }.bind(this));
        },
        check:function(){
            var result = true;
            [
                [userName,function(value){return value == ''}],
                [password,function(value){return value == ''}]
            ].forEach(function(item){
                var value = item[0].value.trim();
                if(item[1](value)){
                    item[0].classList.add('z-err');
                    result = false;
                }
                item[0].value = value;
            });
            return result;
        }
    };
    page.init();
})(window,document);*/
