package quera.javacup_pre_7.ir.javacup.notif;


import quera.javacup_pre_7.com.xos.Notification;
import quera.javacup_pre_7.com.xos.NotificationSummarizer;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TimeBasedSummarizer implements NotificationSummarizer {

	@Override
	public List<Notification> summarize(List<Notification> notifications) {
		notifications.sort(NotificationComparator::comparePriorityAndTime);
		return notifications.stream().filter(notification -> {
			Date now = new Date();
			long d = now.getTime() - notification.getTime().getTime();
			long seconds = d / 1000;
			long minutes = seconds / 60;
			return minutes < 5;
		}).collect(Collectors.toList());
	}

}
