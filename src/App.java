/*passo 1: gioca solo l'utente. Il programma chiede in che posizione (riga,colonna) inserire la X e viene mostrata la griglia con la X nel posto indicato. 
Le caselle vuote mostreranno invece il simbolo "-" */

/*passo 2:  ripetere l'inserimento fino a quando non si completano tutte le caselle.
Verificare che l'utente non scelga una casella già occupata oppure non valida (es: riga 5, colonna 0).
Dopo ogni iterazione ristampare la griglia*/

// passo 3: alternare i simboli inseriti nella griglia ("X" e "O")

/*  passo 4: il simbolo "O" viene piazzato dal computer generando in maniera casuale riga e colonna (vericare che non sia già occupata)
Mostrare, per ogni turno, qual è il giocatore corrente (utente o computer)*/

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Benvenuto al gioco Tris");

        String[][] griglia = new String[3][3];

        // for di creazione griglia
        for (int i = 0; i < griglia.length; i++) {
            for (int j = 0; j < griglia[i].length; j++) {
                griglia[i][j] = "-";
                System.out.print(griglia[i][j]);
            }
            System.out.println("");
        }

        int contatore = 0;
        boolean pieno = true;
        boolean controllo = true;
        int riga = 0;
        int colonna = 0;

        while (pieno) {
            while (controllo) {
                if (contatore % 2 == 0) {

                    System.out.println(" turno utente ");
                    System.out.println("In che posizione vuoi inserire la x?");
                    System.out.println("Inserisci la riga");
                    riga = input.nextInt() - 1;
                    System.out.println("Inserisci la colonna");
                    colonna = input.nextInt() - 1;
                } else {
                    System.out.println(" turno pc ");
                    riga = r.nextInt(griglia.length);
                    colonna = r.nextInt(griglia[0].length);
                }

                if (riga < 0 || riga >= griglia.length || colonna < 0 || colonna >= griglia[0].length) {
                    System.out.println("Inserimenti errati");
                    System.out.println("-------------------");
                } else if (griglia[riga][colonna].equals("x") || griglia[riga][colonna].equals("o")) {
                    System.out.println("Posizione occupata");
                } else
                    controllo = false;
            }
            controllo = true;

            if ((contatore % 2) == 0) {
                griglia[riga][colonna] = "x";
            } else {
                griglia[riga][colonna] = "o";
            }

            contatore++;

            for (int i = 0; i < griglia.length; i++) {
                for (int j = 0; j < griglia[i].length; j++) {
                    System.out.print(griglia[i][j]);
                }
                System.out.println("");
            }
            if (contatore == griglia.length * griglia[0].length) {
                System.out.println("Griglia piena");
                pieno = false;
            }
        }
        input.close();
    }
}