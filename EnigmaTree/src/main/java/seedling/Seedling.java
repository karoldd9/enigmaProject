package seedling;

import exceptions.TreeDidNotGrowException;
import lombok.Getter;

import java.util.List;
import java.util.Random;

@Getter
public abstract class Seedling {
    protected List<Branch> branches;
    protected Leaf leaf;
    protected String leafColor;
    protected TreeTrunk treeTrunk;
    protected float height=10; //CM

    protected Seedling(Leaf leaf, String leafColor, TreeTrunk treeTrunk) {
        this.leaf = leaf;
        this.treeTrunk = treeTrunk;
        this.leafColor = leafColor;
    }

    protected Seedling(Leaf leaf, TreeTrunk treeTrunk) {
        this.leaf = leaf;
        this.treeTrunk = treeTrunk;
    }

    public void grow(float treeHeight, float trunkThickness){
        height = treeHeight;
        treeTrunk.setTrunkThickness(trunkThickness);
        branches = BranchGenerator.generateBranches(100 + (new Random().nextInt(100)), leafColor);
    }

    @Override
    public String toString() {
        if(branches == null) {
            throw new TreeDidNotGrowException();
        }
        StringBuilder result = new StringBuilder();

        if(leaf.equals(Leaf.JUST_A_LEAF)) {
            result.append("Leafy tree");
        } else {
            result.append("Conifer");
        }

        result.append(":")
                .append("\n\t")
                .append("Has ").append(branches.size()).append(" branches")
                .append("\n\t")
                .append("Leaf: ").append(leaf.getLeafType())
                .append("\n\t")
                .append("Leaf color: ").append(leafColor)
                .append("\n\t")
                .append("Tree trunk color: ").append(treeTrunk.getBarkColor())
                .append("\n\t")
                .append("Tree trunk thickness: ").append(treeTrunk.getTrunkThickness())
                .append("\n\t")
                .append("Height: ").append(height);

        return result.toString();
    }
}