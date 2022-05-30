package seedling;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class BranchGenerator {
    private static int branchId=0;

    public static List<Branch> generateBranches(int count, String leafColor) {
        List<Branch> branches = new ArrayList<>();

        while (count != 0) {
            count--;
            branches.add(generateBranch(leafColor));
        }

        return branches;
    }

    private static Branch generateBranch(String leafColor) {
        Random random = new Random();

        boolean hasLeafs = random.nextBoolean();
        float length = random.nextFloat() % 30;

        return new Branch(hasLeafs, leafColor, length);
    }

    protected static int generateBranchId() {
        return ++branchId;
    }
}