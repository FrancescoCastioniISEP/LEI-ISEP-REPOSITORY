package org.example;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("qual é o seu nome ?");
        String nome = scanner.nextLine();
        System.out.println("qual é a sua idade ?");
        int idade = scanner.nextInt();
        Pessoa pessoa = new Pessoa(nome, idade);

        System.out.println("Ola, " + pessoa.getNome() + "!");
        System.out.println(pessoa);
    }
}