package com.vaadin.addon.refresher.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.addon.refresher.SinceAutoUpdater;
import com.vaadin.terminal.gwt.client.communication.StateChangeEvent;
import com.vaadin.terminal.gwt.client.ui.Connect;
import com.vaadin.terminal.gwt.client.ui.customcomponent.CustomComponentConnector;

@Connect(SinceAutoUpdater.class)
public class SinceAutoUpdaterConnector extends CustomComponentConnector {

	@Override
	public TimeUpdaterState getState() {
		return (TimeUpdaterState) super.getState();
	}

	@Override
	protected Widget createWidget() {
		return GWT.create(VSinceAutoUpdater.class);
	}

	@Override
	public VSinceAutoUpdater getWidget() {
		return (VSinceAutoUpdater) super.getWidget();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);
		getWidget().setInitialTime(getState().getInitialTime());
		getWidget().setShortTime(getState().isShortTime());
		getWidget().startTimer(getState().getUpdateFrequency());
	}
}
