package application;
import java.util.Stack;

public class Program {

    public static void main(String[] args) {
        
    	Fila<String> fila = new Fila<>(5);
        fila.enfileirar("Joey");
        fila.enfileirar("Mike");
        fila.enfileirar("Rayanne");
        fila.enfileirar("Luci");
        fila.enfileirar("Gal");
        
        System.out.println("Fila original: " + fila);
        
        inverterFila(fila);
        
        System.out.println("Fila invertida: " + fila);
    }
    
    public static <T> void inverterFila(Fila<T> fila) {
        Stack<T> pilha = new Stack<>();
        while (!fila.estaVazia()) {
            pilha.push(fila.desenfileirar());
        }
        while (!pilha.isEmpty()) {
            fila.enfileirar(pilha.pop());
        }
    }
}