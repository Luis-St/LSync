package net.luis.lsync.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

/**
 *
 * @author Luis-St
 *
 */

public class UiUtils {
	
	private static final Logger LOGGER = LogManager.getLogger(UiUtils.class);
	
	public static boolean addTray(TrayItem tray) {
		try {
			SystemTray.getSystemTray().add(tray);
			return true;
		} catch (AWTException e) {
			LOGGER.warn("Could not add tray {} to system tray", tray.getName());
			return false;
		}
	}
	
	public static void removeTray(TrayItem tray) {
		SystemTray.getSystemTray().remove(tray);
	}
}
