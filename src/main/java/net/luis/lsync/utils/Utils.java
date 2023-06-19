package net.luis.lsync.utils;

import java.net.URL;

/**
 *
 * @author Luis-St
 *
 */

public class Utils {
	
	public static URL getResource(String path) {
		return Utils.class.getResource(path);
	}
}
