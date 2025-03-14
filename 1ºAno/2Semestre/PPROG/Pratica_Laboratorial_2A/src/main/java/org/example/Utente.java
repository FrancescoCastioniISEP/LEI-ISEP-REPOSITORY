package org.example;

/**
 * Classe que representa um utente de ginásio.
 */
public class Utente {
    // Constantes para valores padrão
    private static final String NOME_POR_OMISSAO = "Desconhecido";
    private static final String GENERO_POR_OMISSAO = "Não definido";
    private static final int IDADE_POR_OMISSAO = 0;
    private static final double ALTURA_POR_OMISSAO = 1.70;
    private static final double PESO_POR_OMISSAO = 70.0;

    // Atributos
    private String nome;
    private String genero;
    private int idade;
    private double altura;
    private double peso;

    // Contador de instâncias
    private static int contadorInstancias = 0;

    /**
     * Construtor vazio, inicializa com valores padrão.
     */
    public Utente() {
        this(NOME_POR_OMISSAO, GENERO_POR_OMISSAO, IDADE_POR_OMISSAO, ALTURA_POR_OMISSAO, PESO_POR_OMISSAO);
    }

    /**
     * Construtor com nome e idade.
     * @param nome Nome do utente
     * @param idade Idade do utente
     */
    public Utente(String nome, int idade) {
        this(nome, GENERO_POR_OMISSAO, idade, ALTURA_POR_OMISSAO, PESO_POR_OMISSAO);
    }

    /**
     * Construtor completo.
     * @param nome Nome do utente
     * @param genero Género do utente
     * @param idade Idade do utente
     * @param altura Altura do utente (em metros)
     * @param peso Peso do utente (em kg)
     */
    public Utente(String nome, String genero, int idade, double altura, double peso) {
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        contadorInstancias++;
    }

    // Métodos de acesso (getters)
    public String getNome() { return nome; }
    public String getGenero() { return genero; }
    public int getIdade() { return idade; }
    public double getAltura() { return altura; }
    public double getPeso() { return peso; }

    // Métodos de modificação (setters)
    public void setNome(String nome) { this.nome = nome; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setIdade(int idade) { this.idade = idade; }
    public void setAltura(double altura) { this.altura = altura; }
    public void setPeso(double peso) { this.peso = peso; }

/**
 * Representação textual do utente.
 * @return String formatada com os dados do utente.
 */
    @Override
    public String toString() {
        return String.format("Nome: %s, Género: %s, Idade: %d, Altura: %.2f m, Peso: %.2f kg",
                nome, genero, idade, altura, peso);
    }
    /**
     * Calcula a diferença de idades entre dois utentes.
     * @param outro Utente para comparar
     * @return Diferença de idades
     */
    public int diferencaIdades(Utente outro) {
        return Math.abs(this.idade - outro.idade);
    }
    public double IMC (){
        return this.peso/(this.altura*this.altura);
    }
    /**
     * Determina o grau de obesidade com base no IMC.
     * @return Classificação de acordo com o IMC
     */
    public String grauObesidade(){
        double imc = IMC();
        if (imc < 18) return "Magro";
        if (imc <= 25) return "Saudável";
        return "Obeso";
    }
    /**
     * Verifica se o utente tem classificação "Saudável".
     * @return true se for saudável, false caso contrário.
     */
    public boolean isSaudavel() {
        return "Saudável".equals(grauObesidade());
    }
    /**
     * Determina qual utente é mais novo.
     * @param outro Utente a comparar
     * @return -1 se o primeiro for mais novo, 1 se for mais velho, 0 se tiverem a mesma idade.
     */
    public int compararIdade(Utente outro) {
        return Integer.compare(this.idade, outro.idade);
    }
    /**
     * Obtém o número de instâncias de utentes criadas.
     * @return Número total de instâncias criadas
     */
    public static int getNumeroInstancias() {
        return contadorInstancias;
    }
}
