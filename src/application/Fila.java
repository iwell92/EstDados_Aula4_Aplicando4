package application;

public class Fila<T> {

    private int tamanhoMaximo;
    private T[] elementos;
    private int inicio;
    private int fim;
    private int quantidade;

    @SuppressWarnings("unchecked")
    public Fila(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.elementos = (T[]) new Object[tamanhoMaximo];
        this.inicio = 0;
        this.fim = -1;
        this.quantidade = 0;
    }

    public void enfileirar(T elemento) {
        if (estaCheia()) {
            throw new RuntimeException("Fila cheia");
        }
        fim = (fim + 1) % tamanhoMaximo;
        elementos[fim] = elemento;
        quantidade++;
    }

    public T desenfileirar() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");
        }
        T elemento = elementos[inicio];
        elementos[inicio] = null;
        inicio = (inicio + 1) % tamanhoMaximo;
        quantidade--;
        return elemento;
    }

    public T primeiro() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");
        }
        return elementos[inicio];
    }

    public int tamanho() {
        return quantidade;
    }

    public boolean estaVazia() {
        return quantidade == 0;
    }

    public boolean estaCheia() {
        return quantidade == tamanhoMaximo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < quantidade; i++) {
            int indice = (inicio + i) % tamanhoMaximo;
            sb.append(elementos[indice]);
            if (i < quantidade - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
