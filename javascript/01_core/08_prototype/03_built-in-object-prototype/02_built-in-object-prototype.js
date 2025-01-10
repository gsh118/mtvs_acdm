const num = new Number(100);

console.log(num.__proto__ === Number.prototype);
console.log(num.__proto__.__proto__ === Object.prototype);

console.log(num.__proto__.__proto__.__proto__);

String.prototype.hello = function () {
    console.log(`hello, ${this}`);
}

//문자열의 prototype이 String.prototype이니까 hello가 실행됨
"Javascript".hello();

const obj = {
    0: "hello",
    1: "javascript",
    length: 2
}

obj.join = Array.prototype.join;

console.log(obj.join('/'));