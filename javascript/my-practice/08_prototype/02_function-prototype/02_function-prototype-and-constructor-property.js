function Student() { }

console.log(Student.prototype.constructor == Student);

let student = new Student();
console.log(student.constructor == Student)