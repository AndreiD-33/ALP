package CodProba2;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public class ARBORI {
    // 24, 25, 32,8,40,35

    public static void main(String[] args) {
        LinkedBinaryTree<Integer>arbore= new LinkedBinaryTree<>();
        arbore.addRoot(24);
        Position<Integer>nod1 = arbore.addLeft(arbore.root(),25);
        Position<Integer>nod2 = arbore.addRight(arbore.root(),32);
        arbore.addLeft(nod1,8);
        arbore.addRight(nod1,40);
        arbore.addLeft(nod2,35);
        System.out.println(arbore.height(arbore.root()));
        limitaInaltime(arbore, 3);
    }
    public static void limitaAdancime(LinkedBinaryTree<Integer> arbore, int maxDepth) {
        for (Position<Integer> node : arbore.postorder()) {
            if (arbore.depth(node) < maxDepth) {
                System.out.println(node.getElement());}}
    }
    public static void limitaValoare(LinkedBinaryTree<Integer> arbore) {
        int sum = 0;
        for (Position<Integer> e : arbore.postorder()) {
            if (sum + e.getElement() > 100) {
                break;}
            sum += e.getElement();
            System.out.println(e.getElement());}}

    public static void limitaInaltime(LinkedBinaryTree<Integer> arbore, int maxHeight) {
        for (Position<Integer> node : arbore.preorder()) {
            if (arbore.height(node) <= maxHeight) {
                System.out.println(node.getElement());
            }}
    }

}
