package ImpactWorld;

import java.io.File; 

import java.net.MalformedURLException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;



public class ImpactWorldController {

	@FXML
	private Pane paneCancha;
	//private Pane paneMenu;
	private Nave Nave;
	private Llave Llave;
	private Estrella Estrella;
	private Asteroides Asteroides;
	private AsteroideAnimationTimer mitimer;
	 @FXML
	    Label labelPuntuacion;
	    @FXML
	    Label labelConsejo;
	    @FXML
	    Label labelVidas;
	@FXML
	public void initialize() throws MalformedURLException
	{
		System.out.println("FxPelotaController initializer");

		/*
		 * Limitar el espacio de la Cancha, para que la
		 * figura no se dibuje fuera
		 */
		Rectangle clip = new Rectangle(0, 0, 0, 0);
		clip.widthProperty().bind(paneCancha.widthProperty());
		clip.heightProperty().bind(paneCancha.heightProperty());
		paneCancha.setClip(clip);
		
		File file = new File("img/Nave2.png");
		String localUrl = file.toURI().toURL().toString();
		Image img = new Image(localUrl);
		
		File file2 = new File("img/Asteroid.png");
		String localUrl2 = file2.toURI().toURL().toString();
		Image img2 = new Image(localUrl2);
		
		File file4 = new File("img/Llave.png");
		String localUrl4 = file4.toURI().toURL().toString();
		Image img5 = new Image(localUrl4);
		File file5 = new File("img/Estrella.png");
		String localUrl5 = file5.toURI().toURL().toString();
		Image img6 = new Image(localUrl5);
		
		
		Llave = new Llave(300, 30, 70, 40);
		Llave.setFill(new ImagePattern(img5));
		Estrella = new Estrella(30, 30, 50, 50);
		Estrella.setFill(new ImagePattern(img6));
		Asteroides = new Asteroides(7, img2);
		
	
		Nave = new Nave(250, 450, 50, 75, 20, 3);
		Nave.setFill(new ImagePattern(img));
	
	 mitimer = new AsteroideAnimationTimer(Nave, Asteroides, paneCancha, labelPuntuacion, labelConsejo, labelVidas, Llave, Estrella);
	}

	@FXML
	public void botonSalir()
	{
		System.out.println("Boton Salir Presionado.");
		System.exit(0);
		
	}
	@FXML
	public void botonIniciar()
	{
		mitimer.start();
		paneCancha.getChildren().add(Llave);
		paneCancha.getChildren().add(Estrella);
		paneCancha.getChildren().add(Nave);
		Asteroides.addPanel(paneCancha);
	}

	@FXML
	public void keyMoveHnd(KeyEvent ke)
	{
		double sentido= Nave.Velocidad;
		double x = Nave.getX();
		double y = Nave.getY();
         
		switch(ke.getCode())
		{
		case UP:
		case KP_UP:
		case I:
			if(y<=0)
			{
				y=0;
			}else
			{
			y-=sentido;	
			}
			break;
		case DOWN:
		case KP_DOWN:
		case K:
			if(y+ Nave.getHeight()>=paneCancha.getHeight())
			{
				y = paneCancha.getHeight()-Nave.getHeight();
			}
			else
			{
			y+=sentido;
			}
			break;
		case LEFT:
		case KP_LEFT:
		case J:
			if(x<=0)
			{
				x=0;
			}
			else {
			x-=sentido;	
			}
			break;
		case RIGHT:
		case KP_RIGHT:
		case L:
			if(x+Nave.getWidth()>=720)
			{
				x=720-Nave.getWidth();
			}
			else
			{
				x+=sentido;
			}
			
			break;
		default:
			System.out.println("KeyMoveHnd:" + ke.getCode() );
			break;
		
         }
		ke.consume();
		
		Nave.setX(x);
		Nave.setY(y);
          
	}
}