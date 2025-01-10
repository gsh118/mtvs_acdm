var message;

message = function () {
    return "hello world!";
}

console.log(message());

message = () => {
    return "Arrow Function";
};

console.log(message());

//함수 본문이 한줄이면 return과 중괄호 생략 가능
message = () => "Arrow Functions are Simple!!";

message = (val1, val2) => "Arrow" + val1 + val2;
console.log(message('Function', '!'))

message = val => "Arrow " + val;
console.log(message('Functions are GOOD!!!!!'));