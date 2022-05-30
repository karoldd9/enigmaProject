package seedling;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Leaf {
    JUST_A_LEAF("Just a leaf"),
    CONIFER_LEAF("Confider leaf");

    private String leafType;

    @Override
    public String toString() {
        return leafType;
    }
}