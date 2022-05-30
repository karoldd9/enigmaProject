package seedling;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeTrunk {
    private String barkColor;
    private float trunkThickness; //CM

    public TreeTrunk(String barkColor) {
        this.barkColor = barkColor;
        trunkThickness = 1F;
    }

    public void increaseThicken() {
        trunkThickness += 1.05F;
    }

    public void setThicken(float trunkThickness) {
        this.trunkThickness = trunkThickness;
    }
}