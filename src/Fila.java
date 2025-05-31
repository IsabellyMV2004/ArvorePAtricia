public class Fila {
    private int fim;
    No dados;

    public void Fila(){
        fim = 0;
        dados = null;
    }

    public boolean filaVazia(){
        return fim == 0;
    }

    public  void inserir(No elemento){
        No aux = dados;
        for (int i = 0; i < fim; i++) {
            aux = aux.getCauda();
        }
        aux.setCauda(elemento);
    }

    public No retirar(){
        No aux = dados;
        dados = dados.getCauda();
        return aux;
    }

    public String elementoInicio(){
        return dados.getPalavra();
    }

    public String elementoFim(){
        No aux = dados;
        for (int i = 0; i < fim; i++) {
            aux = aux.getCauda();
        }
        return aux.getPalavra();
    }

}
