const user = {
    id: 'user',
    login: function () {
        console.log(`${this.id}님 로그인 되었습니다.`);
    }
};

const student = {
    __proto__: user
}

//user객체와 상태가 공유되지는 않음
student.id = 'user01';
student.login();

for (let prop in student) {
    console.log(prop)

    let isOwn = student.hasOwnProperty(prop);
    if (isOwn) {
        console.log(`객체 자신의 프로퍼티 ${prop}`);
    } else {
        console.log(`상속 프로퍼티 ${prop}`);
    }
}