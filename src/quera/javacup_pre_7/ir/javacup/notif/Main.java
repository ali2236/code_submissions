package quera.javacup_pre_7.ir.javacup.notif;


import quera.javacup_pre_7.com.xos.Notification;
import quera.javacup_pre_7.com.xos.Priority;

import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
        AppBasedSummarizer summarizer = new AppBasedSummarizer();

        Notification instagramHigh = create("Instagram", Priority.HIGH, 1000);
        Notification instagramLow = create("Instagram", Priority.LOW, 2000);
        Notification twitterHigh = create("Twitter", Priority.HIGH, 3000);

        List<Notification> input = asList(instagramHigh, instagramLow, twitterHigh);
        List<Notification> result = summarizer.summarize(input);

        System.out.println("Size: " + result.size());
        for (int i = 0; i < result.size(); i++) {
            Notification n = result.get(i);
            System.out.println(String.format("Item[%d]: %s", i, notifShortStr(n)));
        }
    }

    private static String notifShortStr(Notification n) {
        return "[" + n.getApp() + ", " + n.getPriority() + ", " + n.getTime().getTime() + "]";
    }

    protected static Notification create(String app, Priority priority, long time) {
        return Notification.builder()
                .app(app)
                .message("Message from app: " + app)
                .priority(priority)
                .time(new Date(time))
                .build();
    }

}

