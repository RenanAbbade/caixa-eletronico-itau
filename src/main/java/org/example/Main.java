package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Notas disponíveis de R$ 100,00; R$ 50,00; R$ 20,00 e R$ 10,00 - Todos multiplos de 10
        //Dado que só é possível sacar o valor solicitado com as notas disponíveis; O valor solicitado deve ser divisivel por 10
        System.out.println("-- Caixa Eletronico --");
        Scanner scanner = new Scanner(System.in);
        int withdrawalAmount;
        System.out.print("Digite o valor do saque: R$ ");

        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, digite um valor monetário válido.");
            scanner.next();
        }

        withdrawalAmount = scanner.nextInt();

        int[] moneyNotes = {100, 50, 20, 10};
        //Iniciando por 100, por conta de que o problema espera que seja o menor número de notas.
        if (withdrawalAmount % 10 != 0) {
            System.out.println("Valor inválido. O valor do saque deve ser múltiplo de R$10, pois só temos as seguintes notas disponíveis: " + Arrays.toString(moneyNotes));
            return;
        }

        int[] quantityNotes = new int[moneyNotes.length];

        for (int i = 0; i < moneyNotes.length; i++) {
            quantityNotes[i] = withdrawalAmount / moneyNotes[i];
            withdrawalAmount %= moneyNotes[i];
            if(withdrawalAmount == 0)
                break;
        }

        System.out.println("Notas entregues:");
        for (int i = 0; i < moneyNotes.length; i++) {
            if (quantityNotes[i] > 0) {
                System.out.println(quantityNotes[i] + " nota(s) de R$ " + moneyNotes[i] + ",00");
            }
        }

    }
}