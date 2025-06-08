
//Opções de escolha
 class Tabuleiro{
     String [][] tabuleiro = new String [3][3];

     public void aparencias() {
         for (int i =0; i<3; i++){
             for (int j=0; j<3; j++){
                 String simbolo = tabuleiro[i][j];
                 if (tabuleiro[i][j] == null) {
                     System.out.print("[]");
                 }else{
                     System.out.print(simbolo);
                 }
             }
             System.out.println();
         }

              }
}
 class Escolha{

 }
 class Condicoes{

 }
//Além de não permitir colocar no mesmo lugar mais de uma vez
//Condições para vitória, derrota e empate
//Times separados, tanto para O quanto para X

    public class Main{
        public static void main(String[] args){
            Tabuleiro t = new Tabuleiro();
            t.aparencias();
        }
    }