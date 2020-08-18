package codeforces;

import java.util.*;

public class SegmentSubset {

    public static void main(String[] args) {
        Scanner scanner = new Scanner("1\n" + "4\n" +
                "1 5\n" +
                "2 4\n" +
                "2 3\n" +
                "3 4");
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            Segment[] segments = new Segment[n];
            for (int i = 0; i < n; i++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                segments[i] = new Segment(l, r);
            }
            solve(segments);
        }
    }

    static int[][] submem;

    static List<Segment>[] segmentsFromLeft;

    public static void solve(Segment[] segments) {

        // resize [segments] and get it's max coordinate
        int maxCoordinate = compress(segments);

        submem = new int[maxCoordinate + 1][maxCoordinate + 1];

        // initialize [segmem] with -1
        for (int i = 0; i < submem.length; i++) Arrays.fill(submem[i], -1);

        // holds a list of segments that start from the [i]th index
        segmentsFromLeft = new List[maxCoordinate + 1];

        // initialize [segmentsFromLeft] with [ArrayList]s
        for (int i = 0; i < segmentsFromLeft.length; i++) segmentsFromLeft[i] = new ArrayList<>();

        // add each [segment] to its starting list
        for (Segment segment : segments) segmentsFromLeft[segment.l].add(segment);

        int maximumSubset = maximumSubset(0, maxCoordinate);

        System.out.println(maximumSubset);
    }

    public static int compress(Segment[] segments) {

        // record all end points
        Set<Integer> endPoints = new TreeSet<>();
        for (Segment segment : segments) {
            endPoints.add(segment.l);
            endPoints.add(segment.r);
        }

        // make a smaller map for the end points
        int index = 0;
        Map<Integer, Integer> compressMap = new HashMap<>();
        for (int endpoint : endPoints) {
            compressMap.put(endpoint, index++);
        }

        // remap end points on [Segment] objects
        for (Segment segment : segments) {
            segment.l = compressMap.get(segment.l);
            segment.r = compressMap.get(segment.r);
        }

        return index - 1;
    }

    public static int maximumSubset(int l, int r) {
        if (l > r) return 0;

        if (submem[l][r] != -1) return submem[l][r];

        submem[l][r] = 0;

        // check if we have a segment that is from [l] to [r]
        int fullCover = 0;
        for (Segment segment : segmentsFromLeft[l]) {
            if (segment.r == r) {
                fullCover = 1;
                break;
            }
        }

        submem[l][r] = Math.max(submem[l][r], maximumSubset(l + 1, r) + fullCover);

        for (Segment segment : segmentsFromLeft[l]) {

            if (segment.r >= r) continue;

            submem[l][r] = Math.max(submem[l][r], maximumSubset(l, segment.r) + maximumSubset(segment.r + 1, r) + fullCover);
        }

        return submem[l][r];
    }
}

class Segment {
    int l, r;

    Segment(int l, int r) {
        this.l = l;
        this.r = r;
    }
}
