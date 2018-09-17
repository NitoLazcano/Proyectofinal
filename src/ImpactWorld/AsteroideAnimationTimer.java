package ImpactWorld;

import java.time.LocalTime;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class AsteroideAnimationTimer extends AnimationTimer
{
	private Asteroides Asteroides;
	private Pane paneCancha;
	private Label labelPuntuacion;
	private Label labelConsejo;
	private Label labelVidas;
	private Nave Nave;
	private Llave Llave;
	private Estrella Estrella;
	private double valor;
	private int n;
	public AsteroideAnimationTimer (Nave Nave, Asteroides Asteroides, Pane paneCancha,Label labelPuntuacion, Label labelConsejo, Label labelVidas,Llave Llave,Estrella Estrella)
	{
		super();
		this.Asteroides = Asteroides;
		this.Nave = Nave;
		this.paneCancha = paneCancha;
		this.labelPuntuacion = labelPuntuacion;
		this.labelConsejo = labelConsejo;
		this.labelVidas = labelVidas;
		this.Llave = Llave;
		this.Estrella = Estrella;
		
		valor = LocalTime.now().getSecond();
		n=0;
	}
	@Override
	public void handle(long arg0) {
		if(Nave.vidas>0)
		{
		if (LocalTime.now().getSecond() != valor)
		{
			valor = LocalTime.now().getSecond();
			n+=1000;
		}
		Asteroides.mover(paneCancha.getHeight());
		if(Asteroides.verificarchoque(Nave))
		{
	
		}
		if(Asteroides.evitaraccidente())
		{
		
		}
		if(Llave.atrapado(Nave))
		{
			Llave.cambiar_posicion(400,paneCancha.getHeight());
			++Nave.vidas;
			
		}
		if(Estrella.recogido(Nave))
		{
			Estrella.reaparecer(400,paneCancha.getHeight());
			n+=5000;
		
		}
		labelPuntuacion.setText("" + n + "");
		labelVidas.setText("" + Nave.vidas + "") ;
		}
		else 
		{
			if (n<40000)
			{
				labelConsejo.setText("Tu puntuacion es: " + n + "\n¡DAS PENA!\nNo sigas intentando conseguir los corazones");
			
			}
			else if (n<100000)
			{
				labelConsejo.setText("Tu puntuacion es: " + n + "\nBien, pero lo puedes hacer mejor");
			
			}
			else if (n<200000)
			{
				labelConsejo.setText("Tu puntuacion es: " + n + "\nLo hiciste muy bien\nPero deja de recoger diamantes");
		
			}
			else 
			{
				labelConsejo.setText("Tu puntuacion es: " + n + "\n¡Felicidades! Pinche adicto recoge diamantes!!! ");
			   
			}
			
			paneCancha.getChildren().remove(Nave);
			paneCancha.getChildren().remove(Llave);
			paneCancha.getChildren().remove(Estrella);
			Asteroides.remover(paneCancha);
			this.stop();
		
		}
	}
     
}