package net.luis.lsync.utils;

import java.util.function.Supplier;

/**
 *
 * @author Luis-St
 *
 */

public class TimeStorage<T> {
	
	private final long resetTimeSpan;
	private T value;
	private long time;
	
	public TimeStorage(long resetTimeSpan) {
		this.resetTimeSpan = resetTimeSpan;
	}
	
	public void set(T value) {
		this.value = value;
		this.time = System.currentTimeMillis();
	}
	
	public T get(T defaultValue) {
		if (System.currentTimeMillis() - this.time > this.resetTimeSpan) {
			this.value = null;
		}
		if (this.value == null) {
			return defaultValue;
		}
		return this.value;
	}
}
