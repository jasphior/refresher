package com.vaadin.addon.refresher.gwt.client;

import com.google.gwt.core.client.JsDate;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.vaadin.terminal.gwt.client.ui.label.VLabel;

public class VSinceAutoUpdater extends VLabel {

	/** Set the CSS class name to allow styling. */
	public static final String CLASSNAME = "v-timer-component";
	private Timer timer;

	// /** The client side widget identifier */
	// protected String paintableId;

	// /** Reference to the server connection object. */
	// ApplicationConnection client;

	/**
	 * The constructor should first call super() to initialize the component and
	 * then handle any initialization relevant to Vaadin.
	 */
	public VSinceAutoUpdater() {
		super();
		setStyleName(CLASSNAME);
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
		try {
			setText(getTimeDifference(initialTime));
		} catch (Exception e) {
			System.out.println(e);
			handleError(e);
		}
	}

	private void handleError(Exception e) {
		System.err.println(e.getMessage() + " " + e.getLocalizedMessage());
		if (e.getStackTrace() != null && e.getStackTrace().length > 0) {
			StackTraceElement st = e.getStackTrace()[0];
			Window.alert(st.getLineNumber() + ":" + st.getClassName() + "."
					+ st.getMethodName());
		}
	}

	private long initialTime;
	private boolean shortTime;

	public long getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(long initialTime) {
		this.initialTime = initialTime;
		setText(getTimeDifference(initialTime));
	}

	public void startTimer(int updateFrequency) {
		timer = createTimer();
		timer.scheduleRepeating(updateFrequency);
	}

	public boolean isShortTime() {
		return shortTime;
	}

	public void setShortTime(boolean shortTime) {
		this.shortTime = shortTime;
		setText(getTimeDifference(initialTime));
	}

	int i = 0;

	public enum Time {
		SECOND, MINUTE, HOUR, DAY
	}

	public String getTimeDifference(long time) {
		String txt = "";
		long diff = (long) JsDate.create().getTime() - time;

		boolean past = diff < 0;

		long secs = diff / 1000;

		if (past) {
			secs *= -1;
		}

		if (secs < 60)
			txt = getTimeLinguistics(secs, Time.SECOND);
		else {
			long mins = secs / 60;
			if (mins < 60)
				txt = getTimeLinguistics(mins, Time.MINUTE);
			else {
				long hrs = mins / 60;
				if (hrs < 24) {
					txt = getTimeLinguistics(hrs, Time.HOUR);
				} else {
					long days = hrs / 24;
					txt = getTimeLinguistics(days, Time.DAY);
				}

			}
		}
		return past || secs == 0 ? "now" : txt;
	}

	private String getTimeLinguistics(long qt, Time timeEn) {
		String string = String.valueOf(qt);
		if (shortTime) {
			string = string + "" + timeEn.name().toLowerCase().charAt(0);
		} else {
			string = string + " " + timeEn.name().toLowerCase();
			if (qt > 1) {
				return string + "s";
			}
		}
		return string;
	}
}