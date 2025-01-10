var student = {
    name: '유관순',
    age: 16,
    getInfo: function () {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }
};

console.log(student)
console.log(typeof student);

var student2 = {};
console.log(typeof student2);
console.log(student2);