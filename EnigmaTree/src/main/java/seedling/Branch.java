package seedling;

import lombok.Getter;

@Getter
public class Branch extends BranchGenerator {
    private int branch_id;
    private boolean hasLeafs;
    private String leafColor;
    private float length; //CM

    public Branch(boolean hasLeafs, String leafColor, float length) {

        branch_id = super.generateBranchId();

        this.hasLeafs = hasLeafs;

        if(hasLeafs) {
            this.leafColor = leafColor;
        } else {
            this.leafColor = "None";
        }

        this.length = length;
    }


}