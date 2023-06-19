package net.luis.lsync.ui;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

/**
 *
 * @author Luis-St
 *
 */

public class TrayItem extends TrayIcon {
	
	private final String name;
	
	public TrayItem(String name, Image image) {
		this(name, image, name);
	}
	
	public TrayItem(String name, Image image, String tooltip) {
		super(image, tooltip);
		this.name = name;
		this.setImageAutoSize(true);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addMouseListener(Consumer<MouseEvent> listener) {
		this.addMouseListener(new MouseInputAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listener.accept(e);
			}
		});
	}
}
