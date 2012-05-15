package com.vaadin.addon.refresher.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.addon.refresher.TimeUpdater;
import com.vaadin.terminal.gwt.client.communication.StateChangeEvent;
import com.vaadin.terminal.gwt.client.ui.Connect;
import com.vaadin.terminal.gwt.client.ui.customcomponent.CustomComponentConnector;

@Connect(TimeUpdater.class)
public class TimeUpdaterConnector extends CustomComponentConnector {

	@Override
	public TimeUpdaterState getState() {
		return (TimeUpdaterState) super.getState();
	}

	@Override
	protected Widget createWidget() {
		return GWT.create(VTimeUpdater.class);
	}

	@Override
	public VTimeUpdater getWidget() {
		return (VTimeUpdater) super.getWidget();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);
		getWidget().setInitialTime(getState().getInitialTime());
		getWidget().setShortTime(getState().isShortTime());
		getWidget().startTimer(getState().getUpdateFrequency());
	}
}
