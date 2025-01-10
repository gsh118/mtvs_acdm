function Student(name, age) {
    this.name = name;
    this.age = age;
    this.getInfo = function () {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    };

    console.log('Student 생성자 함수 호출됨...');
}

//생성자 함수가 new 키워드 없이 호출되면 일반함수로 동작
console.student = Student('강감찬', 35);
//console.log(student);

console.log(name); //일반함수로 호출했을 때 this가 전역을 가리킴
console.log(age);

function Dog(name, age) {

    //new로 호출한건지 확인
    if (!new.target) {
        return new Dog(name, age);
        //console.log('동작 확인');
    }

    this.name = name;
    this.age = age;
}

const dog = Dog('뽀삐', 3);
console.log(dog);

const obj = Object(); //Object는 new 연산자가 없어도 생성자를 호출해서 반환
console.log(obj);