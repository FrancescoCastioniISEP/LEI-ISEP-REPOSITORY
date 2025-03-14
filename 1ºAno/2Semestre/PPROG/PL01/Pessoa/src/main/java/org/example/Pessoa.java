package org.example;

public class Pessoa {
        private String nome;
        private int idade;

        // Construtor sem parâmetros
        public Pessoa() {
            this.nome = "";
            this.idade = 0;
        }

        // Construtor com um parâmetro (nome)
        public Pessoa(String nome) {
            this.nome = nome;
            this.idade = 0;
        }

        // Construtor com dois parâmetros (nome e idade)
        public Pessoa(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        // Métodos de consulta
        public String getNome() {
            return nome;
        }

        public int getIdade() {
            return idade;
        }

        // Métodos de modificação
        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }
        public String toString (){
            return nome + " tem " + idade + " anos.";
        }

}

