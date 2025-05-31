public class ArvorePatricia {
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
           // System.out.println("separarParteIgual = "+p);
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
           // System.out.println("separarParteDiferente = "+p);
            i++;
        }
        return p;
    }

    public void inserir(String info, No r){
        No novo, aux, ant;
        String igual, diferente;
        int tamanho;
        System.out.println("\n\n\n\naaaaaaaaaa "+info);

        novo = new No(info,true,null,null);
        if(r.getCabeca()==null)// raiz esta vazia
            r.setCabeca(novo);
        else
        {
            //System.out.println("CCCCCCCC");
            if(r.getCabeca().getPalavra().charAt(0)>info.charAt(0))  // primeira letra da raiz vem depois da letra de info
            {
                //System.out.println("FFFFFFF");
                novo.setCauda(r.getCabeca());
                r.setCabeca(novo);
            }
            else
            {
               // System.out.println("lllllll");
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
                {//System.out.println("palavra aux ="+aux.getPalavra());
                    if(aux.getPalavra().charAt(0) > info.charAt(0))
                    {
                        //System.out.println("d");
                        novo.setCauda(aux);
                        ant.setCauda(novo);
                    }
                    else{
                        if(aux.getPalavra().equals(info)) // a palavra de aux é igual a info
                            aux.setFlag(true);
                        else {
                            //System.out.println("BBBBBBBBBBBBBBB");
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
                                    //System.out.println("diferente = "+diferente+" aux ="+aux.getPalavra());
                                    inserir(diferente,aux);
                                }
                                else{ // info conte parte que aux não possuie e vice-versa
                                    diferente = separarParteDiferente(info,aux.getPalavra());  // separa a parte diferente da palavra de aux
                                    igual = separarParteIgual(info,aux.getPalavra()); // separa a parte que é igual tanto para info quanto para a palvra de aux
                                    //System.out.println("\n\ndiferente = "+diferente+" igual ="+igual);
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

    public void mostrarNodos(){
        Fila fila = new Fila();
        No aux;
        int nivel = nivelMaximo()+1;
        fila.inserir(raiz.getCabeca());
        while (!fila.filaVazia()){
            aux = fila.retirar();
            while (aux!=null){
                fila.inserir(aux);
                for (int j = 0; j <= nivel; j++) {
                    System.out.printf("\t");
                }
                System.out.printf(aux.getPalavra());
                for (int j = 0; j <= nivel; j++) {
                    System.out.printf("\t");
                }
                aux = aux.getCauda();
                if(aux == null){
                    aux = fila.retirar();

                    aux = aux.getCabeca();
                    System.out.println();
                }
            }
        }
    }


   /* public void mostrarNodos() {
        Fila fila = new Fila(); // Suponha que esta fila seja segura e não altere a árvore
        No marcador = new No(); // Marcador de fim de nível
        fila.inserir(raiz.getCabeca());
        fila.inserir(marcador);

        while (!fila.filaVazia()) {
            No atual = fila.retirar();

            if (atual == marcador) {
                System.out.println(); // Fim de um nível
                if (!fila.filaVazia()) {
                    fila.inserir(marcador); // Marca novo fim de nível
                }
                continue;
            }

            // Imprime o nó atual
            if (atual != null) {
                System.out.print("[" + atual.getPalavra() + (atual.getFlag() ? "*" : "") + "] ");

                // Insere os filhos (cabeça e cauda) na fila
                No filho = atual.getCabeca();
                while (filho != null) {
                    fila.inserir(filho);
                    filho = filho.getCauda();
                }
            }
        }
    }*/



    public void mostrar(){
        No aux = raiz.getCabeca();
        while (aux!=null){
            System.out.printf(aux.getPalavra()+ "\t");
            aux = aux.getCauda();
        }
    }

    public void exibirPalavras(){

    }
}
