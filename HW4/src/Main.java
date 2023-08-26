public class Main {
    public static void main(String[] args){
        Treap<String> testTree = new Treap<>();
        testTree.add("v", 21);
        testTree.add("z", 47);
        testTree.add("j", 65);
        testTree.add("g", 80);
        testTree.add("a", 60);
        testTree.add("r", 40);
        testTree.add("p", 99);
        testTree.add("u", 75);
        testTree.add("x", 25);
        testTree.add("w", 32);
        testTree.delete("z");
        System.out.println(testTree);
    }
}
