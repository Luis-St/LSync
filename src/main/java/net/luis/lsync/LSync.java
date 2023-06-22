package net.luis.lsync;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.*;
import net.luis.fxutils.PropertyListeners;
import net.luis.lsync.ui.TrayItem;
import net.luis.lsync.ui.UiUtils;
import net.luis.lsync.utils.TimeStorage;
import net.luis.lsync.utils.Utils;
import net.luis.utils.util.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 *
 * @author Luis
 *
 */

public class LSync extends Application {
	
	private static final Logger LOGGER = LogManager.getLogger(LSync.class);
	
	/*		// Awesome Font test
		Button btn = new Button();
		Font font = Font.loadFont(Main.class.getResourceAsStream("/font/font_awesome_regular.otf"), 12);
		font = Font.loadFont(Main.class.getResourceAsStream("/font/font_awesome_solid.otf"), 12);
		System.out.println(font.getFamily());
		btn.setFont(font);
		
		
		
		
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
		primaryStage.show();*/
	
	private final TrayItem tray = new TrayItem("LSync", new ImageIcon(Utils.getResource("/icon.png")).getImage());
	private final TimeStorage<Boolean> focusStorage = new TimeStorage<>(25);
	
	@Override
	public void init() {
		Thread.currentThread().setName("Ui Thread");
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Thread.currentThread().setName("Ui Thread");
		this.disablePrimaryStage(primaryStage);
		Stage stage = this.setupMainStage(primaryStage);
		this.tray.addMouseListener((e) -> {
			Platform.runLater(() -> {
				if (stage.isShowing()) {
					stage.hide();
				} else if (this.focusStorage.get(true)) {
					stage.show();
					stage.requestFocus();
					this.positionStage(stage);
				}
			});
		});
		UiUtils.addTray(this.tray);
		Scene scene = new Scene(new StackPane(), 400, 550);
		stage.setScene(scene);
		stage.show();
		this.positionStage(stage);
	}
	
	private void disablePrimaryStage(@NotNull Stage stage) {
		stage.initStyle(StageStyle.UTILITY);
		stage.setOpacity(0);
		stage.setHeight(0);
		stage.setWidth(0);
		stage.show();
	}
	
	private @NotNull Stage setupMainStage(Stage primaryStage) {
		Stage stage = new Stage();
		stage.initOwner(primaryStage);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.focusedProperty().addListener(PropertyListeners.createWithNew(value -> !value, () -> {
			stage.hide();
			this.focusStorage.set(false);
		}));
		return stage;
	}
	
	private void positionStage(@NotNull Stage stage) {
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		double stageWidth = stage.getWidth();
		double stageHeight = stage.getHeight();
		double x = screenBounds.getMaxX() - stageWidth;
		double y = screenBounds.getMaxY() - stageHeight;
		stage.setX(x - 10);
		stage.setY(y - 10);
	}
}
