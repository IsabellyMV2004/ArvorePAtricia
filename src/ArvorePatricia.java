public class ArvorePatricia {
    No raiz;

    public ArvorePatricia(){
        raiz = new No();
    }

    public String separarParteIgual(String info, String palavra){
        String p;
        int i=0;
        p = "" + info.charAt(0);
        while (i<info.length() && i<palavra.length() && info.charAt(i)==palavra.charAt(i))
        {
            p = p+info.charAt(i);
            i++;
        }
        return p;
    }

    public String separarParteDiferente(String info, String palavra){
        String p;
        int i=0;
        p = "" + info.charAt(0);
        while (i<info.length() && i<palavra.length() && info.charAt(i)==palavra.charAt(i))
            i++;
        while (i<palavra.length()) {
            p = p+palavra.charAt(i);
            i++;
        }
        return p;
    }

    public void inserir(String info, No raiz){
        No novo, aux, ant;
        String igual, diferente;
        int tamanho;

        novo = new No(info,true,null,null);
        if(raiz.getCabeca()==null) // raiz esta vazia
            raiz.setCabeca(novo);
        else
        {
            if(raiz.getCabeca().getPalavra().charAt(0)<info.charAt(0))  // primeira letra da raiz vem depois da letra de info
            {
                novo.setCauda(raiz.getCauda());
                raiz.setCabeca(novo);
            }
            else
            {
                aux = raiz.getCabeca();
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

    public void mostrarNodos(){
        Fila fila = new Fila();
        No aux;
        int i = 0;
        fila.inserir(raiz.getCabeca());
        aux = raiz.getCabeca();
        while (!fila.filaVazia()){
            while (aux!=null){
                fila.inserir(aux);
                aux = aux.getCauda();
            }
            i++;
            aux = fila.retirar();

        }
    }

    public void exibirPalavras(){

    }
}
