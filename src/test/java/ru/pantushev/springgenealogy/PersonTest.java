package ru.pantushev.springgenealogy;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.pantushev.springgenealogy.domains.Person;

public class PersonTest {
    @Test
    @Description("Другой персон является одним из родителей")
    public void otherIsParentTest() {
        Person gf = new Person("grandfather", "ln", null, null);
        Person gm = new Person("grandmother", "ln", null, null);
        Person f = new Person("father", "ln", gf, gm);
        Person m = new Person("mom", "ln", null, null);
        Person ch = new Person("ch1", "ch1", f, m);

        Assertions.assertFalse(ch.otherIsParent(null));
        Assertions.assertTrue(ch.otherIsParent(f));
        Assertions.assertTrue(ch.otherIsParent(m));
        Assertions.assertFalse(f.otherIsParent(m));
        Assertions.assertFalse(f.otherIsParent(ch));
        Assertions.assertFalse(m.otherIsParent(ch));
        Assertions.assertFalse(ch.otherIsParent(gf));
        Assertions.assertFalse(ch.otherIsParent(gm));

    }

    @Test
    @Description("Другой персон является сыном/дочерью")
    public void otherIsChildTest() {
        Person f = new Person("father", "ln", null, null);
        Person m = new Person("mom", "ln", null, null);
        Person ch = new Person("ch1", "ch1", f, m);

        Assertions.assertFalse(f.otherIsChild(null));
    }

    @Test
    @Description("Является родителем другого")
    public void isParentTest() {
        Person f = new Person("father", "ln", null, null);
        Person m = new Person("mom", "ln", null, null);
        Person ch = new Person("ch1", "ch1", f, m);

        Assertions.assertFalse(f.isParent(null));
        Assertions.assertTrue(f.isParent(ch));
        Assertions.assertTrue(m.isParent(ch));
        Assertions.assertFalse(ch.isParent(f));
        Assertions.assertFalse(ch.isParent(m));
        Assertions.assertFalse(f.isParent(m));
    }

    @Test
    @Description("Является дочерью другого")
    public void isChildTest() {
        Person f = new Person("father", "ln", null, null);
        Person m = new Person("mom", "ln", null, null);
        Person ch = new Person("ch1", "ch1", f, m);

        Assertions.assertFalse(ch.isChild(null));
        Assertions.assertTrue(ch.isChild(f));
        Assertions.assertTrue(ch.isChild(m));
        Assertions.assertFalse(f.isChild(ch));
        Assertions.assertFalse(m.isChild(ch));
        Assertions.assertFalse(f.isChild(m));
    }

    @Test
    @Description("Другой является прародителем этого")
    public void otherIsAncestor() {
        Person gf = new Person("grandfather", "ln", null, null);
        Person gm = new Person("grandmother", "ln", null, null);
        Person f = new Person("father", "ln", gf, gm);
        Person m = new Person("mom", "ln", null, null);
        Person ch = new Person("ch1", "ch1", f, m);

        Assertions.assertFalse(ch.otherIsAncestor(null));
        Assertions.assertTrue(ch.otherIsAncestor(f));
        Assertions.assertTrue(ch.otherIsAncestor(m));
        Assertions.assertFalse(f.otherIsAncestor(m));
        Assertions.assertFalse(f.otherIsAncestor(ch));
        Assertions.assertFalse(m.otherIsAncestor(ch));
        Assertions.assertTrue(ch.otherIsAncestor(gf));
        Assertions.assertTrue(ch.otherIsAncestor(gm));

    }




}
