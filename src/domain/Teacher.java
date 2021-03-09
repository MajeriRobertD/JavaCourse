package domain;

import java.io.Serializable;
import java.util.Objects;

public class Teacher extends Entity implements Serializable {
    public static final long serialVersionUID = 1L;
    private String name;
    private String status;
    private String email;

    public Teacher(int id,String name, String status, String email) {
        super(id);
        this.name = name;
        this.status = status;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", email='" + email + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(getName(), teacher.getName()) &&
                Objects.equals(getStatus(), teacher.getStatus()) &&
                Objects.equals(getEmail(), teacher.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getStatus(), getEmail());
    }
}
