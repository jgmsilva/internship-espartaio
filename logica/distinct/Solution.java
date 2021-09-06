public class Solution{
   public static int solution(int[] A){
     int[] distincts = new int[A.length];
     int length = 0;
     for (int i=0; i < A.length ; i++) {
       if (!in(distincts, A[i])) {
         length = insert(distincts, length, A[i]);
      }
     }
     return distincts.length;
   }
   private static boolean in(int[] vector, int value){
      for (int v : vector) {
        if (v == value) {
          return true;
        }
      }
      return false;
   }
   private static int insert(int[] vector, int length, int value){
     vector[length] = value;
     return length+1;
   }
 }
