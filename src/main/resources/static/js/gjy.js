/**
 * 字符填充
 * @param str
 * @param pre
 * @param len
 * @returns {string|*}
 */
function preFill(str, pre, len) {
    var temp = '';
    for(i = 0; i < len; i++){
        temp = temp + pre;
    }
    str = temp + str;
    return str;
}

function ajaxGet(url) {
    $.ajax({
        url:url,
        dataType:'json',
        type: 'get',
        data: $('#productUnitForm').serialize(),
        error:function () {
            layer.alert("响应异常");
        },
        success: function (data) {
            if(!data.success){
                layer.alert(data.msg, {icon: 1}, function(){
                    window.locale.reload();
                });
            } else {
                layer.alert(data.msg);
            }
        }
    });
}