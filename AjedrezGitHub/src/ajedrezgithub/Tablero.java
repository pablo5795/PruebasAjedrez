package ajedrezgithub;


public class Tablero {
	protected Pieza casilla[][];
	protected float puntosJ1;
	protected float puntosJ2;
	
	public Tablero(){//Rellenar el tablero
		boolean color=false;
		puntosJ1=0;
		puntosJ2=0;
		casilla = new Pieza[8][8];
		for (int i=0;i<casilla.length; i++){
			for (int j = 0; j < casilla[i].length; j++) {
				if(i<2){
					color=false;
				}else if(i>5){
					color=true;
				}
				
				if(i==0 || i==7){
					if(j==0 || j==7){
						casilla[i][j]=new Torre(color);
					}else if(j==1 || j==6){
						casilla[i][j]=new Caballo(color);
					}else if(j==2 || j==5){
						casilla[i][j]=new Alfil(color);
					}else if(j==3){
						casilla[i][j]=new Reina(color);
					}else if(j==4){
						casilla[i][j]=new Rey(color);
					}
				}else if(i==1 || i==6){
					casilla[i][j]=new Peon(color);
				}else{
					casilla[i][j]=null;
				}
					
			}
		}
	}
	
	public void mostrarTablero(){//Mostrar el tablero con las casillas
		System.out.println("   ---------------------------------------");
		for (int i = 0; i < casilla.length; i++) {
			System.out.print(i+1+" ");
			for (int j = 0; j < casilla[i].length; j++) {
				if(casilla[i][j]==null){
					System.out.print("|    ");
				}else{
					System.out.print("| ");
					casilla[i][j].pintarPieza();
					System.out.print(" ");
				}
			}
			System.out.println("|\n   ---------------------------------------");
		}
		System.out.println("    A    B    C    D    E    F    G    H");
	}
	
	public boolean hayPieza(int fila, int columna){//Para comprobar si hay pieza en la posicion
		boolean aux=false;
		if(casilla[fila][columna]!=null){
			aux=true;
		}else{
			aux=false;
		}
		return aux;
	}
	
	public boolean hayPieza(Posicion pos){//Divide la posicion en filas y columnas y lo envia al m�todo anterior
		int fila = pos.getFila();
		int columna = pos.getColumna();
		return hayPieza(fila, columna);
	}
	
	public boolean hayPiezasEntre(Movimiento mov, Tablero tablero){//Comprobamos si en el movimiento hay piezas en el camino
		boolean aux=false;
		boolean hayPieza=false;
		if(tablero.devuelvePieza(mov.posInic).equals("Caballo")==false){//Miramos que el nombre de la pieza que vamos a mover sea diferente a "Caballo" porque el caballo salta las piezas
			if(mov.esHorizontal(mov)==true){//Vemos si el movimiento realizado es horizontal
				if((mov.posFin.columna>mov.posInic.columna)){//Como la posicion Final es mayor que la Inicial es un movimiento hacia la izquierda
					for(int i=mov.posInic.columna+1;i<mov.posFin.columna && aux==false;i++){//recorremos la fila para ver si hay piezas en medio
						if(tablero.casilla[mov.posInic.fila][i]!=null){
							aux=true;
						}
					}
				}else if((mov.posFin.columna<mov.posInic.columna)){//Como la posicion Inicial es mayor que la Final es un movimiento hacia la derecha
					for(int i=mov.posInic.columna-1;i>mov.posFin.columna && aux==false;i--){//recorremos la fila para ver si hay piezas en medio
						if(tablero.casilla[mov.posInic.fila][i]!=null){
							aux=true;
						}
					}
				}
			}
			if(mov.esVertical(mov)==true){//Vemos si el movimiento es vertical
				if((mov.posFin.fila>mov.posInic.fila)){//Como la posicion Final es mayor que la Inicial es un movimiento de arriba a abajo
					for(int i=mov.posInic.fila+1;i<mov.posFin.fila && aux==false;i++){//Miramos los distintos huecos de la columna
						if(tablero.casilla[i][mov.posInic.columna]!=null){
							aux=true;
						}
					}
				}
				if((mov.posFin.fila<mov.posInic.fila)){//Como la posicion Inicial es mayor que la Final es un movimiento de abajo a arriba
					for(int i=mov.posInic.fila-1;i>mov.posFin.fila && aux==false;i--){//Miramos los distintos huecos de la columna
						if(tablero.casilla[i][mov.posInic.columna]!=null){
							aux=true;
						}
					}
				}
			}
			if(mov.esDiagonal(mov)==true){
				if((mov.posFin.fila>mov.posInic.fila) && (mov.posFin.columna>mov.posInic.columna)){
					int cambioColumna=mov.posInic.columna+1;
					for(int i=mov.posInic.fila+1;i<mov.posFin.fila && aux==false;i++){
						if(tablero.casilla[i][cambioColumna]!=null){
							aux=true;
						}
						cambioColumna=cambioColumna+1;
					}
				}
				else if((mov.posFin.fila>mov.posInic.fila) && (mov.posFin.columna<mov.posInic.columna)){
					int cambioColumna=mov.posInic.columna-1;
					for(int i=mov.posInic.fila+1;i<mov.posFin.fila && aux==false;i++){
						if(tablero.casilla[i][cambioColumna]!=null){
							aux=true;
						}
						cambioColumna=cambioColumna-1;
					}
				}
				else if((mov.posFin.fila<mov.posInic.fila) && (mov.posFin.columna>mov.posInic.columna)){
					int cambioColumna=mov.posInic.columna+1;
					for(int i=mov.posInic.fila-1;i>mov.posFin.fila && aux==false;i--){
						if(tablero.casilla[i][cambioColumna]!=null){
							aux=true;
						}
						cambioColumna=cambioColumna+1;
					}
				}
				else if((mov.posFin.fila<mov.posInic.fila) && (mov.posFin.columna<mov.posInic.columna)){
					int cambioColumna=mov.posInic.columna-1;
					for(int i=mov.posInic.fila-1;i>mov.posFin.fila && aux==false;i--){
						if(tablero.casilla[i][cambioColumna]!=null){
							aux=true;
						}
						cambioColumna=cambioColumna-1;
					}
				}
			}
		}
		return aux;
	}

	public void ponPieza(Pieza figura, int fila, int columna){
		
	}
	
	public void ponPieza(Pieza figura, Posicion Pos){
		
	}
	
	public void quitaPieza(int fila, int columna){
		
	}
	
	public void quitaPieza(Posicion pos){
		
	}
	
	public String devuelvePieza(int fila,int columna){//Devolvemos el nombre de la pieza
		return casilla[fila][columna].nombre;
	}
	public String devuelvePieza(Posicion pos){//Devolvemos el nombre de la pieza
		return casilla[pos.fila][pos.columna].nombre;
	}
	
	public void mover(Movimiento movimiento,Juego juego){//Aqui realizamos el movimiento y calculamos los puntos
		if(casilla[movimiento.posFin.fila][movimiento.posFin.columna]!=null){//Comprobamos si en la casilla a la que queremos mover la pieza est� llena
			Pieza guardar=casilla[movimiento.posFin.fila][movimiento.posFin.columna];//Si es as� guardamos la pieza en antigua en una variable
			if(juego.turno==true){//Ahora sumamos los puntos de la pieza que hemos "comido" al jugador correspondiente
				puntosJ1=puntosJ1+guardar.valor;
				System.out.println("Puntos Jugador 1: "+puntosJ1);
				System.out.println("Puntos Jugador 2: "+puntosJ2);
			}else if(juego.turno==false){
				puntosJ2=puntosJ2+guardar.valor;
				System.out.println("Puntos Jugador 1: "+puntosJ1);
				System.out.println("Puntos Jugador 2: "+puntosJ2);
			}
		}
		casilla[movimiento.posFin.fila][movimiento.posFin.columna]=casilla[movimiento.posInic.fila][movimiento.posInic.columna];//Una vez guardada la pieza y calculados los puntos sobreescribimos la posicion
		casilla[movimiento.posInic.fila][movimiento.posInic.columna]=null;//Y liberamos la posicion de la que part�amos
	}

}
