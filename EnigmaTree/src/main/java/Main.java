import seedling.Leaf;
import seedling.TreeTrunk;
import trees.Conifer;
import trees.LeafyTree;

public class Main {
    public static void main(String[] args) {
        TreeTrunk leafyTreeTrunk = new TreeTrunk("White");
        LeafyTree leafyTree = new LeafyTree(Leaf.JUST_A_LEAF, "Yellow&Green", leafyTreeTrunk);

        leafyTree.grow(200, 30);
        System.out.println(leafyTree);



        TreeTrunk coniferTreeTrunk = new TreeTrunk("Dark brown");
        Conifer conifer = new Conifer(Leaf.CONIFER_LEAF, coniferTreeTrunk);
        conifer.grow(250, 50);

        System.out.println(conifer);
    }
}