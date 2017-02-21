package ajedrezgithub;

import java.util.Scanner;

public class AjedrezGitHub {

    public static void main(String[] args) {
        String posicion,enroque="";
		int fila, columna,i,j=0;
		Scanner teclado = new Scanner (System.in);
		Tablero tablero = new Tablero();
		Juego miJuego = new Juego();
		boolean fin=false;
		do{
			tablero.mostrarTablero();
			if(miJuego.getTurno()==true){
				System.out.println("Turno Blancas");
			}else{
				System.out.println("Turno Negras");
			}
			System.out.print("Introduce movimiento(C5E6) o 'enroque' si quieres enrocar: ");
			posicion = teclado.next();
			Movimiento miMov = miJuego.movimiento(posicion, tablero.casilla);
			if(miMov!=null){
				if(tablero.casilla[miMov.posInic.fila][miMov.posInic.columna].validoMovimiento(miMov,tablero)==true){
					if(tablero.hayPiezasEntre(miMov, tablero)==false){
						tablero.mover(miMov,miJuego);
						miJuego.setTurno();
						fin=true;
					}else{
						System.out.println("Hay piezas en el camino");
						fin=true;
					}
					
					
				}else{
					System.out.println("Movimiento inv�lido");
					fin=true;
				}
			}
			else{
				fin=true;
			}
			System.out.println();
		}while(fin==true);
    }
    
}
