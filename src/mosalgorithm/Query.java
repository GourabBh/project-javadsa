package mosalgorithm;

public class Query {
    private int left;
    private int right;
    private int insertionOrder;

    Query(int left, int right, int insertionOrder) {
        this.left = left;
        this.right = right;
        this.insertionOrder = insertionOrder;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getInsertionOrder() {
        return insertionOrder;
    }

    public void setInsertionOrder(int insertionOrder) {
        this.insertionOrder = insertionOrder;
    }
}
