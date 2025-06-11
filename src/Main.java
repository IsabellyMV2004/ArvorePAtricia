public class Main {

   public static void main(String[] args) {
      ArvorePatricia arvore = new ArvorePatricia();
      String[] palavras = new String[44];
      inserirPalavras(palavras);

      for (int i = 43; i >= 0; i--) {
         arvore.inserir(palavras[i], arvore.raiz);
         arvore.mostrarNodos();
         System.out.println("\n---------------------------------------------------");
      }
      System.out.println("\n# # # EXIBIR TODAS AS PALAVRAS # # #\n");
       arvore.exibirPalavras(arvore.raiz.getCabeca(),"");
   }

   public static void inserirPalavras(String[] palavras) {
      palavras[0] = "patricia";
      palavras[1] = "professor";
      palavras[2] = "abacate";
      palavras[3] = "bicicleta";
      palavras[4] = "cachorro";
      palavras[5] = "dinossauros";
      palavras[6] = "elefante";
      palavras[7] = "foguete";
      palavras[8] = "guitarra";
      palavras[9] = "abacaxi";
      palavras[10] = "bicudo";
      palavras[11] = "amor";
      palavras[12] = "carinho";
      palavras[13] = "inteligencia";
      palavras[14] = "moral";
      palavras[15] = "justica";
      palavras[16] = "artificial";
      palavras[17] = "fe";
      palavras[18] = "comida";
      palavras[19] = "com";
      palavras[20] = "descer";
      palavras[21] = "coracao";
      palavras[22] = "perfeicao";
      palavras[23] = "cor";
      palavras[24] = "de";
      palavras[25] = "quadrado";
      palavras[26] = "queijo";
      palavras[27] = "idade";
      palavras[28] = "gambiarra";
      palavras[29] = "cachimbo";
      palavras[30] = "dinossauro";
      palavras[31] = "eleitor";
      palavras[32] = "foguinho";
      palavras[33] = "guitarrista";
      palavras[34] = "fofoca";
      palavras[35] = "festa";
      palavras[36] = "jangadeiro";
      palavras[37] = "macacada";
      palavras[38] = "navalha";
      palavras[39] = "domino";
      palavras[40] = "dia";
      palavras[41] = "domingo";
      palavras[42] = "zebra";
      palavras[43] = "que";
   }
}
