package codeforces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SegmentSubset {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            Segment[] segments = new Segment[n];
            int maxCoordinate = 0;
            for (int i = 0; i < n; i++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                maxCoordinate = Math.max(maxCoordinate, r);
                segments[i] = new Segment(l, r);
            }
            solve(segments, maxCoordinate);
        }
    }

    static int[][] segmem;

    static List<Segment>[] segmentsFromLeft;

    public static void solve(Segment[] segments, int maxCoordinate) {

        segmem = new int[maxCoordinate+1][maxCoordinate+1];

        // initialize [segmem] with -1
        for (int i = 0; i < segmem.length; i++) Arrays.fill(segmem[i],-1);

        // holds a list of segments that start from the [i]th index
        segmentsFromLeft = new List[maxCoordinate+1];

        // initialize [segmentsFromLeft] with [ArrayList]s
        for (int i = 0; i < segmentsFromLeft.length; i++) segmentsFromLeft[i] = new ArrayList<>();

        // add each [segment] to its starting list
        for (Segment segment : segments) segmentsFromLeft[segment.l].add(segment);

        int maximumSubset = maximumSubset(0,maxCoordinate);

        System.out.println(maximumSubset);
    }

    public static int maximumSubset(int l, int r) {
        if(segmem[l][r] != -1) return segmem[l][r];
        if(l > r) return 0;

        segmem[l][r] = 0;

        // check if we have a segment that is from [l] to [r]
        int fullCover = 0;
        for(Segment segment : segmentsFromLeft[l]) {
            if(segment.r == r) {
                fullCover = 1;
                break;
            }
        }


        segmem[l][r] = Math.max(segmem[l][r], maximumSubset(l + 1, r) + fullCover);

        // actual calculation
        for(Segment segment : segmentsFromLeft[l]) {
            if(segment.r >= r) {
                continue;
            }
            segmem[l][r] = Math.max(segmem[l][r], maximumSubset(l, segment.r) + maximumSubset(segment.r + 1, r) + fullCover);
        }

        return segmem[l][r];
    }
}

class Segment {
    int l, r;

    Segment(int l, int r) {
        this.l = l;
        this.r = r;
    }
}
