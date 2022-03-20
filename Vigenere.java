
import java.util.LinkedList;
import java.util.Queue;

public class Vigenere{

  public void exibeMatriz(char[][] matriz){
    for(int i =0;i<26;i++){
      for(int j =0;j<26;j++){
        System.out.print(matriz[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static char[][] gerarMatriz(){

    Queue<Character> alfa = new LinkedList<>();
    
    char[] abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    char[][] matriz = new char[26][26];

    for(char i : abc ){
      alfa.add(i);
    }
    
    for(int i =0;i<26;i++){
      int index = 0;
      for(char j : alfa){
        matriz[i][index] = j;
        index++; 
      }
      Character t = alfa.remove();
      alfa.add(t);
    }

    return matriz;   

  }

  public static String cripta(String msg,String inputKey){
   char[][] matriz = gerarMatriz();

   char[] word = msg.toUpperCase().toCharArray();
   char[] key = inputKey.toUpperCase().toCharArray();
  

   StringBuilder result = new StringBuilder();
   int index = 0;

   for(char i : word){
     result.append(matriz[i-65][key[index%key.length]-65]);
     index++;
   }

   return result.toString();
  }

  public static String decripta(String msg,String inputKey){
   
   StringBuilder result = new StringBuilder(); 
   char[][] matriz = gerarMatriz();

   char[] word = msg.toUpperCase().toCharArray();
   char[] key = inputKey.toUpperCase().toCharArray();

   int index = 0;
   
   for(char i : word){
     int indexR = 0;
    while(i != matriz[key[index%key.length]-65][indexR])
      indexR++;

      result.append(matriz[0][indexR]); 
    index++;
   }

   return result.toString();
  }

  public static void main(String[] args) {
    
  System.out.println(cripta("Atacaremos","bicicleta"));
  System.out.println(decripta("BBCKCCIFOT","bicicleta"));

  }   
}