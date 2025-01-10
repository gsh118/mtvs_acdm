// n! = 1 * 2 * 3 * ... (n-1) * n
function factorial(n) {

    if (n <= 1) return 1;
    return n * factorial(n - 1);
}

console.log(factorial(5));