var plus = document.getElementById("plusNum");
var allNum = document.getElementById("allNum");
plus.onclick = function(e){
    e = window.event || e;
    o = e.srcElement || e.target;
    var num = allNum.textContent;
    if(num > 0){
        num --;
        allNum.innerHTML = num;
    }else{
        alert("您没有购买任何商品");
    }
};
var add = document.getElementById("addNum");
add.onclick = function(e){
    e = window.event || e;
    o = e.srcElement || e.target;
    var num = allNum.textContent;
    num ++;
    allNum.innerHTML = num;
};

function jion_cart(id,type) {
    var num = allNum.innerHTML;
    if(num == 0){
        alert("购买数量最少为1件");
        location.href="/productDetail?productId="+id+ "&type=" + type
    }else{
        var layer = new Layer();
        var loading = new Loading();
        layer.reset({
            content: '确认加入购物车吗？',
            onconfirm: function () {
                layer.hide();
                loading.show();
                $.ajax({
                    url: '/addCart',
                    data: {goodsId: id,keepNumber:num},
                    success: function (result) {
                        if (result == "success") {
                            loading.result('加购物车成功');
                        } else {
                            loading.result('加购物车失败');
                        }
                        location.href="/productDetail?productId="+id+ "&type=" + type
                    }
                });
            }.bind(this)
        }).show();
    }
}


