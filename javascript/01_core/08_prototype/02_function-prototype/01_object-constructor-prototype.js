const user = {
    activate: true,
    login: function () {
        console.log('로그인 되었습니다.');
    }
};


function Student(name) {
    this.name = name;
}

Student.prototype = user;

let student = new Student('홍길동');
console.log(student.activate)