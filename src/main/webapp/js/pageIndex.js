$("#tab1").click(function() {

    $("#tab2").removeClass("z-sel");
    $("#tab1").addClass("z-sel");
});
$("#tab2").click(function() {

    $("#tab1").removeClass("z-sel");
    $(".buy").css("display","none");
    $("#tab2").addClass("z-sel");
});

function disp_confirm(id)
{
    var layer = new Layer();
    var loading = new Loading();
    layer.reset({
        content:'确定要删除该内容吗？',
        onconfirm:function(){
            layer.hide();
            loading.show();
            $.ajax({
                url:'/delete',
                data:{productId:id},
                success:function(result){
                    if(result == "success"){
                        loading.result('删除成功');
                    }else{
                        loading.result('删除失败');
                    }
                    location.href = "/index";
                }
            });
        }.bind(this)
    }).show();
}


