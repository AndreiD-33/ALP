package Cautari;

public class Arbori {
    public static void main(String[] args){
        BTNode a20=new BTNode(20,null,null);
        BTNode a17=new BTNode(17,null,a20);
        BTNode a3=new BTNode(3,null,null);
        BTNode a53=new BTNode(53,null,null);
        BTNode a59=new BTNode(59,null,null);
        BTNode a9=new BTNode(9,a3,a17);
        BTNode a55=new BTNode(55,a53,a59);
        BTNode a45=new BTNode(45,a9,a55);
        BTNode nodRezultat=cautare2(a45,100);
        if(nodRezultat==null)
            System.out.println("nu am o valoare");
        else System.out.println(nodRezultat.getValoare());
    }

    static BTNode cautare1(BTNode arbore,int k)
    {
        if((int)arbore.getValoare()==k)
            return arbore;
        if((int)arbore.getValoare()>k)
            return cautare1(arbore.getLeft(),k);
        if((int)arbore.getValoare()<k)
            return cautare1(arbore.getRight(),k);
        return null;
    }

    static BTNode cautare2(BTNode arbore, int k){
        if(arbore==null||(int)arbore.getValoare()==k)
            return arbore;
        if((int)arbore.getValoare()>k)
            return cautare2(arbore.getLeft(),k);
        else return cautare2(arbore.getRight(),k);
    }
}
