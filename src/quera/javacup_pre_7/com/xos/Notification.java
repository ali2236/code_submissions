package quera.javacup_pre_7.com.xos;

import java.util.Date;

public class Notification {

	private final String app;
	private final Priority priority;
	private final Date time;
	private final String message;

	private Notification(String app, Priority priority, Date time, String message) {
		this.app = app;
		this.priority = priority;
		this.time = time;
		this.message = message;
	}

	public static NotificationBuilder builder() {
		return new NotificationBuilder();
	}

	public static class NotificationBuilder {

		private String app;
		private Priority priority;
		private Date time;
		private String message;

		private NotificationBuilder() {
		}

		public NotificationBuilder app(String app) {
			this.app = app;
			return this;
		}

		public NotificationBuilder priority(Priority priority) {
			this.priority = priority;
			return this;
		}

		public NotificationBuilder time(Date time) {
			this.time = time;
			return this;
		}

		public NotificationBuilder message(String message) {
			this.message = message;
			return this;
		}

		public Notification build() {
			return new Notification(app, priority, time, message);
		}
	}

	public String getApp() {
		return app;
	}

	public Date getTime() {
		return time;
	}

	public String getMessage() {
		return message;
	}

	public Priority getPriority() {
		return priority;
	}

	@Override
	public String toString() {
		return "Notification{" + "app='" + app + '\'' + ", priority=" + priority + ", time=" + time + ", message='" + message + '\'' + '}';
	}
}
