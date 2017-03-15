document.getElementById("cartId").style.display="none";

with(document.getElementById("tbodys")){
    for(var i=0;i<rows.length;i++){
        rows[i].cells[0].style.display = "none";
    }
}

$(".lessNum").click(function(){
    var num = $(this).parent().find(".totalNum").text();
    if(num > 0){
        num = Number(num) - 1;
        $(this).parent().find(".totalNum").text(num);
    }else{
        alert("您没有购买任何商品");
    }
});

$(".moreNum").click(function(){
    var num = $(this).parent().find(".totalNum").text();
    num = Number(num) +1;
    $(this).parent().find(".totalNum").text(num);
});

document.getElementById('back').onclick = function(){
    location.href = window.history.back();
}

function deleteCart(cartId) {
    var layer = new Layer();
    var loading = new Loading();
    layer.reset({
        content:'确认删除购物记录吗？',
        onconfirm:function(){
            layer.hide();
            loading.show();
            $.ajax({
                url:'/deleteOneCart?cartId='+cartId,
                success:function(result){
                    if(result == "success"){
                        loading.result('删除成功');
                    }else{
                        loading.result('删除失败');
                    }
                    location.href = "/settleAccount";
                }
            });
        }.bind(this)
    }).show();
}

var rows = document.getElementById("newTable").rows.length;
var cartString = "";
for(var i=1; i<rows;i++){
    var productId = $("#newTable tr:eq("+i+") td:eq(0)").html();
    var keepNumber = $("#newTable tr:eq("+i+") td:eq(2)").find(".totalNum").text();
    var price = $("#newTable tr:eq("+i+") td:eq(3)").html();
    var cartString = cartString + productId + "," + keepNumber + "," + price +";";

}
function cart_buy()
{

    var layer = new Layer();
    var loading = new Loading();
    layer.reset({
        content:'确认购买吗？',
        onconfirm:function(){
            layer.hide();
            loading.show();
            $.ajax({
                type : 'POST',
                url : '/addBuyList',
                data : {cartArr:cartString},
                success:function(result){
                    if(result == "success"){
                        loading.result('购买成功');
                    }else{
                        alert("购物车中没有商品可以购买");
                        loading.result('购买失败');
                    }
                    location.href = "/account";
                }
            });
        }.bind(this)
    }).show();
}