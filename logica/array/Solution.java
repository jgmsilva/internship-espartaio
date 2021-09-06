public class Solution{
  public static int solution(int[] A){
    int[] unpaired = new int[A.length / 2 + 1]; // tamanho para a pior sequência de vetores sem pares
    int length = 0;
    Integer searchResult; // para poder receber null
    for(int a : A){
      searchResult = search(unpaired, a, 0, length-1);
      if (searchResult == null){
        length = insertionSort(unpaired, a, length);
      }else{
        length = remove(unpaired, searchResult, length);
      }
    }
    return unpaired[0];
  }
  // Retorna a posição do valor encontrado ou null caso ele não esteja no vetor
  private static Integer search(int[] unpaired, int value, int begin, int end){
    if (begin > end){
      return null;
    }else if(begin == end){
      if (unpaired[begin] == value) {
        return begin;
      }else{
        return null;
      }
    }

    int middle = (begin+end)/2;
    Integer left = searchAndRemove(unpaired, value, begin, middle);
    Integer right = searchAndRemove(unpaired, value, middle + 1, end);
    if(left == null && right == null){
      return null;
    }else if(left != null){
      return left;
    }else{
      return right;
    }
  }
  // Insere o valor e ordena para ficar mais rápida a comparação para remoção
  // e retorna o novo tamanho utilizado do vetor
  private static int insertionSort(int[] vector, int value, int length){
    if (length == 0) {
      vector[0] = value;
    }
    for (int i = length-1; i >= 0; i--) {
      vector[i+1] = vector[i];
      if (vector[i] < value || i == 0){
        vector[i] = value;
        return length+1;
      }
    }
    return length+1;
  }
  // Remove o valor ao deslocar para a esquerda todos os valores maiores que
  // o valor removido, retorna o novo tamanho utilizado
  private static int remove(int[] vector, int position, int length){
    if (position >= length) { return length; }
    if (position == length-1) {
      vector[position] = 0;
    }
    for (int i = position; i < length-1; i++) {
      vector[i] = vector[i+1];
    }
    return length-1;
  }
}
