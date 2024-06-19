class Solution {
  public int minDays(int[] bloomDay, int m, int k) {
      int n = bloomDay.length;
      // Se não há flores suficientes para formar m buquês, retorne -1
      if (m * k > n) {
          return -1;
      }

      int left = Integer.MAX_VALUE;
      int right = Integer.MIN_VALUE;
      
      // Encontrar o menor e maior dia de florescimento
      for (int day : bloomDay) {
          left = Math.min(left, day);
          right = Math.max(right, day);
      }
      
      // Busca binária para encontrar o número mínimo de dias
      while (left < right) {
          int mid = (left + right) / 2;
          if (canMakeBouquets(bloomDay, m, k, mid)) {
              right = mid;
          } else {
              left = mid + 1;
          }
      }
      
      return left;
  }

  private boolean canMakeBouquets(int[] bloomDay, int m, int k, int days) {
      int bouquets = 0;
      int flowers = 0;
      
      for (int day : bloomDay) {
          if (day <= days) {
              flowers++;
              if (flowers == k) {
                  bouquets++;
                  flowers = 0;
              }
          } else {
              flowers = 0;
          }
      }
      
      return bouquets >= m;
  }
}
