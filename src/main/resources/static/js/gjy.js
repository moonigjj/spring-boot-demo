function preFill(str, pre, len) {
    var temp = '';
    for(i = 0; i < len; i++){
        temp = temp + pre;
    }
    str = temp + str;
    return str;
}