public class Main {

   public static void main(String[] args) {
      ArvorePatricia arvore = new ArvorePatricia();
      String[] palavras = new String[74];
      inserirPalavras(palavras);

      for (int i = 73; i >= 0; i--)
         arvore.inserir(palavras[i], arvore.raiz); // A
      System.out.println("\n---------------------------------------------------");
      System.out.println("# # # NODOS NÍVEL A NÍVEL # # #\n");
      arvore.mostrarNodos();   // B
      System.out.println("\n---------------------------------------------------");

      System.out.println("\n# # # EXIBIR TODAS AS PALAVRAS # # #\n");
       arvore.exibirPalavras(arvore.raiz.getCabeca(),"");  // C
   }

   public static void inserirPalavras(String[] palavras) {
      palavras[0] = "patricia";         palavras[1] = "professor";
      palavras[2] = "abacate";          palavras[3] = "bicicleta";
      palavras[4] = "cachorro";         palavras[5] = "dinossauros";
      palavras[6] = "elefante";         palavras[7] = "foguete";
      palavras[8] = "guitarra";         palavras[9] = "abacaxi";
      palavras[10] = "bicudo";          palavras[11] = "amor";
      palavras[12] = "carinho";         palavras[13] = "inteligencia";
      palavras[14] = "moral";           palavras[15] = "justica";
      palavras[16] = "artificial";      palavras[17] = "fe";
      palavras[18] = "comida";          palavras[19] = "com";
      palavras[20] = "descer";          palavras[21] = "coracao";
      palavras[22] = "perfeicao";       palavras[23] = "cor";
      palavras[24] = "de";              palavras[25] = "quadrado";
      palavras[26] = "queijo";          palavras[27] = "idade";
      palavras[28] = "gambiarra";       palavras[29] = "cachimbo";
      palavras[30] = "dinossauro";      palavras[31] = "eleitor";
      palavras[32] = "foguinho";        palavras[33] = "guitarrista";
      palavras[34] = "fofoca";          palavras[35] = "festa";
      palavras[36] = "jangadeiro";      palavras[37] = "macacada";
      palavras[38] = "tecnica";         palavras[39] = "domino";
      palavras[40] = "dia";             palavras[41] = "domingo";
      palavras[42] = "zebra";           palavras[43] = "que";
      palavras[44] = "cachimbozinho";   palavras[45] = "ele";
      palavras[46] = "ela";             palavras[47] = "pesquisa";
      palavras[48] = "navega";         palavras[49] = "tecnologia";
      palavras[50] = "sapo";            palavras[51] = "saber";
      palavras[52] = "sabado";          palavras[53] = "uva";
      palavras[54] = "ovo";             palavras[55] = "ovelha";
      palavras[56] = "ovni";            palavras[57] = "xadrez";
      palavras[58] = "xicara";          palavras[59] = "video";
      palavras[60] = "vida";            palavras[61] = "videoclipe";
      palavras[62] = "videoclipes";     palavras[63] = "sombra";
      palavras[64] = "grilo";           palavras[65] = "cafe";
      palavras[66] = "infinito";        palavras[67] = "hipopotamo";
      palavras[68] = "hipotermia";      palavras[69] = "hipotese";
      palavras[70] = "cachorrinho";     palavras[71] = "cachorrinhozinho";
      palavras[72] = "navegar";         palavras[73] = "elfo";
   }
}
