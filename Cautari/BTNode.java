package Cautari;

public class BTNode {
    private Object valoare;
    private BTNode left;
    private BTNode right;
    public Object getValoare() {
        return valoare;
    }

    public void setValoare(Object v) {
        this.valoare=v;
    }

    public BTNode getLeft() {
        return left;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public BTNode getRight() {
        return right;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }

    public BTNode(Object v, BTNode l, BTNode r) {
        this.valoare = v;
        this.left = l;
        this.right = r;
    }

    public BTNode(Object valoare, BTNode left) {
        this.valoare = valoare;
        this.left = left;
    }
}
