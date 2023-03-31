package application;

import java.util.Scanner;
import java.util.Stack;

public class Program {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite um número inteiro diferente de zero: ");
        int numero = sc.nextInt();
        
        // Validando se o número é diferente de zero
        if (numero == 0) {
            System.out.println("Número inválido!");
            return;
        }
        
        Stack<Character> pilha = new Stack<>();
        
        // Convertendo para a base hexadecimal
        while (numero != 0) {
            int resto = numero % 16;
            
            if (resto < 10) {
                pilha.push((char)(resto + 48)); // Empilhando os dígitos numéricos
            } else {
                pilha.push((char)(resto + 55)); // Empilhando as letras A-F
            }
            
            numero /= 16;
        }
        
        // Desempilhando os restos para exibir o resultado da conversão
        System.out.print("Resultado da conversão é: ");
        while (!pilha.isEmpty()) {
            System.out.print(pilha.pop());
        }
    }

}
