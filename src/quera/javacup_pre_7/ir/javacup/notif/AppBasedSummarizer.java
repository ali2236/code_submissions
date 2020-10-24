package quera.javacup_pre_7.ir.javacup.notif;


import quera.javacup_pre_7.com.xos.Notification;
import quera.javacup_pre_7.com.xos.NotificationSummarizer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppBasedSummarizer implements NotificationSummarizer {

	@Override
	public List<Notification> summarize(List<Notification> notifications) {
		notifications.sort(NotificationComparator::comparePriorityAndTime);
		List<Notification> filtered = new ArrayList<>();
		Set<String> apps = new HashSet<>();
		for (Notification notification : notifications){
			boolean n = apps.add(notification.getApp());
			if(n) filtered.add(notification);
		}
		return filtered;
	}

}