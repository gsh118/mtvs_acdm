var student = {
    name: '유관순',
    age: 20,
    test: undefined
};

console.log(student.name === undefined);
console.log(student.height === undefined); //없을때도 undefined
console.log(student.test === undefined);
// 즉 ===로는 없는것과 일부러 undefiend로 명시한걸 구분할 수 없음
// 이때는 in으로 구분

console.log('name' in student);
console.log('height' in student);
console.log('test' in student);