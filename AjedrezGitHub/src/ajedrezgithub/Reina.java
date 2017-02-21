package ajedrezgithub;


public class Reina extends Pieza{
	
	public Reina(boolean color){
		super(color);
		valor=(float)10;
	}
	public float getValor(){
		return valor;
	}

	@Override
	public void pintarPieza() {
		if(super.color==true){
			System.out.print("Qb");
		}else if(super.color==false){
			System.out.print("Qn");
		}
	}

	@Override
	public boolean validoMovimiento(Movimiento movimiento, Tablero tablero) {
		boolean esValido=false;
		if(movimiento.esHorizontal(movimiento)==true || movimiento.esVertical(movimiento)==true || movimiento.esDiagonal(movimiento)==true){
			esValido=true;
		}
		return esValido;
	}

}
