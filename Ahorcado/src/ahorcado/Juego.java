package ahorcado;

import java.util.Scanner;

public class Juego {
    
    public int elegirDificultad(){
        int opcion;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Elige la dificultad:\n"
                + "1.Facil\n"
                + "2.Medio\n"
                + "3.Dificil");
        opcion=teclado.nextInt();
        
        return opcion;
    }
}
