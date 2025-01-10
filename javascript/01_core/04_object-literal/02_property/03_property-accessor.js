var dog = {
    name: '뽀삐',
    eat: function (food) {
        console.log(`${this.name}(은)는 ${food}를 맛있게 먹어요.`);
    }
};

console.log(dog.name);
dog.eat('고구마');

console.log(dog['name']);
//console.log(dog[name]) // 대괄호 연산자로 프로퍼티를 접근할 때는 문자열을 써야함
dog['eat']('고구마');

var obj = {
    'dash-key': 'dash-value',
    0: 1
};

//console.log(obj.'dash-key'); //네이밍 규칙을 위반한 키의 경우는 []연산자로 접근
console.log(obj['dash-key']);

console.log(obj['0']);