//passo 1: gioca solo l'utente. Il programma chiede in che posizione (riga,colonna) inserire la X e viene mostrata la griglia con la X nel posto indicato. Le caselle vuote mostreranno invece il simbolo "-"

import java.util.Scanner;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner input=new Scanner(System.in);

        System.out.println("Benvenuto al gioco Tris");
        
        String [][] griglia= new String [3][3];

        //for di creazione griglia
        for(int i=0;i<griglia.length;i++)
        {
            for(int j=0;j<griglia[i].length;j++)
            {
                griglia[i][j]="-";
                System.out.print(griglia[i][j]);
            }
            System.out.println("");
        }

        System.out.println("In che posizione vuoi inserire la x?");
        System.out.println("Inserisci la riga");
        int riga = input.nextInt()-1;
        System.out.println("Inserisci la colonna");
        int colonna = input.nextInt()-1;

        griglia[riga][colonna]="x";
        
        for(int i=0;i<griglia.length;i++)
        {
            for(int j=0;j<griglia[i].length;j++)
            {
                System.out.print(griglia[i][j]);
            }
            System.out.println("");
        }
        input.close();
    }
}