package com.vaadin.addon.refresher;

import com.vaadin.addon.refresher.gwt.client.SinceAutoUpdaterState;
import com.vaadin.ui.Label;

public class SinceAutoUpdater extends Label {
	private long initalTime;
	private int updateFrequency;
	private boolean shortTime;

	public void config(long initalTime, int updateFrequency, boolean shortTime) {
		this.initalTime = initalTime;
		this.updateFrequency = updateFrequency;
		this.shortTime = shortTime;
		requestRepaint();
	}

	@Override
	public void requestRepaint() {
		super.requestRepaint();
		SinceAutoUpdaterState state = getState();
		state.setInitialTime(initalTime);
		state.setUpdateFrequency(updateFrequency);
		state.setShortTime(shortTime);
	}

	@Override
	public SinceAutoUpdaterState getState() {
		return (SinceAutoUpdaterState) super.getState();
	}
}
