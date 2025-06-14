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
                                    novo = new No(diferente,aux.getFlag(),ant,null);
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

    public void mostrarNodos() {
        Fila nivelAtual = new Fila();
        Fila proximoNivel = new Fila();
        Fila linha;
        No no;
        int nivel = 0;

        System.out.println("Nivel " + nivel + ":\t●");
        nivel++;
        if (raiz.getCabeca() != null)
            nivelAtual.enqueue(raiz.getCabeca());
        while (!nivelAtual.isEmpty())
        {
            // Imprime os nós desse nível
            linha = new Fila();
            while (!nivelAtual.isEmpty())
            {
                no = nivelAtual.dequeue();
                while (no != null)
                {
                    linha.enqueue(no);
                    if (no.getCabeca() != null)
                        proximoNivel.enqueue(no.getCabeca());
                    no = no.getCauda();
                }
            }
            // Imprime a linha com o numero do nivel
            System.out.print("Nivel " + nivel + ":");
            while (!linha.isEmpty())
            {
                no = linha.dequeue();
                System.out.print("\t" + no.getPalavra());
            }
            System.out.println();
            nivel++;
            // Passa para o proximo nível
            nivelAtual = proximoNivel;
            proximoNivel = new Fila();
        }
    }

    public void exibirPalavras(No raiz, String palavra){
        if(raiz!=null) {
            if (raiz.getFlag())
                System.out.println(palavra + raiz.getPalavra());
            if (raiz.getCabeca() != null)
                exibirPalavras(raiz.getCabeca(), palavra + raiz.getPalavra());
            if (raiz.getCauda() != null)
                exibirPalavras(raiz.getCauda(), palavra);
        }
    }
}
