public class NoFila {
    private No dado;
    private NoFila proximo;

    private int cor;

    public NoFila(No dado, int cor) {
        this.dado = dado;
        this.cor = cor;
        this.proximo = null;
    }

    public No getDado() {
        return dado;
    }
    public NoFila getProximo() {
        return proximo;
    }
    public void setProximo(NoFila proximo) {
        this.proximo = proximo;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }
}
