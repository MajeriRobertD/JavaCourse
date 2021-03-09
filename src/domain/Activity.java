package domain;

import java.io.Serializable;

public class Activity extends Entity implements Serializable {
    private String name;
    private String teacher_name;

    public Activity(int id,String name, String teacher_name) {
        super(id);
        this.name = name;
        this.teacher_name = teacher_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                "} " + super.toString();
    }
}
