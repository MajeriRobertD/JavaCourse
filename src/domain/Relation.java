package domain;

public class Relation extends Entity  {
    private Entity o1;
    private Entity o2;

    public Relation(int id, Entity o1, Entity o2){
        super(id);
        this.o1 = o1;
        this.o2 = o2;
    }

    public Entity getO1() {
        return o1;
    }


    public Entity getO2() {
        return o2;
    }

    @Override
    public String toString() {
        return  super.toString() + " " +
                "Relation{" +
                "" + o1 +
                ",=" + o2 +
                "} ";
    }
}
