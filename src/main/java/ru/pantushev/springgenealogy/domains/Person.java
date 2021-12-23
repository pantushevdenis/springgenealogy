package ru.pantushev.springgenealogy.domains;

import lombok.Data;
import lombok.NonNull;

@Data
public class Person {
    private final String firstName;
    private final String lastName;
    private final Person father;
    private final Person mother;

    public String getName() {
        return firstName + " " + lastName;
    }

    public boolean otherIsParent(Person other) {
        return
            this.father != null && this.father == other
            || this.mother != null && this.mother == other;
    }

    public boolean otherIsChild(Person other) {
        return (other != null) && other.otherIsParent(this);
    }

    public boolean isParent(Person other)
    {
        return (other != null) && other.otherIsParent(this);
    }

    public boolean isChild(Person other) {
        return otherIsParent(other);
    }

    public boolean otherIsAncestor(Person other) {
        if (other == null)
            return false;
        else
            return this.father != null && (this.father == other || this.father.otherIsAncestor(other))
            || this.mother != null && (this.mother == other || this.mother.otherIsAncestor(other));

    }

    public boolean otherIsDescendant(Person other) {
        return (other != null) && other.otherIsAncestor(this);
    }

    public boolean isAncestor(Person other)
    {
        return (other != null) && other.otherIsAncestor(this);
    }

    public boolean isDescendant(Person other) {
        return otherIsAncestor(other);
    }



}
