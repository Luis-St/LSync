package net.luis.lsync;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.*;

/**
 *
 * @author Luis
 *
 */

public class LSync extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.initStyle(StageStyle.DECORATED);
		
		Scene scene = new Scene(new StackPane(), 400, 550);
		stage.setScene(scene);
		stage.show();
		
		
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		
		double stageWidth = stage.getWidth();
		double stageHeight = stage.getHeight();
		double x = screenBounds.getMaxX() - stageWidth;
		double y = screenBounds.getMaxY() - stageHeight;
		
		stage.setX(x);
		stage.setY(y);

		
	}
}
