package ajedrezgithub;


public abstract class Pieza {
	protected boolean color;
	protected String nombre;
	protected float valor;
	
	public Pieza(boolean color){
		this.color = color;
		nombre = this.getClass().getName().split("\\.")[this.getClass().getName().split("\\.").length-1];
	}
	
	public boolean getColor(){
		return color;
	}
	
	public abstract void pintarPieza();
	
	public void moverPieza(){
		
	}
	public abstract float getValor();
	public abstract boolean validoMovimiento(Movimiento movimiento, Tablero tablero);

}
