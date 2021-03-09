package domain;

import java.util.ArrayList;

public class Room extends Entity {
    private int roomNumber;
    private String building;

    public Room(int id,int roomNumber, String building) {
        super(id);
        this.roomNumber = roomNumber;
        this.building = building;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBuilding() {
        return building;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", building='" + building + '\'' +
                "} " + super.toString();
    }

    public void setBuilding(String building) {
        this.building = building;
    }



}
