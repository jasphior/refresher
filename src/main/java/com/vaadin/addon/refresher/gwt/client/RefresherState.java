package com.vaadin.addon.refresher.gwt.client;

import com.vaadin.terminal.gwt.client.ComponentState;

public class RefresherState extends ComponentState {
	private int milliseconds;

	public RefresherState() {
	}

	public RefresherState(int milliseconds) {
		this.milliseconds = milliseconds;
	}

	public int getMilliseconds() {
		return milliseconds;
	}

	public void setMilliseconds(int milliseconds) {
		this.milliseconds = milliseconds;
	}

}
