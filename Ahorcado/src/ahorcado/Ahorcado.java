package ahorcado;

import java.io.IOException;
import java.util.Scanner;

public class Ahorcado {
    
    public static void main(String[] args) throws IOException {
        
        Juego miJuego = new Juego();
        Jugador miJugador = miJuego.nuevoJugador();
        Tablero miTablero = new Tablero(miJuego.elegirDificultad());
        
        Scanner teclado = new Scanner(System.in);
        char letra,opc;
        String palabra;
        
        miTablero.pintarTablero();
        do{
            do{
            System.out.println("¿Te sabes la palabra?(s/n)");
            opc=(char) System.in.read();
            System.in.read();
            }while(opc!='s' && opc!='S' && opc!='n' && opc!='N');
            if(opc=='s' || opc=='S'){
                System.out.print("Escribe la palabra: ");
                palabra=teclado.nextLine();
                miTablero.comprobarPalabra(palabra);
            }else{
            miJugador.getFallos();
            do{
            System.out.print("Introduzca letra: ");
            letra = (char) System.in.read();
            System.in.read();
            }while((letra>01 && letra<=64) || (letra>=91 && letra<=96) || (letra>=123 && letra<=255));
            if(miTablero.buscarLetra(letra)){
                miTablero.mostrarLetra(letra);
            }else{
                System.out.println("Esa letra no se encuentra en la palabra");
                miJugador.setVidas();
                miJugador.setFallos(letra);
            }
            System.out.println("Te quedan "+miJugador.getVidas()+" vidas, "+miJugador.getNombre());
            }
        }while(miJugador.getVidas()>0 && !miTablero.verFinal());
        if(miJugador.getVidas()==0){
            System.out.println("HAS PERDIDO...");
        }else{
            System.out.println("HAS GANADO!!!");
        }
    }
    
}
