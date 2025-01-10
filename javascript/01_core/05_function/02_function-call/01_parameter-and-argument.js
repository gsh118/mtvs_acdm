function hello(name) {

    console.log(name);

    console.log(arguments[1])

    return `${name}님 안녕하세요`;
}

//console.log(name); //함수 밖에서 name 인자를 쓸 수 없음

// 함수에서 return을 적지 않으면 undefined

var result = hello('홍길동');
console.log(result);

result = hello(); //인자가 들어가야하는데 안넣는 경우 undefined
console.log(result);

//요구 인자보다 많이 넣어도 에러는 안나고, 함수의 arguments 속성에는 들어있음
result = hello('홍길동', '유관순');
console.log(result);

function hi(name) {
    if (arguments !== 1 || typeof name !== 'string') {
        throw new TypeError('인자는 1개여야 하고, 문자열 값이어야 함');
        //console.log('막아야 함!!');

    }
    return `${name} 안녕~`;
}

//result = hi('홍길동', '유관순');
// result = hi(1)
// console.log(result);

function bonjour(name = '아무개') { //인자에 아무것도 안넣으면 default값이 아무개
    return `${name} 안녕~`;
}

//result = bonjour('홍길동');
result = bonjour();
console.log(result)