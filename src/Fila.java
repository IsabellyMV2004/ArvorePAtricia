public class Fila {
    private int fim;
    No dados;

    public void Fila(){
        fim = 0;
        dados = null;
    }

    public boolean FilaVazia(){
        return fim == 0;
    }

    public  void Inserir(No elemento){
        No aux = dados;
        for (int i = 0; i < fim; i++) {
            aux = aux.getCauda();
        }
        aux.setCauda(elemento);
    }

    public No Retirar(){
        No aux = dados;
        dados = dados.getCauda();
        return aux;
    }

    public String ElementoInicio(){
        return dados.getPalavra();
    }

    public String ElementoFim(){
        No aux = dados;
        for (int i = 0; i < fim; i++) {
            aux = aux.getCauda();
        }
        return aux.getPalavra();
    }
}
