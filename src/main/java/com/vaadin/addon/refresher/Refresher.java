package com.vaadin.addon.refresher;

import java.io.Serializable;

import com.vaadin.addon.refresher.gwt.client.RefresherConnector.UpdateRPC;
import com.vaadin.addon.refresher.gwt.client.RefresherState;
import com.vaadin.ui.AbstractComponent;

/**
 * Server side component for the VMyComponent widget.
 */
public class Refresher extends AbstractComponent {

	private int milliseconds;

	public interface UpdateHandler extends Serializable {
		public void update();
	}

	private UpdateHandler updateHandler = null;

	public UpdateRPC rpc = new UpdateRPC() {
		@Override
		public void update() {
			updateHandler.update();
		}
	};

	public Refresher() {
		registerRpc(rpc);
	}

	public void setMilliseconds(int milliseconds) {
		this.milliseconds = milliseconds;
		getState().setMilliseconds(milliseconds);
		requestRepaint();
	}

	@Override
	protected RefresherState createState() {
		return new RefresherState(this.milliseconds);
	}

	@Override
	public RefresherState getState() {
		return (RefresherState) super.getState();
	}

	public void setUpdateHandler(UpdateHandler updateHandler) {
		this.updateHandler = updateHandler;
	}

	public UpdateHandler getUpdateHandler() {
		return updateHandler;
	}
}
