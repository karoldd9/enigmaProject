package exceptions;

public class TreeDidNotGrowException extends RuntimeException {
    public TreeDidNotGrowException() {
        super("Tree didn't grow. Please grow it");
    }
}