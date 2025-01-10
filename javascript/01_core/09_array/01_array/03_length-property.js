console.log([].length);
console.log([1, 2, 3, 4, 5].length);


const arr = [1, 2, 3, 4, 5];

console.log(arr);

// 맨 뒤에 추가
arr.push(6);
console.log(arr.length);

//pop은 맨 마지막 요소 제거
arr.pop();
console.log(arr);

//length 프로퍼티를 바꾸면 그 길이의 배열을 새로 만들어서 반환함
arr.length = 3;
console.log(arr);

arr.length = 10;
console.log(arr);
console.log(arr.length);

//값이 없는 요소가 있는 희소배열이 가능
const sparse = [, 2, , 4];
console.log(sparse);
console.log(sparse.length);
console.log(Object.getOwnPropertyDescriptors(sparse));
