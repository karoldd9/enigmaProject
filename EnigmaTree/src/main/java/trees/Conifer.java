package trees;

import seedling.BranchGenerator;
import seedling.Leaf;
import seedling.Seedling;
import seedling.TreeTrunk;

import java.util.Random;

public class Conifer extends Seedling {
    public Conifer(Leaf leaf, TreeTrunk treeTrunk) {
        super(leaf, treeTrunk);
    }

    @Override
    public void grow(float treeHeight, float trunkThickness){
        height = treeHeight;
        treeTrunk.setTrunkThickness(trunkThickness);
        this.branches = BranchGenerator.generateBranches(100 + (new Random().nextInt(100)), "Green needles");
    }

    @Override
    public String toString() {
        if(super.toString().contains("Leaf color: null")) {
            String result = "";
            result = super.toString().replace("Leaf color: null", "Has needles");
            return result;
        }
        return super.toString();
    }
}