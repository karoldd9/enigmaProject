import org.junit.jupiter.api.Test;
import seedling.Leaf;
import seedling.TreeTrunk;
import trees.Conifer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TreeTests {

    @Test
    public void ConiferTest() {
        TreeTrunk treeTrunk = new TreeTrunk("Dark brown");
        Conifer conifer = new Conifer(Leaf.CONIFER_LEAF, treeTrunk);
        conifer.grow(300, 50);

        assertEquals(null, conifer.getLeafColor());
        assertEquals(Leaf.CONIFER_LEAF, conifer.getLeaf());
        assertTrue(conifer.toString().contains("Has needles"));
        assertTrue(conifer.getBranches().size() >= 100);
    }
}