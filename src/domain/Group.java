package domain;

public class Group extends Formation {
    private int number;


    public Group(int id, String name) {
        super(id, name);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
