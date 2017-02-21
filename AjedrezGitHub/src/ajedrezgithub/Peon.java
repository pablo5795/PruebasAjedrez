package ajedrezgithub;


public class Peon extends Pieza{
	
	public Peon(boolean color){
		super(color);
		valor=(float)1;
	}
	public float getValor(){
		return valor;
	}

	@Override
	public void pintarPieza() {
		if(super.color==true){
			System.out.print("Pb");
		}else if(super.color==false){
			System.out.print("Pn");
		}
	}

	@Override
	public boolean validoMovimiento(Movimiento movimiento, Tablero tablero) {
		boolean esValido=false;
		if(color==true){
			if(movimiento.posFin.fila<movimiento.posInic.fila)//para no poder mover hacia atras los peones blancos
				if((movimiento.posInic.fila==6 && color==true)){
					if((movimiento.saltoHorizontal(movimiento)==0 && (movimiento.saltoVertical(movimiento)==1 || movimiento.saltoVertical(movimiento)==2)) || (movimiento.esDiagonal(movimiento) && movimiento.saltoHorizontal(movimiento)==1 && movimiento.saltoVertical(movimiento)==1 && tablero.casilla[movimiento.posFin.fila][movimiento.posFin.columna]!=null)){
						esValido=true;
					}
				}else if((movimiento.saltoHorizontal(movimiento)==0 && movimiento.saltoVertical(movimiento)==1) || (movimiento.esDiagonal(movimiento) && movimiento.saltoHorizontal(movimiento)==1 && movimiento.saltoVertical(movimiento)==1 && tablero.casilla[movimiento.posFin.fila][movimiento.posFin.columna]!=null)){
					esValido=true;
				}
		}else{
			if(movimiento.posFin.fila>movimiento.posInic.fila)//para no poder mover hacia atras los peones negros
				if((movimiento.posInic.fila==1 && color==false)){
					if((movimiento.saltoHorizontal(movimiento)==0 && (movimiento.saltoVertical(movimiento)==1 || movimiento.saltoVertical(movimiento)==2)) || (movimiento.esDiagonal(movimiento) && movimiento.saltoHorizontal(movimiento)==1 && movimiento.saltoVertical(movimiento)==1 && tablero.casilla[movimiento.posFin.fila][movimiento.posFin.columna]!=null)){
						esValido=true;
					}
				}else if((movimiento.saltoHorizontal(movimiento)==0 && movimiento.saltoVertical(movimiento)==1) || (movimiento.esDiagonal(movimiento) && movimiento.saltoHorizontal(movimiento)==1 && movimiento.saltoVertical(movimiento)==1 && tablero.casilla[movimiento.posFin.fila][movimiento.posFin.columna]!=null)){
					esValido=true;
				}
		}
		return esValido;
	}

}
