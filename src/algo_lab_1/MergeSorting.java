package algo_lab_1;

import java.util.ArrayList;
import java.util.List;

public class MergeSorting {

    private static int numberOfComparisons = 0;
    private static int numberOfReplacements = 0;

    protected static void mergeSortingByPassengerCapacity(List<Plane> planeList) {
        System.out.println("Merge-sort");

        long startTime = System.nanoTime();
        List<Plane> sortedPlaneList = sorted(planeList);
        long endTime = System.nanoTime();

        double duration = (endTime - startTime) / 1000D;
        System.out.println("Execution time in seconds: " + duration);
        System.out.println("Comparisons: " + numberOfComparisons);
        System.out.println("Replacements: " + numberOfReplacements);
        for (Plane plane : sortedPlaneList) {
            System.out.println(plane.toString());
        }
    }

    private static List<Plane> sorted(List<Plane> list) {
        if (list.size() < 2) {
            return list;
        }
        int mid = list.size() / 2;
        return merged(
                sorted(list.subList(0, mid)),
                sorted(list.subList(mid, list.size())));
    }

    private static List<Plane> merged(List<Plane> left, List<Plane> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        List<Plane> merged = new ArrayList<>();
        while (leftIndex < left.size() && rightIndex < right.size()) {
            numberOfReplacements++;
            if (left.get(leftIndex).getPassengerCapacity() < right.get(rightIndex).getPassengerCapacity()) {
                numberOfComparisons++;
                merged.add(left.get(leftIndex++));
            } else {
                merged.add(right.get(rightIndex++));
            }
        }
        merged.addAll(left.subList(leftIndex, left.size()));
        merged.addAll(right.subList(rightIndex, right.size()));
        return merged;
    }
}