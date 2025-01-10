var hello = function () {
    return `안녕하세요!`;
}

var obj = { hello };

function repeat(func, count) {
    for (var i = 0; i < count; i++) {
        console.log(func());
    }

    return function () {
        console.log(`${count}번 반복 완료`);
    }
}


var returnFunction = repeat(obj.hello, 5);
//리턴받은 함수 실행 
returnFunction();