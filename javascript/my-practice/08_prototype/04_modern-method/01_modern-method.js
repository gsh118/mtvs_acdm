const user = {
    activate: true
};

const student = Object.create(user);
console.log(student.activate)

console.log(Object.getPrototypeOf(student) === user);

Object.setPrototypeOf(student, {});
console.log(Object.getPrototypeOf(student) === user);

const obj = {};

let key = "__proto__";

//프로토타입을 기본형으로 설정하려는건 무시
obj[key] = "값 설정";

console.log(obj[key]);

obj[key] = { test: "새로운 값으로 덮어쓰기" };
console.log(obj[key]);
//의도치 않은 결과가 나올 수 있어서 get,set PrototypeOf을 쓰는게 좋음