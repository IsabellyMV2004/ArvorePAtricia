public class ArvorePatricia {
    No raiz;

    public ArvorePatricia(){
        raiz = new No();
    }

    public String separarPalavrasIguais(String info, String palavra){
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
    public String separarPalavraDiferentes(String info, String palavra){
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
        String pI, pD;
        int i=0, tamanho;

        if(raiz.getCabeca()==null) // raiz esta vazia
            raiz.setCabeca(new No(info,true,null,null));
        else
        {
            if(raiz.getCabeca().getPalavra().charAt(0)==info.charAt(0))
            {
                if(raiz.getCabeca().getPalavra().equals(info))
                    raiz.setFlag(true);
                else
                {
                    tamanho = raiz.getCabeca().getTamanhoIgualdade(info);  // verifica a quantidade de valores que são iguais
                    if(tamanho < info.length()){

                    }
                    else{

                    }
                }

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
                    ant.setCauda(new No(info, true, null, null));
                else
                {
                    if (aux.getPalavra().charAt(0) > info.charAt(0)) // primeira letra não foi encontrada na posição que deveria estar, deve ser adicionada na posição correta
                    {
                        if (ant == null) // significa que deve ser inserida como a letra da primeira posição da raiz
                        {
                            novo = new No(info, true, null, null);
                            novo.setCauda(raiz.getCabeca());
                            raiz.setCabeca(novo);
                        }
                        else
                        {
                            novo = new No(info, true, null, aux);
                            ant.setCauda(novo);
                        }
                    }
                    else
                    { // encontrou a primeira letra
                       tamanho = aux.getTamanhoIgualdade(info);  // verifica a quantidade de valores que são iguais
                       if(tamanho == info.length()){  // se for do tamanho do info quer dizer vai ter que dividir a palavra em dois
                           aux.setPalavra(separarPalavraDiferentes(info, aux.getPalavra()));
                           novo = new No(info,true,aux,aux.getCauda());
                           ant.setCauda(novo);
                       }
                       else if(tamanho < info.length()){ // se o tamanho for menor quer o info que dizer que é o info que tem valores a mais que devem ser divididos
                            if(aux.getCabeca()==null) // o no não possui ramificações abaixo dele
                                aux.setCabeca(new No(separarPalavraDiferentes(info, aux.getPalavra()), true, null, null));
                            else{ // o no possui ramificações abaixo dele
                                    inserir(separarPalavraDiferentes(info,aux.getPalavra()),aux);
                            }
                       }
                    }
                }
            }
        }
    }

    public void mostrarNodos(){

    }

    public void exibirPalavras(){

    }
}
