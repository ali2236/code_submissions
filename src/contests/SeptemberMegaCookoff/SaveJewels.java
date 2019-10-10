package contests.SeptemberMegaCookoff;

import java.lang.reflect.Array;
import java.util.*;

public class SaveJewels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-->0){
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            List<Integer> jewelsValues = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                jewelsValues.add(scanner.nextInt());
            }
            List<Integer> Ls = new ArrayList<>(M);
            List<Integer> Rs = new ArrayList<>(M);
            for (int i = 0; i < M; i++) {
                Ls.add(scanner.nextInt());
                Rs.add(scanner.nextInt());
            }

            // what is the most expensive jewel that is going to get stolen
            int maxJewel = Collections.max(Rs);
            int maxJewelIndex = Rs.indexOf(maxJewel);
            int dayToPrevent = maxJewelIndex + 1;

            // steal from i = n ; i--
            boolean[] stolen = new boolean[N];
            Arrays.fill(stolen,false);

            for (int day = 1; day <= M; day++) {
                if (day==dayToPrevent) continue;
                // steal
                for (int jewel = Rs.get(day-1); jewel >= Ls.get(day-1); jewel--) {
                    if (!stolen[jewel-1]){
                        stolen[jewel-1] =true;
                        break;
                    }
                }
            }

            // sum the rest
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (!stolen[i]){
                    sum += jewelsValues.get(i);
                }
            }

            System.out.println(sum);
        }
    }
}
