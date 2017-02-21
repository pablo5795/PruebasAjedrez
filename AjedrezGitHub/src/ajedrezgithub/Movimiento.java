package ajedrezgithub;

public class Movimiento {
	protected Posicion posInic;
	protected Posicion posFin;
	
	public Movimiento(Posicion posInic, Posicion posFin){
		this.posInic = posInic;
		this.posFin = posFin;
	}
	
	public boolean esVertical(Movimiento movimiento){
		boolean vert=false;
		if(movimiento.posInic.columna==movimiento.posFin.columna){
			vert=true;
		}
		return vert;
	}
	
	public boolean esHorizontal(Movimiento movimiento){
		boolean hori=false;
		if(movimiento.posInic.fila==movimiento.posFin.fila){
			hori=true;
		}
		return hori;
	}
	
	public boolean esDiagonal(Movimiento movimiento){
		boolean diag = false;
		if (movimiento.saltoHorizontal(movimiento)==movimiento.saltoVertical(movimiento)){
			diag = true;
		}
		return diag;
	}
	
	public int saltoHorizontal(Movimiento movimiento){
		int salto=movimiento.posFin.columna-movimiento.posInic.columna;
		int saltoFin = Math.abs(salto);
		return saltoFin;
	}
	
	public int saltoVertical(Movimiento movimiento){
		int salto=movimiento.posFin.fila-movimiento.posInic.fila;
		int saltoFin = Math.abs(salto);
		return saltoFin;
	}

}
