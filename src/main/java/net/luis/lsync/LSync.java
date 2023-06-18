package net.luis.lsync;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.*;

/**
 *
 * @author Luis
 *
 */

public class LSync extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
/*		primaryStage.initStyle(StageStyle.UTILITY);
		primaryStage.setOpacity(0);
		primaryStage.setHeight(0);
		primaryStage.setWidth(0);
		primaryStage.show();
		Stage mainStage = new Stage();
		mainStage.initOwner(primaryStage);
		mainStage.initStyle(StageStyle.UNDECORATED);*/
		Button btn = new Button();
		Font font = Font.loadFont(Main.class.getResourceAsStream("/font/font_awesome_regular.otf"), 12);
		font = Font.loadFont(Main.class.getResourceAsStream("/font/font_awesome_solid.otf"), 12);
/*		System.out.println(font.getFamily());
		btn.setFont(font);*/
		
		
		
		
		btn.setStyle("-fx-font-family: \"Font Awesome 6 Free Solid\"; -fx-font-size: 100px;");
		btn.setText("\uf2f1");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");
			}
		});
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
/*		stage.initStyle(StageStyle.UTILITY);
		stage.initStyle(StageStyle.UNDECORATED);
		Scene scene = new Scene(new StackPane(), 400, 550);

		
		stage.setScene(scene);
		
		stage.show();
		stage.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue) {
				SystemTray tray = SystemTray.getSystemTray();
				TrayIcon trayIcon = new TrayIcon(new ImageIcon(getClass().getResource("/icon.png")).getImage(), "LSync");
				trayIcon.setImageAutoSize(true);
				trayIcon.addActionListener(e -> Platform.runLater(() -> {
					stage.setIconified(false);
					stage.requestFocus();
					tray.remove(trayIcon);
				}));
				try {
					tray.add(trayIcon);
				} catch (AWTException e) {
					throw new RuntimeException(e);
				}
				stage.setIconified(true);
			}
		});
		
		
		
		this.positionStage(stage);*/


		
	}
	
	private void positionStage(Stage stage) {
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		double stageWidth = stage.getWidth();
		double stageHeight = stage.getHeight();
		double x = screenBounds.getMaxX() - stageWidth;
		double y = screenBounds.getMaxY() - stageHeight;
		stage.setX(x - 10);
		stage.setY(y - 10);
	}
}
