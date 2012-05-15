package com.vaadin.addon.refresher;

import com.vaadin.addon.refresher.gwt.client.TimeUpdaterState;
import com.vaadin.ui.CustomComponent;

public class SinceAutoUpdater extends CustomComponent {
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
		TimeUpdaterState state = getState();
		state.setInitialTime(initalTime);
		state.setUpdateFrequency(updateFrequency);
		state.setShortTime(shortTime);
	}

	@Override
	public TimeUpdaterState getState() {
		return (TimeUpdaterState) super.getState();
	}
}
