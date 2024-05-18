package br.com.pc2.trab2;

import java.util.Scanner;

public class Diario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array para armazenar os alunos
        Aluno[] alunos = new Aluno[100]; // Assumindo que o máximo de alunos é 100
        int totalAlunos = 0;

        // Lendo os alunos e suas notas
        while (true) {
            System.out.print("Digite a matrícula do aluno (ou 0 para encerrar): ");
            int matricula = scanner.nextInt();
            if (matricula == 0) {
                break; // Encerrar a entrada de dados se a matrícula for 0
            }
            scanner.nextLine(); // Consumir a quebra de linha pendente

            System.out.print("Digite o nome do aluno: ");
            String nome = scanner.nextLine();

            System.out.print("Digite a quantidade de notas: ");
            int quantidadeDeNotas = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente

            Double[] notas = new Double[quantidadeDeNotas];
            for (int j = 0; j < quantidadeDeNotas; j++) {
                System.out.print("Digite a nota " + (j + 1) + ": ");
                notas[j] = scanner.nextDouble();
            }
            scanner.nextLine(); // Consumir a quebra de linha pendente

            // Criando o objeto Aluno com os detalhes fornecidos e armazenando no array
            Aluno aluno = new Aluno(matricula, nome, quantidadeDeNotas);
            aluno.setNotas(notas); // Atribuir as notas ao aluno
            alunos[totalAlunos] = aluno;
            totalAlunos++;
        }

        // Exibindo a lista de alunos com notas e médias
        System.out.println("\nLista de Alunos:");
        System.out.println("Matrícula\tNome\t\tNotas\t\tMédia");
        for (int i = 0; i < totalAlunos; i++) {
            Aluno aluno = alunos[i];
            System.out.print(aluno.getMatricula() + "\t\t" + aluno.getNome() + "\t\t");
            Double[] notas = aluno.getNotas();
            double soma = 0;
            int contador = 0;
            for (Double nota : notas) {
                if (nota != null) {
                    System.out.print(nota + "\t");
                    soma += nota;
                    contador++;
                }
            }
            if (contador == 0) {
                System.out.print("N/A"); // Se nenhum nota atribuída, exibe N/A
            } else {
                double media = soma / contador;
                System.out.printf("%.2f", media);
            }
            System.out.println();
        }

        // Calculando média de cada nota
        if (totalAlunos > 0) {
            // Encontrando a maior quantidade de notas entre os alunos
            int maxQuantidadeDeNotas = 0;
            for (int i = 0; i < totalAlunos; i++) {
                maxQuantidadeDeNotas = Math.max(maxQuantidadeDeNotas, alunos[i].getNotas().length);
            }
            
            // Calculando média de cada nota
            double[] mediasPorNota = new double[maxQuantidadeDeNotas];
            int[] contadoresPorNota = new int[maxQuantidadeDeNotas];
            for (int j = 0; j < maxQuantidadeDeNotas; j++) {
                double soma = 0;
                int contador = 0;
                for (int i = 0; i < totalAlunos; i++) {
                    Double[] alunoNotas = alunos[i].getNotas();
                    if (j < alunoNotas.length && alunoNotas[j] != null) {
                        soma += alunoNotas[j];
                        contador++;
                    }
                }
                mediasPorNota[j] = contador == 0 ? 0 : soma / contador;
                contadoresPorNota[j] = contador;
            }

            // Exibindo média de cada nota
            System.out.println("\nMédia das notas:");
            for (int j = 0; j < maxQuantidadeDeNotas; j++) {
                if (contadoresPorNota[j] == 0) {
                    System.out.printf("Média da nota %d: N/A\n", j + 1);
                } else {
                    System.out.printf("Média da nota %d: %.2f\n", j + 1, mediasPorNota[j]);
                }
            }

            // Calculando média geral
            double somaTotal = 0;
            int totalContador = 0;
            for (int i = 0; i < totalAlunos; i++) {
                Double[] notas = alunos[i].getNotas();
                for (Double nota : notas) {
                    if (nota != null) {
                        somaTotal += nota;
                        totalContador++;
                    }
                }
            }
            double mediaGeral = totalContador == 0 ? 0 : somaTotal / totalContador;
            System.out.printf("\nMédia geral: %.2f\n", mediaGeral);
        } else {
            System.out.println("\nNão há alunos para calcular médias.");
        }

        // Fechando o scanner
        scanner.close();
    }
}