/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf3m212pj;

import java.util.Scanner;

/**
 *
 * @author jbferraz
 */
public class NotasEscolaresMatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leia = new Scanner(System.in);
        System.out.println("Notas Escolares Matriz");
        System.out.print("Quantos alunos? ");
        int nAlunos = (int) leiaFloat();
        System.out.print("Quantas notas? ");
        int nNotas = (int) leiaFloat();

        String alunos[] = new String[nAlunos];
        float notas[][] = new float[nAlunos][nNotas + 1];
        //nNotas + 1 pra ter uma posição pra guardar a média

        for (int i = 0; i < nAlunos; i++) {//percorre os alunos
            System.out.print("Nome do aluno: ");
            alunos[i] = leia.next();
            for (int j = 0; j < nNotas; j++) {//percorre as notas
                do {
                    System.out.print("\tDigite a " + (j + 1) + "ª nota: ");
                    notas[i][j] = leiaFloat();
                    if (validaNota(notas[i][j])) {
                        System.out.println("Nota inválida, tente novamente!");
                    }
                } while (validaNota(notas[i][j]));
                notas[i][nNotas] += notas[i][j]; //acumula as notas
            }//fim for notas
            notas[i][nNotas] = notas[i][nNotas] / nNotas; //calc. média
        }//fim for alunos
        System.out.println("\n--- Resultado ---\n");
        for (int i = 0; i < nAlunos; i++) {//impressão no console
            System.out.printf(alunos[i] + " sua média foi de %.2f", notas[i][nNotas]);
            if (notas[i][nNotas] >= 7) {
                System.out.println(" e você aprovou!");
            } else {
                System.out.println(" e infelizmente você reprovou!");
            }
        }//fim for de saída no console
    }//fim da main

    /**
     * Função validaNota serve para validar notas que estejam fora do intervalo
     * de 0 - 10.
     *
     * @param nota
     * @return
     */
    public static boolean validaNota(float nota) {
        return nota < 0 || nota > 10;// || significa ou
    }//fim validaNota

    public static float leiaFloat() {
        Scanner leia = new Scanner(System.in);
        try {
            return leia.nextFloat();
        } catch (Exception e) {
            System.out.print("Valor não é núm., tente novamente: ");
            return leiaFloat();
        }
    }//fim leiaFloat()

}
