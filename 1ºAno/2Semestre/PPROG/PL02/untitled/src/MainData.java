public class MainData {
    public static void main(String[] args) {
        // Criar uma instância de Data com a data de hoje
        data data1 = new data(2025, 2, 28);

        // Mostrar data1 no formato por extenso
        System.out.println("Data1 por extenso: " + data1.toString());

        // Criar outra instância da classe Data representando 25 de abril de 1974
        data data2 = new data(1974, 4, 25);

        // Mostrar data2 no formato "ano/mês/dia"
        System.out.println("Data2 (ano/mês/dia): " + data2.toAnoMesDiaString());

        // Verificar se data1 é mais recente que data2
        System.out.println("Data1 é mais recente que Data2? " + data1.isMaior(data2));

        // Determinar o número de dias entre data1 e data2
        System.out.println("Dias entre Data1 e Data2: " + data1.calcularDiferenca(data2));

        // Determinar o número de dias até o próximo Natal (25 de dezembro do mesmo ano de data1)
        System.out.println("Dias até o Natal: " + data1.calcularDiferenca(2025, 12, 25));

        // Determinar o dia da semana do dia 25 de abril de 1974
        System.out.println("Dia da semana de 25 de abril de 1974: " + data2.determinarDiaDaSemana());

        // Verificar se 1974 foi um ano bissexto
        System.out.println("O ano 1974 foi bissexto? " + data.isAnoBissexto(1974));
        System.out.println("O ano 1974 foi bissexto? " + data.isAnoBissexto(1974));
    }
}
