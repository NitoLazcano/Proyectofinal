package fxKeyMove;

import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class FxKeyMoveController {

	@FXML
	private Pane paneCancha;

	private Pelota pelota;

	@FXML
	public void initialize()
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

		pelota = new Pelota();
		paneCancha.getChildren().add(pelota);

	}

	@FXML
	public void botonSalir()
	{
		System.out.println("Boton Salir Presionado.");
		System.exit(0);
	}

	@FXML
	public void keyMoveHnd(KeyEvent ke)
	{
		double x = pelota.getCenterX();
		double y = pelota.getCenterY();

		switch(ke.getCode())
		{
		case UP:
		case KP_UP:
		case I:
			y-=3;
			break;
		case DOWN:
		case KP_DOWN:
		case K:
			y+=3;
			break;
		case LEFT:
		case KP_LEFT:
		case J:
			x-=3;
			break;
		case RIGHT:
		case KP_RIGHT:
		case L:
			x+=3;
			break;
		default:
			System.out.println("KeyMoveHnd:" + ke.getCode() );
			break;
		}
		
		ke.consume();
		
		pelota.setCenterX(x);
		pelota.setCenterY(y);
	}
}
