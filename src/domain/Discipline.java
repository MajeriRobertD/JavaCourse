package domain;


import java.io.Serializable;

public class Discipline extends Entity implements Serializable {
    private String name;

    public Discipline(int id,String name) {
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
        return "Discipline{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}

