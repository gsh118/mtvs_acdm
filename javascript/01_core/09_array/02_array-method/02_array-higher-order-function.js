let numbers = [];

for (let i = 0; i < 10; i++) {
    numbers[i] = Math.floor(Math.random() * 100) + 1;
}


console.log(numbers);

// 기본 sort는 요소를 문자로 취급해서 비교해서
//100과 7중에서 7이 더 나중에 나오는 문제가 있음
//이때는 비교 함수를 정의해서 쓸 수 있음
numbers.sort();
console.log(numbers);

function compare(a, b) {
    // 0보다 큰 숫자를 반환하는게 a와 b의 순서를 바꾼다는 의미
    if (a > b) return 1;
    if (a == b) return 0;
    if (a < b) return -1;
}

numbers.sort(compare);
console.log(numbers)

numbers.sort(function (a, b) {
    return b - a;
})
//내림차순
console.log(numbers);

numbers.sort((a, b) => b - a);

console.log(numbers)


numbers = [1, 2, 3, 4, 5];

numbers.forEach(function (item, index, array) {
    console.log(`item : ${item}`);
    console.log(`index : ${index}`);
    console.log(`array : ${array}`);
});

numbers.forEach(item => console.log(item * 10));

//map은 각 요소에 함수를 적용한 결과를 배열로 반환
const types = [true, 1, 'text'].map(item => typeof item);
console.log(types)

const lengths = ['apple', 'banana', 'cat', 'dog', 'egg'].map(item => item.length);
console.log(lengths);

const odds = numbers.filter(item => item % 2);
console.log(odds);

//return하는게 없어서 처음 후로 previousValue가 undefined가 나옴
numbers.reduce(function (previousValue, currentValue, currentIndex, array) {
    console.log(`prevValue : ${previousValue}`);
    console.log(`currValue : ${currentValue}`);
    console.log(`currIndex : ${currentIndex}`);
    console.log(`array : ${array}`);
})

const sum = numbers.reduce(function (previousValue, currentValue) {
    return previousValue + currentValue;
});

console.log(sum);

const max = numbers.reduce(function (prev, curr) {
    return prev > curr ? prev : curr;
});

console.log(max);

//some은 배열의 요소중 한개라도 true조건을 만족하면 true반환
let result = [1, 5, 3, 2, 4].some(item => item > 10);
console.log(result);

result = [1, 5, 3, 2, 4].some(item => item > 3);
console.log(result);

//every는 전부 만족해야 true, 아니면 false
result = [1, 5, 3, 2, 4].every(item => item > 3);
console.log(result);

result = [1, 5, 3, 2, 4].every(item => item > 0);
console.log(result);

const students = [
    { name: '유관순', source: 90 },
    { name: '홍길동', source: 80 },
    { name: '장보고', source: 70 },
];

//find는 만족하는게 있으면 찾은 첫번째걸 반환
result = students.find(item => item.name === '유관순');
console.log(result);
result = students.findIndex(item => item.name === '유관순');
console.log(result);

//없으면 find는 undefined, findIndex는 -1 반환
result = students.find(item => item.name === '신사임당');
console.log(result);
result = students.findIndex(item => item.name === '신사임당');
console.log(result);
