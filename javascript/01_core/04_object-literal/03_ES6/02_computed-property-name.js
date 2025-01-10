var prefix = 'key';
var index = 0;

var obj = {};

obj[prefix + '-' + index++] = index;
obj[prefix + '-' + index++] = index;
obj[prefix + '-' + index++] = index;

console.log(obj);

var obj2 = {
    [`${prefix}-${index++}`]: index,
    [`${prefix}-${index++}`]: index,
    [`${prefix}-${index++}`]: index,
};

console.log(obj2);