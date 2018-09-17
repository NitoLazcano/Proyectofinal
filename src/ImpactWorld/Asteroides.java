package ImpactWorld;
import java.util.Random;


import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;


public class Asteroides 
{
	//private Random r;
    private Asteroide Asteroides[];
    
  
    public Asteroides(int n, Image img1) 
    {
    	Asteroides = new Asteroide[n];
    	
    	Random r = new Random();
    	for (int i=0; i<Asteroides.length; i++)
		{
    		 int TAMANO = r.nextInt((int) 40) +40;
			 int POSX = r.nextInt(720-TAMANO) ;
			 int POSY = -80;
		
			 int VELOCIDAD = r.nextInt(4) +2;

			 
			
				Asteroides[i]= new Asteroide(POSX, POSY, TAMANO, TAMANO, VELOCIDAD);
				Asteroides[i].setFill(new ImagePattern(img1));
		
			
		}
    }
  
	public void addPanel(Pane paneCancha) {
		for (int i=0; i<Asteroides.length; i++)
		{
			paneCancha.getChildren().add(Asteroides[i]);
		}		
	}

	public void mover(double alto) 
	{
		for (int i=0; i<Asteroides.length; i++)
		{
			Asteroides[i].mover(alto);
		}		
	}
	public boolean verificarchoque(Nave Nave)
	{
		boolean choque = false;
		
		for (int i=0; i<Asteroides.length; i++ )
		{
			
			if ((Nave.intersects(Asteroides[i].getBoundsInLocal())))
			{
			choque = true;
			Asteroides[i].volverarriba();
			--Nave.vidas;
			}
		}
		
		return choque;
		
	}
	public boolean evitaraccidente()
	{
		boolean accidente = false;
		for (int j=0; j<Asteroides.length; j++)
		{
		for (int i=0; i<Asteroides.length; i++ )
		{
			if (i==j) 
			{
			}
			else {
			if ((Asteroides[j].intersects(Asteroides[i].getBoundsInLocal())))
			{
			accidente = true;
			Asteroides[i].volverarriba();
			}
			}
		}
	}
		
		return accidente;
	
	}
	public void remover(Pane paneCancha) 
	{
		for (int i=0; i<Asteroides.length; i++)
		{
			paneCancha.getChildren().remove(Asteroides[i]);
		}	
	}
	
}
