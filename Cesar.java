public class Cesar{
  public static void main(String[] args) {
   System.out.println("Mensagem inicial: mensagem");
   System.out.println("Mensagem no meio de envio: "+ cripta("mensagem",3));
   System.out.println("Mensagem recebida e decriptada: "+ decripta(cripta("mensagem",3),3));
  }
  
  
  public static String cripta(String input,int key){
    StringBuilder lista = new StringBuilder();
    input.chars()
    .mapToObj(l -> moveLetter(l,key))
    .forEach(i -> lista.append(i));
        
    return lista.toString();
    
  }
  
  public static String decripta(String input,int key){
    StringBuilder lista = new StringBuilder();
    input.chars()
    .mapToObj(l -> moveLetter(l,-key))
    .forEach(i -> lista.append(i));
    
    return lista.toString();
    
  }
  public static char moveLetter(int l,int key){
    char c;
      if (l >= 97 && l <= 122) {
          c = (char) ((l - 97 + key) % 26 + 97);
          c = (char) ((l - 97 + key) < 0?c+26:c);
      }
      else if (l >= 65 && l <= 90) {
          c = (char) ((l - 65 + key) % 26 + 65);
          c = (char) ((l - 65 + key) < 0?c+26:c);
      }else{
        c = (char)l;
      }

    return c;

  }
}