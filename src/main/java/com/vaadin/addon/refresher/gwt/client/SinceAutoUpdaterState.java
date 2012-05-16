package com.vaadin.addon.refresher.gwt.client;

import com.vaadin.terminal.gwt.client.ui.label.LabelState;

public class SinceAutoUpdaterState extends LabelState {
	private long initialTime;
	private int updateFrequency;
	private boolean shortTime;

	public SinceAutoUpdaterState() {
	}

	public long getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(long initialTime) {
		this.initialTime = initialTime;
	}

	public int getUpdateFrequency() {
		return updateFrequency;
	}

	public void setUpdateFrequency(int updateFrequency) {
		this.updateFrequency = updateFrequency;
	}

	public boolean isShortTime() {
		return shortTime;
	}

	public void setShortTime(boolean shortTime) {
		this.shortTime = shortTime;
	}

}
