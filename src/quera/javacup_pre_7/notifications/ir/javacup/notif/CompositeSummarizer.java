package quera.javacup_pre_7.notifications.ir.javacup.notif;

import quera.javacup_pre_7.notifications.com.xos.Notification;
import quera.javacup_pre_7.notifications.com.xos.NotificationSummarizer;

import java.util.List;

public class CompositeSummarizer implements NotificationSummarizer {

	private List<NotificationSummarizer> summarizers;

	public CompositeSummarizer(List<NotificationSummarizer> summarizers) {
		this.summarizers = summarizers;
	}

	@Override
	public List<Notification> summarize(List<Notification> notifications) {
		for (NotificationSummarizer summarizer : summarizers) {
			notifications = summarizer.summarize(notifications);
		}
		return notifications;
	}

}
