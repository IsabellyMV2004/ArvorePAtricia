public class ArvorePatricia {

    No raiz;

    public ArvorePatricia(){
        raiz = new No();
    }

    public int length(String info) {
        int i = 0;
        try {
            while (true) {
                info.charAt(i);
                i++;
            }
        } catch (Exception e) {
            return i;
        }
    }

    public String separarParteIgual(String info, String palavra){
        String p = "";
        int i=0, tamanhoI = length(info), tamanhoP=length(palavra);

        info.length();

        while (i<tamanhoI && i<tamanhoP && info.charAt(i)==palavra.charAt(i))
        {
            p = p+info.charAt(i);
            i++;
        }
        return p;
    }

    public String separarParteDiferente(String info, String palavra){
        String p = "";
        int i=0, tamanhoI = length(info), tamanhoP=length(palavra);
        while (i<tamanhoI && i<tamanhoP && info.charAt(i)==palavra.charAt(i))
            i++;
        while (i<tamanhoP) {
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
                            if (tamanho == length(info)) { // a palavra de aux contem info dentro dela

                                diferente = separarParteDiferente(info,aux.getPalavra()); //retira a parte de aux que info não possui
                                ant = aux.getCabeca();
                                novo.setPalavra(diferente);
                                novo.setCabeca(ant);
                                aux.setCabeca(novo); // adiciona essa parte diferente na cabeça de aux
                                aux.setPalavra(info); // muda a palvra de aux para info
                            } else{
                                if(tamanho == length(aux.getPalavra())){ // info contem a palavra de aux dentro dele
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

    public void mostrarNodos() {
        Fila nivelAtual = new Fila();
        Fila proximoNivel = new Fila();
        int numeroNivel = 0;

        // Imprime a raiz
        System.out.println("Nivel " + numeroNivel + ":\t●");
        numeroNivel++;

        if (raiz.getCabeca() != null)
            nivelAtual.inserir(raiz.getCabeca());

        while (!nivelAtual.filaVazia()) {
            // Imprime os nós desse nível
            Fila linha = new Fila();

            while (!nivelAtual.filaVazia()) {
                No no = nivelAtual.retirar();

                while (no != null) {
                    linha.inserir(no);

                    if (no.getCabeca() != null)
                        proximoNivel.inserir(no.getCabeca());

                    no = no.getCauda();
                }
            }

            // Imprime a linha com o número do nível
            System.out.print("Nivel " + numeroNivel + ":");
            while (!linha.filaVazia()) {
                No no = linha.retirar();
                System.out.print("\t" + no.getPalavra());
            }
            System.out.println();
            numeroNivel++;

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
