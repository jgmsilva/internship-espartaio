public class Solution{
   public static int solution(int[] A){
     int[] distincts = new int[A.length];
     int length = 0;
     for (int i=0; i < A.length ; i++) {
       if (!in(distincts, length, A[i])) {
         length = insert(distincts, length, A[i]);
      }
     }
     return length;
   }
   private static boolean in(int[] vector, int length, int value){
      for (int i=0; i < length; i++) {
        if (vector[i] == value) {
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
