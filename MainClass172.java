//请直接看这个题解 通俗易懂 送分题
public int trailingZeroes(int n) {
    int count = 0;
    while (n > 0) {
        count += n / 5;
        n = n / 5;
    }
    return count;
}
