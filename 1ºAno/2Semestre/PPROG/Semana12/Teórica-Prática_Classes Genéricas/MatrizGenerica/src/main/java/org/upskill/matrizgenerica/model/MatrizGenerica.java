package org.upskill.matrizgenerica.model;

import java.util.ArrayList;
import java.util.List;

public class MatrizGenerica<E> {

    private List<List<E>> matrizGenerica;
    private int numeroMaximoColunas;

    public MatrizGenerica() {
        this.matrizGenerica = new ArrayList<>();
        this.numeroMaximoColunas = 0;
    }

    public int getNumeroDeLinhas() {
        return this.matrizGenerica.size();
    }

    public int getNumeroDeColunas(int indiceLinha) {
        verificarIndiceLinha(indiceLinha);
        return this.matrizGenerica.get(indiceLinha).size();
    }

    public void limpar() {
        this.matrizGenerica.clear();
    }

    private int tamanhoColuna(int indice) {
        verificarIndiceColuna(indice);
        int numeroLinhas = 0;
        for (List<E> linha : this.matrizGenerica) {
            if (indice < linha.size()) {
                numeroLinhas++;
            }
        }
        return numeroLinhas;
    }

    private void verificarIndiceLinha(int indice) {
        if (indice < 0 || indice >= this.matrizGenerica.size()) {
            throw new IndexOutOfBoundsException(mensagemIndiceLinhaInvalido(indice));
        }
    }

    private void verificarIndiceColuna(int indiceColuna) {
        if (indiceColuna < 0 || indiceColuna >= this.numeroMaximoColunas) {
            throw new IndexOutOfBoundsException(mensagemIndiceColunaInvalido(indiceColuna));
        }
    }

    private void verificarIndices(int indiceLinha, int indiceColuna) {
        if (indiceLinha < 0 || indiceLinha >= this.matrizGenerica.size())
            throw new IndexOutOfBoundsException(mensagemIndiceLinhaInvalido(indiceLinha));

        if (indiceColuna < 0 || indiceColuna >= this.matrizGenerica.get(indiceLinha).size())
            throw new IndexOutOfBoundsException(mensagemIndiceLInhaColunaInvalido(indiceLinha,indiceColuna));
    }

    private String mensagemIndiceLinhaInvalido(int indice) {
        return "Tentativa de acesso ao índice de linha: " + indice + " e o número de linhas da matriz: " + this.matrizGenerica.size();
    }

    private String mensagemIndiceColunaInvalido(int indiceColuna) {
        return "Tentativa de acesso ao índice de coluna: " + indiceColuna + " e o número máximo de colunas da matriz: " + this.numeroMaximoColunas;
    }

    private String mensagemIndiceLInhaColunaInvalido(int indiceLinha, int indiceColuna) {
        return "Tentativa de acesso ao índice de coluna: " + indiceColuna + " e o número de colunas dessa linha da matriz: " + this.matrizGenerica.get(indiceLinha).size();
    }

}
