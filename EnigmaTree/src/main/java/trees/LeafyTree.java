package trees;

import exceptions.TreeDidNotGrowException;
import seedling.Leaf;
import seedling.Seedling;
import seedling.TreeTrunk;

public class LeafyTree extends Seedling {

    public LeafyTree(Leaf leaf, String leafColor, TreeTrunk treeTrunk) {
        super(leaf, leafColor, treeTrunk);
    }

    @Override
    public String toString() {
        if(branches == null) {
            throw new TreeDidNotGrowException();
        }
        StringBuilder result = new StringBuilder(super.toString());
        result.append("\n\t")
                .append("Leaves leaves for winter");
        return result.toString();
    }
}