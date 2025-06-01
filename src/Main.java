public class Main {

   public static void main(String[] args) {
      ArvorePatricia arvore = new ArvorePatricia();
      String[] palavras = new String[65];
      inserirPalavras(palavras);

      for (int i = 64; i >= 0; i--) {
         arvore.inserir(palavras[i], arvore.raiz);
         arvore.mostrarNodos();
        // arvore.mostrar();
      }

      // arvore.exibirPalavras();
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
      palavras[9] = "helicoptero";
      palavras[10] = "igreja";
      palavras[11] = "jangada";
      palavras[12] = "kiwi";
      palavras[13] = "laranja";
      palavras[14] = "macaco";
      palavras[15] = "navio";
      palavras[16] = "ovelha";
      palavras[17] = "piano";
      palavras[18] = "quadro";
      palavras[19] = "rato";
      palavras[20] = "sabonete";
      palavras[21] = "tigre";
      palavras[22] = "urso";
      palavras[23] = "violino";
      palavras[24] = "waffle";
      palavras[25] = "xicara";
      palavras[26] = "yakissoba";
      palavras[27] = "zebra";
      palavras[28] = "abacaxi";
      palavras[29] = "bicudo";
      palavras[30] = "amor";
      palavras[31] = "carinho";
      palavras[32] = "inteligencia";
      palavras[33] = "moral";
      palavras[34] = "justica";
      palavras[35] = "artificial";
      palavras[36] = "fe";
      palavras[37] = "comida";
      palavras[38] = "com";
      palavras[39] = "descer";
      palavras[40] = "saber";
      palavras[41] = "sabre";
      palavras[42] = "coracao";
      palavras[43] = "perfeicao";
      palavras[44] = "cor";
      palavras[45] = "de";
      palavras[46] = "oftalmotorrinolaringologista";
      palavras[47] = "piperidinoetoxicarbometoxibenzofenona";
      palavras[48] = "paraclorobenzilpirrolidinonetilbenzimidazol";
      palavras[49] = "pneumoultramicroscopicossilicovulcanoconiotico";
      palavras[50] = "cachimbo";
      palavras[51] = "dinossauro";
      palavras[52] = "eleitor";
      palavras[53] = "foguinho";
      palavras[54] = "guitarrista";
      palavras[55] = "fofoca";
      palavras[56] = "festa";
      palavras[57] = "jangadeiro";
      palavras[58] = "macacada";
      palavras[59] = "navalha";
      palavras[60] = "sabado";
      palavras[61] = "domino";
      palavras[62] = "dia";
      palavras[63] = "repetir";
      palavras[64] = "domingo";
   }
}
