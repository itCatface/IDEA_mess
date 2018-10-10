function js_hello_js() {
    var x = 99;
    console.log("x的值为：" + x);
    document.writeln("hello JavaScript...你好" + ++x);
    alert("我透\r\n" + new Date().toLocaleString());
}