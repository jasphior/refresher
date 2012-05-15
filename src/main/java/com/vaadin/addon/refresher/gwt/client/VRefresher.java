package com.vaadin.addon.refresher.gwt.client;

import java.io.Serializable;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Widget;

public class VRefresher extends Widget {

	/** Set the CSS class name to allow styling. */
	public static final String CLASSNAME = "v-mycomponent";
	private Timer timer;

	// /** The client side widget identifier */
	// protected String paintableId;

	// /** Reference to the server connection object. */
	// ApplicationConnection client;

	/**
	 * The constructor should first call super() to initialize the component and
	 * then handle any initialization relevant to Vaadin.
	 */
	public VRefresher() {
		// TODO Example code is extending GWT Widget so it must set a root
		// element.
		// Change to proper element or remove if extending another widget
		setElement(Document.get().createDivElement());

		// This method call of the Paintable interface sets the component
		// style name in DOM tree
		setStyleName(CLASSNAME);
		timer = createTimer();
	}

	private Timer createTimer() {
		Timer timer = new Timer() {
			@Override
			public void run() {
				update();
			}

		};
		return timer;
	}

	private void update() {
		updateHandler.update();
	}

	private int milliseconds;

	public int getMilliseconds() {
		return milliseconds;
	}

	public void setMilliseconds(int milliseconds) {
		this.milliseconds = milliseconds;
		timer.scheduleRepeating(milliseconds);
	}

	private UpdateHandler updateHandler = null;

	public interface UpdateHandler extends Serializable {
		public void update();
	}

	public void setUpdateHandler(UpdateHandler updateHandler) {
		this.updateHandler = updateHandler;
	}

	public UpdateHandler getUpdateHandler() {
		return updateHandler;
	}
}
