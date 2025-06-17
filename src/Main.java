import java.util.Scanner;
//Opções de escolha
 class Tabuleiro{
     String [][] tabuleiro = new String [3][3];
     String simbolo;
     public void aparencias() {
         for (int i =0; i<3; i++){
             for (int j=0; j<3; j++){
                 simbolo = tabuleiro[i][j];
                 if (tabuleiro[i][j] == null) {
                     System.out.print("[ ]");
                 }else{
                     System.out.print("[" + tabuleiro[i][j] + "]");
                 }
             }
             System.out.println();
         }

              }
}
 class Escolha{
    Scanner scanner = new Scanner(System.in);
     Tabuleiro tabuleiro;
     String simbolo1;
     String simbolo2;
     String simboloatual;
    public void time() {
        System.out.println("Prefere 'O'(Aperte 1) ou 'X'(Aperte 2)?");
        int number = scanner.nextInt();
        if (number == 1) {
            this.simbolo1 = "O";
            this.simbolo2 = "X";
            this.simboloatual = this.simbolo1;
        } else if (number == 2) {
            this.simbolo1 = "X";
            this.simbolo2 = "O";
            this.simboloatual = this.simbolo1;
        }
        System.out.println("Então quem começa é o " + simboloatual + "!");
    }
    public Escolha(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    public boolean escolhendo() {
        System.out.println("Escolha um número de 1 a 9, como o seguinte exemplo:" + "\n[7] [8] [9]" + "\n[4] [5] [6]" + "\n[1] [2] [3]");
        int escolha = scanner.nextInt();
        if(escolha< 1 || escolha>9){
            System.out.println("Numero inválido!");
            return false;
        }
        int[][] numpad ={
                {2,0},
                {2,1},
                {2,2},
                {1,0},
                {1,1},
                {1,2},
                {0,0},
                {0,1},
                {0,2},
        };
        int linha = numpad[escolha-1][0];
        int coluna =numpad[escolha-1][1];
        if(tabuleiro.tabuleiro[linha][coluna] == null){
            tabuleiro.tabuleiro[linha][coluna] = simboloatual;
            return true;
        }else {
            return false;
        }

    }
     public boolean alternarJogador(){
        if(simboloatual.equals(simbolo1)){
            this.simboloatual = this.simbolo2;
            return true;
        }else{
            this.simboloatual = this.simbolo1;
            return false;
        }

     }
 }
 class Condicoes{
        public boolean verificarCondicoes(String tabuleiro[][], String simboloAtual){
        for (int i = 0; i < 3 ; i++){
           if (tabuleiro[i][0]!= null && tabuleiro[i][1]!= null && tabuleiro[i][2]!= null && tabuleiro[i][0].equals(simboloAtual) && tabuleiro[i][1].equals(simboloAtual) && tabuleiro[i][2].equals(simboloAtual)) {
               return true;
           }
        }
        for(int j = 0; j<3 ; j++){
            if (tabuleiro[0][j]!= null && tabuleiro[1][j]!= null && tabuleiro[2][j]!= null && tabuleiro[0][j].equals(simboloAtual) && tabuleiro[1][j].equals(simboloAtual) && tabuleiro[2][j].equals(simboloAtual)) {
                return true;
            }
        }
        if(tabuleiro[1][1] != null &&tabuleiro [0][0] != null && tabuleiro[2][2] != null && tabuleiro[0][0].equals(simboloAtual) && tabuleiro[1][1].equals(simboloAtual) && tabuleiro[2][2].equals(simboloAtual)){
            return true;
        }
        if (tabuleiro [0][2] != null && tabuleiro[2][0] != null && tabuleiro[1][1] != null && tabuleiro[0][2].equals(simboloAtual) && tabuleiro[1][1].equals(simboloAtual) && tabuleiro[2][0].equals(simboloAtual)){
            return true;
        }
        return false;
     }
     boolean empate(String[][] tabuleiro){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (tabuleiro[i][j] == null){
                return false;
                }
            }
        }
    return true;
     }
 }
//Além de não permitir colocar no mesmo lugar mais de uma vez
//Condições para vitória, derrota e empate
//Times separados, tanto para O quanto para X

    public class Main{
        public static void main(String[] args){
            Tabuleiro t = new Tabuleiro();
            t.aparencias();
            Escolha e  = new Escolha(t);
            e.time();
            Condicoes condicoes = new Condicoes();
            int resposta = 0;
            Scanner scanner = new Scanner(System.in);
            boolean fimDeJogo  = false;
           do {
               while (!fimDeJogo) {
                   t.aparencias();
                   boolean jogadaValida = e.escolhendo();
                   if (!jogadaValida) {
                       System.out.println("ERRO: O número é inválido ou o lugar já está preenchido!");
                       continue;
                   }
                   if (condicoes.verificarCondicoes(t.tabuleiro, e.simboloatual)) {
                       t.aparencias();
                       System.out.println("O jogador " + e.simboloatual + " venceu!");
                       fimDeJogo = true;
                   } else if (condicoes.empate(t.tabuleiro)) {
                       t.aparencias();
                       System.out.println("Empate! Nenhum dos jogadores venceram.");
                       fimDeJogo = true;
                   } else {
                       e.alternarJogador();
                   }
               }
               System.out.println("Gostaria de jogar de novo? (1=Sim/2=Não)");
               resposta = scanner.nextInt();
               if (resposta==1) {
                   t = new Tabuleiro();
                   e = new Escolha(t);
                   e.time();
                   fimDeJogo = false;
               }
           }while (resposta == 1);
        }
    }