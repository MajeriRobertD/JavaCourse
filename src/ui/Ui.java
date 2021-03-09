package ui;

import controller.Controller;
import domain.*;
import exceptions.TeacherException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private Controller controller;
    private Scanner scanner;

    public Ui() {
        this.controller = new Controller();
        this.scanner = new Scanner(System.in);
    }


    private void addTeacher() throws IOException, TeacherException {
        System.out.println("\tEnter id:");
        int id =  this.scanner.nextInt();

        this.scanner.nextLine(); // Advances this scanner past the current line and returns the input that was skipped.
        System.out.println("\tEnter teacher name");
        String name = this.scanner.nextLine();
        System.out.println("\tEnter teacher email");
        String email = this.scanner.nextLine();
        System.out.println("\tEnter teacher status:");
        String status =  this.scanner.nextLine();
        this.controller.addTeacher(id, name, status, email);
        this.controller.addTeacherDB(id, name, status, email);
    }
    private void addTeacherActivityRelation() throws IOException {
        // read relation id
        System.out.println("\tEnter id:");
        int id =  this.scanner.nextInt();

        //read teacher
        System.out.println("\tEnter id:");
        int id2 =  this.scanner.nextInt();

        this.scanner.nextLine(); // Advances this scanner past the current line and returns the input that was skipped.
        System.out.println("\tEnter teacher name");
        String name = this.scanner.nextLine();
        System.out.println("\tEnter teacher email");
        String email = this.scanner.nextLine();
        System.out.println("\tEnter teacher status:");
        String status =  this.scanner.nextLine();
        Teacher t = new Teacher(id2,name, status, email);
        //read activity
        System.out.println("\tEnter id:");
        int id3 =  this.scanner.nextInt();
        this.scanner.nextLine();
        System.out.println("\tEnter activity name:");
        String aname =  this.scanner.nextLine();
        System.out.println("\tEnter the teacher's name associated with this activity:");
        String teacher_name = this.scanner.nextLine();
        Activity a = new Activity(id3, aname, teacher_name);
        //add the relation
        this.controller.addTeacherActivityRelation(id,t,a  );
    }


    private void addActivity() throws IOException {
        System.out.println("\tEnter id:");
        int id =  this.scanner.nextInt();

        this.scanner.nextLine();

        System.out.println("\tEnter activity name:");
        String name =  this.scanner.nextLine();

        System.out.println("\tEnter the teacher's name associated with this activity:");
        String teacher_name = this.scanner.nextLine();
        this.controller.addActivity(id,name,teacher_name);
        this.controller.addActivityDB(id, name, teacher_name);
    }

    private void addRoom() throws IOException {
        System.out.println("\tEnter id:");
        int id =  this.scanner.nextInt();

        this.scanner.nextLine();

        System.out.println("\tEnter room number:");
        int roomNumber =  this.scanner.nextInt();
        this.scanner.nextLine();

        System.out.println("\t Enter building name");
        String buildingName = this.scanner.nextLine();


        this.controller.addRoom(id, roomNumber,buildingName);
    }



    private void addDiscipline() throws IOException {
        System.out.println("\tEnter id:");
        int id =  this.scanner.nextInt();

        this.scanner.nextLine();

        System.out.println("\tEnter discipline name:");
        String name =  this.scanner.nextLine();

        this.controller.addDiscipline(id,name);
    }

    private void getTeachers() {
        ArrayList<Teacher> teachers = this.controller.getTeachers();
        for(Teacher t : teachers) {
            System.out.println(t);
        }
    }
    // text write
    private void writeTeachers(){
        ArrayList<Teacher> teachers = this.controller.getTeachers();
        this.controller.writeTeachers(teachers);
    }
    // text read
    private  void readTeachers() throws IOException, TeacherException {
        ArrayList<Teacher> teachers = this.controller.readTeachers();
        for(Teacher t: teachers) {
            System.out.println(t);
            try {
                this.controller.addTeacher(t.getId(), t.getName(), t.getStatus(), t.getEmail());
            }catch (TeacherException ignored){

            }
        }
    }
    //database read
    private void readTeachersDB(){
        ArrayList<Teacher> teachers = this.controller.readDatabaseTeachers();
        for(Teacher t: teachers)
            System.out.println(t);
    }
    private void readActivityDB(){
        ArrayList<Activity> activities = this.controller.readDatabaseActivities();
        for(Activity a: activities)
            System.out.println(a);
    }
    private void serializeTeachers(){
        ArrayList<Teacher> teachers = this.controller.getTeachers();
        this.controller.serializeTeachers(teachers);
    }

    private void deserializeTeachers() throws IOException {
        ArrayList<Teacher> teachers = this.controller.deserializeTeacher();
        for(Teacher t: teachers){
            System.out.println(t);
            try {
                this.controller.addTeacher(t.getId(), t.getName(), t.getStatus(), t.getEmail());
            }catch (TeacherException ignored){

            }
        }
    }
    private void getActivities(){
        ArrayList<Activity> activities = this.controller.getActivities();
        for(Activity a : activities)
            System.out.println( a);
    }
    private void getTeacherActivityRelations(){
        ArrayList<Relation> relations = this.controller.getTeacherActivityRelations();
        for(Relation r : relations)
            System.out.println(r);
    }

    private void getActivityRoomRelations(){
        ArrayList<Relation> relations = this.controller.getActivityRoomRelations();
        for(Relation r : relations)
            System.out.println(r);
    }

    private void getDisciplines(){
        ArrayList<Discipline> disciplines = this.controller.getDisciplines();
        for(Discipline d: disciplines)
            System.out.println( d);
    }
    private void getRooms(){
        ArrayList<Room> rooms = this.controller.getRooms();
        for(Room r: rooms)
            System.out.println(r);
    }

    private void getTeacherByIndex(){
        System.out.println("Enter index:");
        int index =  this.scanner.nextInt();
        System.out.println(this.controller.getTeacherByIndex(index));
    }
    private void getActivityByIndex(){
        System.out.println("Enter index:");
        int index = this.scanner.nextInt();
        System.out.println(this.controller.getActivityByIndex(index));
    }
    private void getDisciplineByIndex(){
        System.out.println("Enter index:");
        int index = this.scanner.nextInt();
        System.out.println(this.controller.getDisciplineByIndex(index));
    }



    private void updateTeacher(){
        this.scanner.nextLine(); // Advances this scanner past the current line and returns the input that was skipped.
        System.out.println("Enter index:");
        int index = this.scanner.nextInt();
        this.scanner.nextLine();

        System.out.println("\tEnter teacher name");
        String name = this.scanner.nextLine();

        System.out.println("\tEnter teacher email");
        String email = this.scanner.nextLine();

        System.out.println("\tEnter teacher status:");
        String status =  this.scanner.nextLine();
        this.controller.updateTeacher(index, name, status, email);
    }

    private void updateActivity(){
        System.out.println("Enter index:");
        int index = this.scanner.nextInt();
        this.scanner.nextLine();

        System.out.println("\tEnter activity name:");
        String name =  this.scanner.nextLine();

        System.out.println("\tEnter the teacher's name associated with this activity:");
        String teacher_name = this.scanner.nextLine();
        this.controller.updateActivity(index, name, teacher_name);
    }

    private void updateDiscipline(){
        System.out.println("Enter index:");
        int index = this.scanner.nextInt();
        this.scanner.nextLine();

        System.out.println("\tEnter discipline name:");
        String name =  this.scanner.nextLine();
        this.controller.updateDiscipline(index, name);
    }
    private void deleteTeacher(){
        System.out.println("Enter index:");
        int index = this.scanner.nextInt();
        this.scanner.nextLine();
        this.controller.removeTeacher(index);
    }
    private void deleteActivity(){
        System.out.println("Enter index:");
        int index = this.scanner.nextInt();
        this.scanner.nextLine();
        this.controller.removeActivity(index);
    }
    private void deleteDiscipline(){
        System.out.println("Enter index:");
        int index = this.scanner.nextInt();
        this.scanner.nextLine();

        this.controller.removeDiscipline(index);
    }

    private void listTeachersWithGivenStatus(){
        this.scanner.nextLine();
        System.out.println("\tEnter teacher status:");
        String status =  this.scanner.nextLine();
        ArrayList<Teacher>  teachers = this.controller.teachersByRank(status);

        for(Teacher t: teachers)
            System.out.println(t);

    }

    private void printMenu(){
        System.out.println("\t");
        System.out.println("0.Exit");
        System.out.println("1.Add teacher");
        System.out.println("2.Add activity");
        System.out.println("3.Add discipline");
        System.out.println("4.Show teachers");
        System.out.println("5.Show activities");
        System.out.println("6.Show disciplines");
        System.out.println("7.Get teacher by index");
        System.out.println("8.Get activity by index");
        System.out.println("9.Get discipline by index");
        System.out.println("10.Update teacher at given index");
        System.out.println("11.Update activity at given index");
        System.out.println("12.Update discipline at given index");
        System.out.println("13.Remove teacher");
        System.out.println("14.Remove activity");
        System.out.println("15.Remove discipline");
        System.out.println("16.Add room.");
        System.out.println("17.Show rooms");
        System.out.println("18.Serialize teachers.");
        System.out.println("19.Deserialize teachers.");
        System.out.println("20.Write teachers to text file.");
        System.out.println("21.Read teachers from text file.");
        System.out.println("22.Read teachers from database.");
        System.out.println("23.Read activities from database");
        System.out.println("24.Show the teacher-activity relations");
        System.out.println("25.Show teachers with a given rank.");
        System.out.println("26.Show the activity-room relations");
    }
    private void populate() throws IOException, TeacherException {
        try {
            for (Teacher t : this.controller.readTeachers())
                this.controller.addTeacher(t.getId(), t.getName(), t.getStatus(), t.getEmail());
            System.out.println("print loop1");
        } catch (TeacherException ignored){ }

        try {
            for (Teacher t : this.controller.deserializeTeacher())
                this.controller.addTeacher(t.getId(), t.getName(), t.getStatus(), t.getEmail());
            System.out.println("print loop2");
        }catch (TeacherException z){
            System.out.println("Teacher from des already in");

        }


        this.controller.addTeacherActivityRelation(1, new Teacher(1,"test", "professor", "test"),
                new Activity(1,"testing", "vasi" ));

        this.controller.addTeacherActivityRelation(2, new Teacher(2,"test2", "professor", "test2"),
                new Activity(2,"relation2", "Ion" ));
        this.controller.addTeacherActivityRelation(3, new Teacher(3,"test3", "lecturer", "test3"),
                new Activity(3,"relation3", "Ionica" ));

        this.controller.addActivityRoomRelation(1, new Activity(1, "Desen", "vasi"), new Room(1, 1,"b1"));

        this.controller.addActivityRoomRelation(2, new Activity(2, "Mate", "vasi"), new Room(2, 2,"b2"));

        this.controller.addActivityRoomRelation(3, new Activity(3, "BIo", "vasi"), new Room(3, 3,"b3"));

    }

    public void run() throws IOException, TeacherException {
        this.populate();
        while(true){
            printMenu();
            System.out.println("\tEnter your choice:");
            //this.scanner.nextLine();
            int choice =  this.scanner.nextInt();
            if(choice == 0)
                break;
            switch (choice){
                case 1:
                    try {
                        this.addTeacher();
                    }catch (TeacherException t){
                        System.out.println("Teacher already in");
                    }
                    break;
                case 2:
                    this.addActivity();
                    break;
                case 3:
                    this.addDiscipline();
                    break;
                case 4:
                    this.getTeachers();
                    break;
                case 5:
                    this.getActivities();
                    break;
                case 6:
                    this.getDisciplines();
                    break;
                case 7:
                    this.getTeacherByIndex();
                    break;
                case 8:
                    this.getActivityByIndex();
                    break;
                case 9:
                    this.getDisciplineByIndex();
                    break;
                case 10:
                    this.updateTeacher();
                    break;
                case 11:
                    this.updateActivity();
                    break;
                case 12:
                    this.updateDiscipline();
                    break;
                case 13:
                    this.deleteTeacher();
                    break;
                case 14:
                    this.deleteActivity();
                    break;
                case 15:
                    this.deleteDiscipline();
                    break;
                case 16:
                    this.addRoom();
                    break;
                case 17:
                    this.getRooms();
                    break;
                case 18:
                    this.serializeTeachers();
                    break;
                case 19:
                    this.deserializeTeachers();
                    break;
                case 20:
                    this.writeTeachers();
                    break;
                case 21:
                    this.readTeachers();
                    break;
                case 22:
                    this.readTeachersDB();
                    break;
                case 23:
                    this.readActivityDB();
                    break;
                case 24:
                    this.getTeacherActivityRelations();
                    break;
                case 25:
                    this.listTeachersWithGivenStatus();
                    break;
                case 26:
                    this.getActivityRoomRelations();
                    break;
            }

        }

    }



}
