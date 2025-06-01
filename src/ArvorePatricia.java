public class ArvorePatricia {

    // Reset
    public static final String RESET = "\u001B[0m";

    public static final String[] CORES = {
            "\u001B[31m",  // 0 - Vermelho
            "\u001B[32m",  // 1 - Verde
            "\u001B[33m",  // 2 - Amarelo
            "\u001B[34m",  // 3 - Azul
            "\u001B[35m",  // 4 - Roxo
            "\u001B[36m",  // 5 - Ciano
            "\u001B[37m",  // 6 - Branco

            "\u001B[90m",  // 7 - Preto brilhante (cinza)
            "\u001B[91m",  // 8 - Vermelho brilhante
            "\u001B[92m",  // 9 - Verde brilhante
            "\u001B[93m",  // 10 - Amarelo brilhante
            "\u001B[94m",  // 11 - Azul brilhante
            "\u001B[95m",  // 12 - Roxo brilhante
            "\u001B[96m",  // 13 - Ciano brilhante
            "\u001B[97m"   // 14 - Branco brilhante
    };

    No raiz;

    public ArvorePatricia(){
        raiz = new No();
    }

    public String separarParteIgual(String info, String palavra){
        String p = "";
        int i=0;
        while (i<info.length() && i<palavra.length() && info.charAt(i)==palavra.charAt(i))
        {
            p = p+info.charAt(i);
            i++;
        }
        return p;
    }

    public String separarParteDiferente(String info, String palavra){
        String p = "";
        int i=0;
        while (i<info.length() && i<palavra.length() && info.charAt(i)==palavra.charAt(i))
            i++;
        while (i<palavra.length()) {
            p = p+palavra.charAt(i);
            i++;
        }
        return p;
    }

    public void inserir(String info, No r){
        No novo, aux, ant;
        String igual, diferente;
        int tamanho;

        novo = new No(info,true,null,null);
        if(r.getCabeca()==null)// raiz esta vazia
            r.setCabeca(novo);
        else
        {
            if(r.getCabeca().getPalavra().charAt(0)>info.charAt(0))  // primeira letra da raiz vem depois da letra de info
            {
                novo.setCauda(r.getCabeca());
                r.setCabeca(novo);
            }
            else
            {
                aux = r.getCabeca();
                ant = null;
                while (aux != null && aux.getPalavra().charAt(0) < info.charAt(0)) //buscar pela primeira letra da info na arvore
                {
                    ant = aux;
                    aux = aux.getCauda();
                }

                if (aux == null)// primeira letra não foi encontrada, se não tem a letra logo não tem a palavra, tem que inserir
                    ant.setCauda(novo);
                else
                {
                    if(aux.getPalavra().charAt(0) > info.charAt(0))
                    {
                        novo.setCauda(aux);
                        ant.setCauda(novo);
                    }
                    else{
                        if(aux.getPalavra().equals(info)) // a palavra de aux é igual a info
                            aux.setFlag(true);
                        else {
                            tamanho = aux.getTamanhoIgualdade(info);  // verifica a quantidade de valores que são iguais
                            if (tamanho == info.length()) { // a palavra de aux contem info dentro dela

                                diferente = separarParteDiferente(info,aux.getPalavra()); //retira a parte de aux que info não possui
                                ant = aux.getCabeca();
                                novo.setPalavra(diferente);
                                novo.setCabeca(ant);
                                aux.setCabeca(novo); // adiciona essa parte diferente na cabeça de aux
                                aux.setPalavra(info); // muda a palvra de aux para info
                            } else{
                                if(tamanho == aux.getPalavra().length()){ // info contem a palavra de aux dentro dele
                                    diferente = separarParteDiferente(aux.getPalavra(),info); // retira a parte de info que aux não possui e insere na posição correta
                                    inserir(diferente,aux);
                                }
                                else{ // info conte parte que aux não possuie e vice-versa
                                    diferente = separarParteDiferente(info,aux.getPalavra());  // separa a parte diferente da palavra de aux
                                    igual = separarParteIgual(info,aux.getPalavra()); // separa a parte que é igual tanto para info quanto para a palvra de aux
                                    ant = aux.getCabeca();
                                    novo.setPalavra(diferente);
                                    novo.setCabeca(ant);
                                    aux.setCabeca(novo); // adiciona essa parte diferente na cabeça de aux
                                    diferente = separarParteDiferente(aux.getPalavra(),info); // retira a parte de info que aux não possui
                                    aux.setPalavra(igual); // muda a palvra para a parte que ambos possuem
                                    aux.setFlag(false);
                                    inserir(diferente,aux); // insere a parte que info possui mas aux não
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public int nivelMaximo(){
        No aux = raiz;
        int i= 0;
        while (aux != null){
            i++;
            aux = aux.getCabeca();
        }
        return i;
    }

    /*public void mostrarNodos(){
        Fila pai = new Fila();
        Fila filho = new Fila();
        No aux, quantFilhos;
        int nivel = nivelMaximo()+1, cor=0;
        boolean flag = false;
        for (int j = 0; j <= nivel; j++) {
            System.out.printf("\t");
        }
        System.out.printf("●");
        for (int j = 0; j <= nivel; j++) {
            System.out.printf("\t");
        }
        System.out.println();

        pai.inserir(raiz.getCabeca(),cor);
        while (!pai.filaVazia()){
            cor = pai.cor();
            aux = pai.retirar();
          //  if(aux.getPalavra().equals(" "))
          //      System.out.println();
           // else{
                for (int j = 0; j <= nivel; j++) {
                    System.out.printf("\t");
                }
                System.out.printf(CORES[cor]+aux.getPalavra());

                if(aux.getCabeca()!=null) {
                    for (int j = 0; j <= nivel; j++) {
                        System.out.printf("\t");
                    }
                    filho.inserir(aux.getCabeca(),cor);
                }

                if(aux.getCauda()!=null) {
                    if(!flag)
                        if (cor == 14)
                            pai.inserir(aux.getCauda(), 0);
                        else
                            pai.inserir(aux.getCauda(), cor + 1);
                    else
                        pai.inserir(aux.getCauda(), cor);
                }

           // }
            if(pai.filaVazia() && !filho.filaVazia()){
                cor = filho.cor();
                pai.inserir(filho.retirar(),cor);
                if(!filho.filaVazia() && !filho.topo().equals("\n"))
                    filho.inserir(new No("\n",true,null,null),cor);
                System.out.println();
                flag = true;
            }
        }
        System.out.println(RESET);
    }*/


    public void mostrarNodos() {
        Fila nivelAtual = new Fila();  // Fila do nível atual
        Fila proximoNivel = new Fila(); // Fila do próximo nível
        int cor;

        // Imprime a raiz
        int nivel = nivelMaximo() + 1;
        for (int j = 0; j <= nivel; j++) System.out.print("\t");
        System.out.println("●");

        if (raiz.getCabeca() != null)
            nivelAtual.inserir(raiz.getCabeca(), 0);

        while (!nivelAtual.filaVazia()) {
            // Imprimir todos os nós do nível atual (percorrendo caudas)
            Fila linha = new Fila();

            while (!nivelAtual.filaVazia()) {
                cor = nivelAtual.cor();
                No no = nivelAtual.retirar();


                // Percorre a cadeia de irmãos (ligação por cauda)
                while (no != null) {
                    linha.inserir(no, cor);

                    // Se tiver filhos, adiciona na fila do próximo nível
                    if (no.getCabeca() != null)
                        proximoNivel.inserir(no.getCabeca(), cor);

                    no = no.getCauda();  // vai para o irmão
                    if (cor == 14) cor = 0;
                    else cor++;
                }
            }

            // Imprime todos os nós do nível atual em uma linha
            while (!linha.filaVazia()) {
                cor = linha.cor();
                No no = linha.retirar();
                System.out.print("\t" + CORES[cor] + no.getPalavra() + RESET);
            }
            System.out.println();

            // Passa para o próximo nível
            nivelAtual = proximoNivel;
            proximoNivel = new Fila();
        }
    }


    /*public void exibirPalavras(){
        No aux = null;
        Pilha pilha = new Pilha();
        String palavra = "";
        pilha.inserir(raiz.getCabeca());
        while (!pilha.pilhaVazia()){
            aux = pilha.retirar();
            while(aux.getCabeca()!=null){
                pilha.inserir(aux);
                palavra = palavra+aux.getPalavra();
                if(aux.getFlag()==true)
                    System.out.println();
                aux = aux.getCabeca();
            }

        }
    }*/
}
