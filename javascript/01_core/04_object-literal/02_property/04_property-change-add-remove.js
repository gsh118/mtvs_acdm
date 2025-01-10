var dog = {
    name: '뽀삐'
};

dog.name = '두부';
console.log(dog);

dog.age = 3;
console.log(dog);

delete dog.age;
//delete dog.something; //에러가 나지 않고 그냥 무시함
console.log(dog)
