const user = {
    activate: true,
    login: function () {
        console.log('로그인 되었습니다.');

    }
};

const student = {
    passion: true
};

//프로토타입을 의미
student.__proto__ = user;

//user의 프로퍼티에 접근 가능
console.log(student.activate);
student.login();

console.log(student.passion)

const greedyStudent = {
    class: 1,
    __proto__: student
};

//참조하는 프로토타입의 프로퍼티를 상속받음
console.log(greedyStudent.activate);
console.log(greedyStudent.passion);