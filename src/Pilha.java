public class Pilha {
    private NoFila inicio, fim;

    public Pilha() {
        inicio = fim = null;
    }

    public boolean pilhaVazia() {
        return inicio == null;
    }

    public void inserir(No elemento) {
        NoFila novo = new NoFila(elemento);
        if (pilhaVazia()) {
            inicio = fim = novo;
        } else {
            inicio.setProximo(novo);
            inicio = novo;
        }
    }

    public No retirar() {
        if (pilhaVazia())
            return null;
        No dado = inicio.getDado();
        inicio = inicio.getProximo();
        if (inicio == null)
            fim = null;
        return dado;
    }
}
