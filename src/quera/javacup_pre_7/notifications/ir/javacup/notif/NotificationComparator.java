package quera.javacup_pre_7.notifications.ir.javacup.notif;

import quera.javacup_pre_7.notifications.com.xos.Notification;

public class NotificationComparator {

    public static int comparePriorityAndTime(Notification o1, Notification o2) {
        int p = Integer.compare( o2.getPriority().ordinal(), o1.getPriority().ordinal());
        if(p!=0) return p;
        int t = o2.getTime().compareTo(o1.getTime());
        return t;
    }


}
