function outer() {
    var outerVal = '외부 함수';

    function inner() {
        var innerVal = '내부 함수';

        console.log(outerVal, innerVal);
    }

    inner(); //scope가 outer내부 
}

outer();
// inner();// 여기선 실행 못함