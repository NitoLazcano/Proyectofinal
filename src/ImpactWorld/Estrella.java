package ImpactWorld;

import java.util.Random;

import javafx.scene.shape.Rectangle;

public class Estrella extends Rectangle
{
public Estrella(int x, int y, int Ancho, int Alto)
{
	this.setX(x);
	this.setY(y);
	this.setWidth(Ancho);
	this.setHeight(Alto);
}
public boolean recogido(Nave Nave)
{
	return (Nave.intersects(this.getBoundsInLocal()));	
}
public void reaparecer(double ancho, double alto)
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
