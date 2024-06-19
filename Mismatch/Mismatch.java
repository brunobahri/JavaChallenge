class Solution {
  public int[] findErrorNums(int[] nums) {
      int n = nums.length;
      int sum = 0;
      int sumSquares = 0;
      int expectedSum = n * (n + 1) / 2;
      int expectedSumSquares = n * (n + 1) * (2 * n + 1) / 6;

      for (int num : nums) {
          sum += num;
          sumSquares += num * num;
      }

      int diff = expectedSum - sum; // x - y
      int sumDiff = expectedSumSquares - sumSquares; // x^2 - y^2 = (x - y)(x + y)

      int sumXY = sumDiff / diff; // x + y

      int x = (sumXY + diff) / 2;
      int y = sumXY - x;

      return new int[] {y, x};
  }
}
