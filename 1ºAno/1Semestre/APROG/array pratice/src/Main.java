import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    final static double valorreCarga =5.5;

    public static void main(String[] args) {
        int dias = 0;
        int carros = 0;

        System.out.println("Introduza descrição: ");
        String descricao = scanner.nextLine();

        do {
            System.out.println("Quantidade de carros:");
            carros = scanner.nextInt();

            System.out.println("Quantidade de dias:");
            dias = scanner.nextInt();
        } while (carros <= 0 || dias <= 0);

        int[][] array = new int[carros][dias];
        criarArray(array, carros, dias);

        // Recargas (calcular quantas recargas de bateria foram feitas)
        int[][] matrizRecargas = recargas(array, carros, dias);

        // Média dos km diários
        double[] mediaKms = kmdiarios(array, carros, dias);

        // Impressão do planeamento (km/dia/veículo)
        System.out.println("Planeamento (km/dia/veículo):");
        imprimirArrayInt(array, carros, dias);

        // Total de km a percorrer
        totkms(array, carros, dias);

        // Recargas das baterias
        System.out.println("c) Recargas das baterias:");
        imprimirArrayInt(matrizRecargas, carros, dias);

        System.out.println("d) Recargas das baterias:");
        double [][] arraydouble= new double [carros][dias];
        cargaBaterias(array,carros,dias);

        // Média dos km diários
        System.out.println("e)Média dos km diários da frota:");
        imprimirArrayDoubleKm(new double[][]{mediaKms}, 1, dias); // Aqui, passamos a média como uma linha única
        valortotalrecargas(array, carros, dias);

        System.out.printf(" i)custo das recargas da frota: %.2f €" , valortotalrecargas(array,carros,dias));
    }
    // Função para criar o array com valores de entrada
    public static void criarArray(int[][] arr, int linha, int colunas) {
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < colunas; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
    }
    public static void criarArrayDouble(double[][] arr, int linha, int colunas) {
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < colunas; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
    }
    // Função para imprimir arrays de inteiros
    public static void imprimirArrayInt(int[][] arr, int linhas, int colunas) {
        System.out.print("Dia: ");
        for (int j = 0; j < colunas; j++) {
            System.out.printf("%7d", j);
        }
        System.out.println();

        System.out.print("----|");
        for (int j = 0; j < colunas; j++) {
            System.out.print("------|");
        }
        System.out.println();

        for (int i = 0; i < linhas; i++) {
            System.out.printf("V%-2d:", i);
            for (int j = 0; j < colunas; j++) {
                System.out.printf("%7d", arr[i][j]);
            }
            System.out.println();
        }
    }
    // Função para imprimir arrays de doubles
    public static void imprimirArrayDoubleKm(double[][] arr, int linhas, int colunas) {
        System.out.print("Dia:");
        for (int j = 0; j < colunas; j++) {
            System.out.printf("%7d", j);
        }
        System.out.println();

        System.out.print("---|");
        for (int j = 0; j < colunas; j++) {
            System.out.print("------|");
        }
        System.out.println();

        for (int i = 0; i < linhas; i++) {
            System.out.print("km:");
            for (int j = 0; j < colunas; j++) {
                System.out.printf("%7.2f", arr[i][j]); // Formato com 2 casas decimais
            }
            System.out.println();
        }
    }
    // Função para calcular o total de km percorridos por cada veículo
    public static void totkms(int[][] arr, int linhas, int colunas) {
        System.out.println("Total de km a percorrer:");
        for (int i = 0; i < linhas; i++) {
            int total = 0;
            for (int j = 0; j < colunas; j++) {
                total += arr[i][j];
            }
            System.out.println("V" + i + ": " + total);
        }
    }
    // Função para calcular as recargas das baterias
    public static int[][] recargas(int[][] arr, int linhas, int colunas) {
        int[][] recargas = new int[linhas][colunas];
        int resto;

        for (int i = 0; i < linhas; i++) {
            resto = 0;
            for (int j = 0; j < colunas; j++) {
                int quilometragem = arr[i][j] + resto;// 150 + 60 = 210-100-> 110-100 == 10
                int totalRecargas = 0;

                while (quilometragem > 100) {
                    quilometragem -= 100;
                    totalRecargas++;
                }

                resto = quilometragem; // 10
                recargas[i][j] = totalRecargas;
            }
        }
        return recargas;
    }
    // Função para calcular a média dos km diários
    public static double[] kmdiarios(int[][] arr, int linhas, int colunas) {
        double[] medias = new double[colunas];

        for (int j = 0; j < colunas; j++) {
            double media = 0;
            for (int i = 0; i < linhas; i++) {
                media += arr[i][j];
            }
            medias[j] = media / linhas;
        }

        return medias;
    }
    public static double valortotalrecargas (int  [][]array,int linhas,int colunas ){
        double total =0;
        int[][] matrizRecargas = recargas(array, linhas, colunas);
        for (int i =0;i<linhas;i++){
            for (int j=0;j<colunas;j++){
                total += matrizRecargas[i][j];
            }
        }
        return  total *valorreCarga;
    }
    public static void imprimirArrayDouble(double[][] arr, int linhas, int colunas) {
        System.out.print("Dia: ");
        for (int j = 0; j < colunas; j++) {
            System.out.printf("%7d", j);
        }
        System.out.println();

        System.out.print("----|");
        for (int j = 0; j < colunas; j++) {
            System.out.print("------|");
        }
        System.out.println();

        for (int i = 0; i < linhas; i++) {
            System.out.printf("V%-2d:", i);
            for (int j = 0; j < colunas; j++) {
                System.out.printf("%7.2f", arr[i][j]); // Formato com 2 casas decimais
            }
            System.out.println();
        }
    }
    public static void cargaBaterias(int[][] arr, int linhas, int colunas) {
        double[][] carga = new double[linhas][colunas]; // Matriz para armazenar o nível de carga
        double cargaInicial = 100.0; // Carga inicial
        double bateriaMomento;
        double resto;

        for (int i = 0; i < linhas; i++) {
            bateriaMomento = cargaInicial; // Atualizar o nível de carga inicial para cada veículo
            for (int j = 0; j < colunas; j++) {
                if (arr[i][j] > bateriaMomento) {
                    // Caso os kms sejam mais do que a bateria aguenta
                    resto = arr[i][j] - bateriaMomento;
                    bateriaMomento = cargaInicial - resto; // Recarregar e descontar o resto
                } else {
                    // Caso ainda seja possivel fazer mais kms
                    bateriaMomento -= arr[i][j];
                }

                // Garantir que bateria nao seja negativa
                if (bateriaMomento < 0) {
                    bateriaMomento = 0;
                }

                //  nível de carga  %
                carga[i][j] = (bateriaMomento / cargaInicial) * 100;
            }
        }


        imprimirArrayDouble(carga, linhas, colunas);
    }
}