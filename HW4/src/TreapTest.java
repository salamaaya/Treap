//Aya Salama
//I pledge my honor that I have abided by the Stevens Honor System.

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TreapTest {

    @Test
    void testConstructor(){
        Treap<Integer> testTree1 = new Treap<>();
        assertNull(testTree1.getRoot());
        Treap<Integer> testTree2 = new Treap<>(1234567891);
        assertNull(testTree2.getRoot());
    }

    @Test
    void testAdd(){
        Treap<Integer> testTree = new Treap<>();
        assertTrue(testTree.add(4, 19));
        assertFalse(testTree.add(4, 19));
        assertFalse(testTree.add(null, 19));
        assertTrue(testTree.add(2 ,31));
        assertTrue(testTree.add(6 ,70));
        assertTrue(testTree.add(1 ,84));
        assertTrue(testTree.add(3 ,12));
        assertTrue(testTree.add(5 ,83));
        assertTrue(testTree.add(7 ,26));
        assertFalse(testTree.add(2, 31));
    }

    @Test
    void testAdd2(){
        Treap<Integer> testTree = new Treap<>();
        assertTrue(testTree.add(4));
        assertFalse(testTree.add(4));
        assertFalse(testTree.add(null));
        assertTrue(testTree.add(2));
        assertTrue(testTree.add(6));
        assertTrue(testTree.add(1));
        assertTrue(testTree.add(3));
        assertTrue(testTree.add(5));
        assertTrue(testTree.add(7));
        assertFalse(testTree.add(2));
    }

    @Test
    void testDelete(){
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
        testTree.add("i", 93);
        assertTrue(testTree.delete("z"));
        assertFalse(testTree.delete("z"));
        assertFalse(testTree.delete("l"));
        assertFalse(testTree.delete(null));
        assertTrue(testTree.delete("p"));

        Treap<Integer> testTree2 = new Treap <Integer >();
        testTree2.add(4,19);
        testTree2.add(2,31);
        testTree2.add(6,70);
        testTree2.add(1,84);
        testTree2.add(3,12);
        testTree2.add(5,83);
        testTree2.add(7,26);

        assertTrue(testTree2.delete(4));
        assertFalse(testTree2.delete(4));
        assertTrue(testTree2.delete(2));
        assertTrue(testTree2.delete(6));
        assertTrue(testTree2.delete(1));
        assertFalse(testTree2.delete(null));
        assertTrue(testTree2.delete(3));
        assertTrue(testTree2.delete(5));
        assertTrue(testTree2.delete(7));

    }

    @Test
    void testFind(){
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
        testTree.add("i", 93);
        assertTrue(testTree.find("g"));
        assertTrue(testTree.find("i"));
        assertTrue(testTree.find("v"));
        testTree.delete("z");
        assertFalse(testTree.find("z"));
        assertFalse(testTree.find("l"));
        assertFalse(testTree.find(null));
        assertTrue(testTree.find("p"));
    }

    @Test
    void testToString(){
        Treap<Integer> testTree = new Treap<>();
        testTree.add(4, 19);
        testTree.add(2 ,31);
        testTree.add(6 ,70);
        testTree.add(1 ,84);
        testTree.add(3 ,12);
        testTree.add(5 ,83);
        testTree.add(7 ,26);
        assertEquals("(key=1, priority=84)\n" +
                "  null\n" +
                "  (key=5, priority=83)\n" +
                "    (key=2, priority=31)\n" +
                "      null\n" +
                "      (key=4, priority=19)\n" +
                "        (key=3, priority=12)\n" +
                "          null\n" +
                "          null\n" +
                "        null\n" +
                "    (key=6, priority=70)\n" +
                "      null\n" +
                "      (key=7, priority=26)\n" +
                "        null\n" +
                "        null\n", testTree.toString());
    }

    @Test
    void testToString2(){
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
        assertEquals("(key=p, priority=99)\n" +
                "  (key=g, priority=80)\n" +
                "    (key=a, priority=60)\n" +
                "      null\n" +
                "      null\n" +
                "    (key=j, priority=65)\n" +
                "      null\n" +
                "      null\n" +
                "  (key=u, priority=75)\n" +
                "    (key=r, priority=40)\n" +
                "      null\n" +
                "      null\n" +
                "    (key=w, priority=32)\n" +
                "      (key=v, priority=21)\n" +
                "        null\n" +
                "        null\n" +
                "      (key=x, priority=25)\n" +
                "        null\n" +
                "        null\n", testTree.toString());
    }
}