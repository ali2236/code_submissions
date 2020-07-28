package hackerrank.algorithms.dynamic;

import java.util.Arrays;

public class Equal {

    public static void main(String[] args) {
        System.out.println(equal(new int[]{1,2,1}));
    }

    // 1, 2, 5
    static int equal(int[] arr) {

        int n = arr.length;

        if(n==0 || n==1){
            return 0;
        }

        int minTimes = -1;
        Arrays.sort(arr);
        boolean allEqaul = true;
        int last = arr[0];
        for (int i = 1; i < n; i++) {
            int current = arr[i];
            if(last!=current){
                int dif = current - last;
            }
        }

        if(allEqaul) return 0;




/*      // do 1
        int[] one = serve(arr, 1);
        int timesForOne = equal(one);
        if(timesForOne==0) return 1;

        // do 2
        int[] two = serve(arr, 2);
        int timesForTwo = equal(two);
        if(timesForTwo==0) return 1;

        // do 5
        int[] five = serve(arr, 5);
        int timesForFive = equal(five);
        if(timesForFive==0) return 1;

        int minTimes = timesForOne;
        int[] min = one;

        if(timesForTwo < minTimes){
            minTimes = timesForTwo;
            min = two;
        }
        if(timesForFive < minTimes){
            minTimes = timesForTwo;
            min=five;
        }*/

        return 1 + minTimes;
    }

    static int[] add(int[] arr,int i, int skip){
        for (int j = 0; j < arr.length; j++) {
            if(j==skip) continue;
            arr[j] += i;
        }
        return arr;
    }

    static int[] serve(int[] arr,int i){
        int[] newArray = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArray);
        for (int j = 0; j < newArray.length - 1; j++) {
            newArray[j] += i;
        }
        return newArray;
    }
}