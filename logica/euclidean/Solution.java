public class Solution {
  public static int solution(int N, int M){
    int[] eaten = new int[N];
    int chosen = 0;
    int i = 0; // i inicializado aqui para poder ser retornado fora do loop
    for (; i < N; i++) {
      if (eaten[chosen] == 1) {
        return i;
      }
      eaten[chosen] = 1;
      chosen = (chosen + M) % N;
    }
    return i;
  }
}
