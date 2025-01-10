const arr = ['바나나', '복숭아', '키위'];

const arr2 = new Array();

console.log(arr);
console.log(arr2);

//10칸짜리
const arr3 = new Array(10);
console.log(arr3);

const arr4 = new Array(1, 2, 3);
console.log(arr4)

//10이 담긴 배열
console.log(Array.of(10));
console.log(Array.of(1, 2, 3));
console.log(Array.of('hello', 'js'));

console.log(arr[0]);
console.log(arr[1]);
console.log(arr[2]);

console.log(arr.length);

for (let i = 0; i < arr.length; i++) {
    console.log(arr[i]);
}

console.log(typeof arr);