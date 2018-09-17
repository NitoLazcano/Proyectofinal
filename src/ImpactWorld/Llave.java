package ImpactWorld;

import java.util.Random;


import javafx.scene.shape.Rectangle;

public class Llave extends Rectangle
{
public Llave(int x, int y, int Ancho, int Alto)
{
	this.setX(x);
	this.setY(y);
	this.setWidth(Ancho);
	this.setHeight(Alto);
}
public boolean atrapado(Nave Nave)
{
	return (Nave.intersects(this.getBoundsInLocal()));	
}
public void cambiar_posicion(double ancho, double alto)
{
	double x = this.getX();
	double y = this.getY();
	Random r = new Random();
	x = r.nextInt((int) (ancho-this.getWidth()))+33;
	y = r.nextInt((int) (alto-this.getHeight()));
	this.setX(x);
	this.setY(y);
}
}
