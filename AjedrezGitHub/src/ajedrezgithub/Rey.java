package ajedrezgithub;


public class Rey extends Pieza{
	
	public Rey(boolean color){
		super(color);
	}

	@Override
	public void pintarPieza() {
		if(super.color==true){
			System.out.print("Kb");
		}else if(super.color==false){
			System.out.print("Kn");
		}
	}

	@Override
	public boolean validoMovimiento(Movimiento movimiento, Tablero tablero) {
		boolean esValido=false;
		if(movimiento.saltoHorizontal(movimiento)==1 || movimiento.saltoVertical(movimiento)==1 || (movimiento.esDiagonal(movimiento) && movimiento.saltoHorizontal(movimiento)==1 && movimiento.saltoVertical(movimiento)==1)){
			esValido=true;
		}
		return esValido;		
	}

	@Override
	public float getValor() {
		return 0;
	}



}
