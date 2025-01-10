const arr = [];

console.log(arr.constructor === Array);
console.log(Object.getPrototypeOf(arr) === Array.prototype)

const foodList = ['물회', '삼계탕', '냉면', '수박', '물회'];

console.log(foodList.indexOf('물회'));
//두번째 물회의 인덱스
console.log(foodList.indexOf('물회', 1));
console.log(foodList.indexOf('삼겹살'));

//뒤부터 센 인덱스
console.log(foodList.lastIndexOf('물회'));
console.log(foodList.lastIndexOf('물회', 1));
console.log(foodList.lastIndexOf('삼겹살'));

const chineseFood = ['짜장면', '짬뽕', '우동'];

console.log(chineseFood);
chineseFood.push('탕수육');
chineseFood.push('양장피');

console.log(chineseFood);

//pop 함수는 마지막 요소를 제거하면서 반환
console.log(chineseFood.pop());
console.log(chineseFood.pop());
console.log(chineseFood.pop());

console.log(chineseFood);

const chickenList = ['양념치킨', '후라이드', '파닭'];

console.log(chickenList);

chickenList.unshift('간장치킨');
chickenList.unshift('마늘치킨');

console.log(chickenList)

console.log(chickenList.shift())
console.log(chickenList.shift())
console.log(chickenList.shift())

console.log(chickenList);

const idol1 = ['아이브', '오마이걸'];
const idol2 = ['트와이스', '에스파'];
const idol3 = ['블랙핑크', '레드벨벳'];

const mix = idol1.concat(idol2);
const mix2 = idol3.concat(idol1, idol2);

console.log(mix);
console.log(mix2);

const front = ['HTML', 'CSS', 'JavaScript', 'JQuery'];

console.log(front.slice(1, 3));
console.log(front);

//배열에 직접 영향을 줌
console.log(front.splice(3, 1, 'React'));
console.log(front);

const snackList = ['사탕', '초콜렛', '껌', '과자'];

//배열의 요소를 합쳐서 문자열로 반환
console.log(snackList.join());
console.log(snackList.join('/'));

console.log([1, 2, 3, 4, 5].reverse());  