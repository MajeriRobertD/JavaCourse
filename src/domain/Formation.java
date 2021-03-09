package domain;

import java.io.Serializable;

public class Formation extends Entity implements Serializable {
    public String name;

    public Formation(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Formation{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
