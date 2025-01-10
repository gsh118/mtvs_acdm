var student = {
    name: '유관순',
    age: 16,
};
console.log(student);

var obj = {
    normal: 'nomal value',
    //공백문자, 특수문자는 기본적으로 키로는 못쓰고 문자열로 만들어서 써야함
    '@ s p a c e @': 'space value',
    '': '',
    0: 1, //0이 문자열로 변환되어서 키로 사용됨
    var: 'var', //예약어는 사용을 자제
    normal: 'new value' //덮어씌워짐
};
console.log(obj)

var key = 'test';
obj[key] = 'test value';

console.log(obj);