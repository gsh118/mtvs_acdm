//js는 코드를 처음 읽을 때 함수를 보면 메모리 공간에 넣어둠, 선언문은 메모리 공간에 다 넣음
//함수 표현식은 값의 일종이라 직접 만나야 선언부분이 들어감, 처음에는 공간만 존재해서 undefined 상태


console.log(hello('홍길동')); //선언부분보다 먼저 있어도 접근가능
console.log(hi('홍길동')); // 아직 함수 표현식에 값이 안들어가서 hi는 undefined, 호출하면 에러 

function hello(name) {
    return `${name}님 안녕하세요!`;
}

var hi = function (name) {
    return `${name} 안녕~`;
};