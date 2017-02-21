package ajedrezgithub;

import java.util.Scanner;

public class Juego {
	protected boolean turno=true;
	
	public boolean getTurno(){
		return turno;
	}
	
	public void setTurno(){ //true -> Blancas | false -> Negras
		if(turno==true){
			this.turno=false;
		}else{
			this.turno=true;
		}
	}
	
	
	public Movimiento movimiento(String jugada, Pieza casilla[][]){
		/*1.No salirse del tablero
		  2.4 Digitos
		  3.Haya pieza en posicion inicial
		  4.Color=turno
		  5.Posicion final vacia o con pieza de otro color
		 */
		Scanner letra = new Scanner(System.in);
		String enroque;
		Movimiento movimiento = null;
		if(jugada.length()==4){
			if(((jugada.toUpperCase().charAt(0))>='A' && (jugada.toUpperCase().charAt(0))<='H') && ((jugada.toUpperCase().charAt(1))>='1' && (jugada.toUpperCase().charAt(1)<='8')) && (jugada.toUpperCase().charAt(2)>='A') && (jugada.toUpperCase().charAt(2)<='H') && (jugada.toUpperCase().charAt(3)>='1') && (jugada.toUpperCase().charAt(3)<='8')){
				int fila1 = jugada.charAt(1)-49;
				int columna1 = jugada.toUpperCase().charAt(0)-65;
				int fila2 = jugada.charAt(3)-49;
				int columna2 = jugada.toUpperCase().charAt(2)-65;
				if (casilla[fila1][columna1]!=null){
					if(casilla[fila1][columna1].color==turno){
						if(casilla[fila2][columna2]==null || casilla[fila2][columna2].color!=turno){
							Posicion pos = new Posicion(fila1,columna1);
							Posicion posfin = new Posicion(fila2,columna2);
							movimiento = new Movimiento(pos,posfin);
						}else{
							System.out.println("No se puede realizar el movimiento");
						}
					}else{
						System.out.println("Esa pieza no te corresponde");
					}
				}else{
					System.out.println("No hay pieza en esa posicion");
				}
			}else{
				System.out.println("Movimiento no valido");
			}
		}else{
			if(jugada.equalsIgnoreCase("enroque")){
				System.out.println("�Largo o corto?");
				enroque = letra.next();
				if(enroque.equalsIgnoreCase("largo")){
					if(turno){
						if(casilla[7][0].nombre.equalsIgnoreCase("torre") && casilla[7][4].nombre.equalsIgnoreCase("rey") && casilla[7][1]==null && casilla[7][2]==null && casilla[7][3]==null){
							casilla[7][2]=casilla[7][4];
							casilla[7][4]=null;
							casilla[7][3]=casilla[7][0];
							casilla[7][0]=null;
							turno=false;
						}
						else{
							System.out.println("Imposible realizar el enroque");
						}
					}else{
						if(casilla[0][0].nombre.equalsIgnoreCase("torre") && casilla[0][4].nombre.equalsIgnoreCase("rey") && casilla[0][1]==null && casilla[0][2]==null && casilla[0][3]==null){
							casilla[0][2]=casilla[0][4];
							casilla[0][4]=null;
							casilla[0][3]=casilla[0][0];
							casilla[0][0]=null;
							turno=true;
						}else{
							System.out.println("Imposible realizar el enroque");
						}
					}
				}else if(enroque.equalsIgnoreCase("corto")){
					if(turno){
						if(casilla[7][7].nombre.equalsIgnoreCase("torre") && casilla[7][4].nombre.equalsIgnoreCase("rey") && casilla[7][5]==null && casilla[7][6]==null){
							casilla[7][6]=casilla[7][4];
							casilla[7][4]=null;
							casilla[7][5]=casilla[7][7];
							casilla[7][7]=null;
							turno=false;
						}
						else{
							System.out.println("Imposible realizar el enroque");
						}
					}else{
						if(casilla[0][7].nombre.equalsIgnoreCase("torre") && casilla[0][4].nombre.equalsIgnoreCase("rey") && casilla[0][5]==null && casilla[0][6]==null){
							casilla[0][6]=casilla[0][4];
							casilla[0][4]=null;
							casilla[0][5]=casilla[0][7];
							casilla[0][7]=null;
							turno=true;
						}else{
							System.out.println("Imposible realizar el enroque");
						}
					}
				}
			}else{
				System.out.println("Movimiento incorrecto");
			}
		}
		return movimiento;
	}

}
