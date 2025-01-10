//리터럴 방식은 객체 하나를 생성할때는 직관적이지만,
//동일  프로퍼티를 갖는 여러 객체를 만들때는 비효율적

const student1 = {
    name: '유관순',
    age: 16,
    getInfo: function () {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }
};

const student2 = {
    name: '홍길동',
    age: 20,
    getInfo: function () {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }
};


//생성자 방식의 객체 생성
function Student(name, age) {

    this.name = name;
    this.age = age;
    this.getInfo = function () {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }
}

//생성자 방식은 여러 객체를 만드는 게 편함
const student3 = new Student('장보고', 20);
const student4 = new Student('신사임당', 40);

console.log(student3.getInfo());
console.log(student4.getInfo());