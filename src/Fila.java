public class Fila {
    private NoFila inicio, fim;

    public Fila() {
        inicio = fim = null;
    }

    public boolean filaVazia() {
        return inicio == null;
    }

    public void inserir(No elemento) {
        NoFila novo = new NoFila(elemento);
        if (filaVazia()) {
            inicio = fim = novo;
        } else {
            fim.setProximo(novo);
            fim = novo;
        }
    }

    public No retirar() {
        if (filaVazia())
            return null;
        No dado = inicio.getDado();
        inicio = inicio.getProximo();
        if (inicio == null)
            fim = null;
        return dado;
    }
}
