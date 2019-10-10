package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


// TODO : WRONG ANSWER

public class PermutationCycles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lenght = scanner.nextInt();
        int[] numbers = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            numbers[i] = scanner.nextInt();
        }
        boolean[] visited = new boolean[lenght];
        List<List<Integer>> cycles = new ArrayList<>();
        int cyclesCount = 0;
        Arrays.fill(visited, false);
        for (int i = 0; i < lenght; i++) {
            if (visited[i]) continue;
            int start = numbers[i];
            cycles.add(new ArrayList<>());
            cycles.get(cyclesCount).add(start);
            visited[start - 1] = true;
            int current = numbers[start - 1];
            while (current != start) {
                cycles.get(cyclesCount).add(current);
                visited[current - 1] = true;
                current = numbers[current - 1];
            }
            cycles.get(cyclesCount).add(current);
            cyclesCount++;
        }
        System.out.println(cyclesCount);
        for (List<Integer> c : cycles){
            for (int i = 0; i < c.size(); i++) {
                if (i == c.size()-1) System.out.print(c.get(i) + "\n");
                else System.out.print(c.get(i) + " ");
            }

        }
    }
}
