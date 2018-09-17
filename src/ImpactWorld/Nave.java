package ImpactWorld;



import javafx.scene.shape.Rectangle;

public class Nave extends Rectangle

{
	public double Velocidad;
	public int vidas;

	public Nave(int x, int y, int Ancho, int Alto, double Velocidad, int vidas)
	{
		this.Velocidad = Velocidad;
		this.setX(x);
		this.setY(y);
		this.setWidth(Ancho);
		this.setHeight(Alto);
		this.vidas = vidas;
	}



}