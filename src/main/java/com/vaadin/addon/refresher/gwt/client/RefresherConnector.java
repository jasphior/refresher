package com.vaadin.addon.refresher.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.addon.refresher.Refresher;
import com.vaadin.addon.refresher.gwt.client.VRefresher.UpdateHandler;
import com.vaadin.terminal.gwt.client.communication.RpcProxy;
import com.vaadin.terminal.gwt.client.communication.ServerRpc;
import com.vaadin.terminal.gwt.client.communication.StateChangeEvent;
import com.vaadin.terminal.gwt.client.ui.AbstractComponentConnector;
import com.vaadin.terminal.gwt.client.ui.Connect;

@Connect(Refresher.class)
public class RefresherConnector extends AbstractComponentConnector {
	private UpdateRPC rpc;

	public interface UpdateRPC extends ServerRpc {
		public void update();
	}

	@Override
	public void init() {
		rpc = RpcProxy.create(UpdateRPC.class, this);
		VRefresher widget = getWidget();
		widget.setUpdateHandler(new UpdateHandler() {
			@Override
			public void update() {
				rpc.update();
			}
		});
	}

	@Override
	public RefresherState getState() {
		return (RefresherState) super.getState();
	}

	@Override
	protected Widget createWidget() {
		return GWT.create(VRefresher.class);
	}

	@Override
	public VRefresher getWidget() {
		return (VRefresher) super.getWidget();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);
		getWidget().setMilliseconds(getState().getMilliseconds());
	}
}
