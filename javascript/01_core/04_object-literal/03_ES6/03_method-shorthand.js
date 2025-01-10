var dog = {
    name: '뽀삐',
    eat: function (food) {
        console.log(`${this.name}(은)는 ${food}를 맛있게 먹어요.`)
    }
}

dog.eat('고구마');

var dog2 = {
    name: '두부',
    eat(food) {
        console.log(`${this.name}(은)는 ${food}를 맛있게 먹어요`);
    }
};

dog2.eat('감자');
