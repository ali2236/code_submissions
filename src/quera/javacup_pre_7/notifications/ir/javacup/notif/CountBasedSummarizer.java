package quera.javacup_pre_7.notifications.ir.javacup.notif;


import quera.javacup_pre_7.notifications.com.xos.Notification;
import quera.javacup_pre_7.notifications.com.xos.NotificationSummarizer;

import java.util.List;
import java.util.stream.Collectors;

public class CountBasedSummarizer implements NotificationSummarizer {

	@Override
	public List<Notification> summarize(List<Notification> notifications) {
		notifications.sort(NotificationComparator::comparePriorityAndTime);
		return notifications.stream().limit(20).collect(Collectors.toList());
	}

}
