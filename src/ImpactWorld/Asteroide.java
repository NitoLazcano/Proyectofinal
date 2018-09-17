package ImpactWorld;

import java.util.Random;

import javafx.scene.shape.Rectangle;

public class Asteroide extends Rectangle

{
	public double Velocidad;
	public int vidas;

	public Asteroide(int x, int y, int Ancho, int Alto, double Velocidad)
	{
		this.Velocidad = Velocidad;
		this.setX(x);
		this.setY(y);
		this.setWidth(Ancho);
		this.setHeight(Alto);
	}
public void mover(double height) 
{
	double y = this.getY();
	double alto = height;
	if(y <= alto)
	{
	y+=Velocidad;
	}
	else 
	{
		y = -580;
		Random r = new Random();
		int x = r.nextInt((int) (720-this.getWidth())) ;
	
	this.setY(x);
	}
	
	this.setY(y);
	
	
}

public void volverarriba() 
{
	double y = this.getY();	
		y =-100;
		Random r = new Random();
		int x = r.nextInt((int) (720-this.getWidth())) ;
	this.setY(y);
	this.setY(x);
	
}


}