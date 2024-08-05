function Student(name, age) {

    console.log(this);
    this.name = name;
    this.age = age;
    this.getInfo = function () {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }

    //생성자 기본적으로 this를 반환함
    //return ; 또는 return 1; 같은 형태도 무시하고 return this로 반환
    //return 객체; 형태로 적을 경우 그때는 지정한 객체를 반환 
}

// new 키워드를 통해 생성자로 호출
const student = new Student('홍길동', 20);
console.log(student);