package controller;

import domain.*;
import exceptions.TeacherException;
import repository.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class Controller {
    private IRepository<Teacher> teacherRepository;
    private IRepository<Activity> activityRepository;
    private IRepository<Discipline> disciplineRepository;
    private IRepository<Room> roomIRepository;

    private IRepository<Relation> teacherActivityRelationRepo;
    private IRepository<Relation> activityRoomRelationRepo;
    ///file
    private BinaryRepository<Teacher> fileTeacherRepository;
    private FileRepository<Teacher> txtTeacherRepository;

    // database
    private DBRepository<Teacher> dbRepository;

    public Controller() {
        this.teacherRepository = new Repository<>();
        this.activityRepository = new Repository<>();
        this.disciplineRepository = new Repository<>();
        this.roomIRepository = new Repository<>();
        this.teacherActivityRelationRepo = new Repository<>();
        this.activityRoomRelationRepo = new Repository<>();



        //file repo for teachers
        this.fileTeacherRepository = new BinaryRepository<>("/home/robert/IdeaProjects/first/lab_01/src/files/teachers.ser");
        this.txtTeacherRepository = new FileRepository<>("/home/robert/IdeaProjects/first/lab_01/src/files/teachers.txt");

        //database repo for teachers
        this.dbRepository = new DBRepository<>();
    }

    public void addTeacherFile(int id , String name, String status, String email) {
        Teacher t = new Teacher(id, name, status, email);
        this.fileTeacherRepository.addObject(t);
    }

    public void addTeacherDB(int id , String name, String status, String email) throws IOException {
        Teacher t = new Teacher( id ,  name,  status,  email);
        this.dbRepository.addObject(t);
    }
    public void addActivityDB(int id, String name, String teacher_name){
        Activity a = new Activity( id,name, teacher_name);
        this.dbRepository.addActivity(a);
    }

    public void addRoom(int id, int roomNumber, String building) throws IOException {
        Room r = new Room(id, roomNumber, building);
        this.roomIRepository.addObject(r);
    }

        public void addTeacher(int id, String name, String status, String email) throws IOException, TeacherException {
        Teacher t = new Teacher(id, name, status, email);
        for(Teacher t1: this.teacherRepository.getRepo()) {
            if (t1.equals(t))
                throw new TeacherException("Teacher already in");
        }
        this.teacherRepository.addObject( t);
    }

    public void addTeacherActivityRelation(int id, Teacher t , Activity a) throws IOException {
        Relation r = new Relation(id, t, a);
        this.teacherActivityRelationRepo.addObject(r);
    }

    public void addActivityRoomRelation(int id, Activity a, Room r) throws IOException {
        Relation rel = new Relation(id, r, a);
        this.activityRoomRelationRepo.addObject(rel);
    }



    public void addActivity(int id, String name, String teacher_name) throws IOException {
        Activity a = new Activity( id,name, teacher_name);
            this.activityRepository.addObject(a);
    }

    public void addDiscipline(int id,String name) throws IOException {
        Discipline d = new Discipline(id,name);
        this.disciplineRepository.addObject(d);
    }

    public ArrayList<Teacher> readTeachers(){
        return this.txtTeacherRepository.readTeachers(this.txtTeacherRepository.getFilepath());
    }

    public ArrayList<Teacher> readDatabaseTeachers(){
        return this.dbRepository.getTeachers();
    }
    public ArrayList<Activity> readDatabaseActivities(){
        return this.dbRepository.getActivities();
    }

    public void writeTeachers(ArrayList<Teacher> teachers){
        this.txtTeacherRepository.writeTeachers(teachers, this.txtTeacherRepository.getFilepath());
    }

    public void serializeTeachers(ArrayList<Teacher> teachers ){
        this.fileTeacherRepository.Serialization(teachers, this.fileTeacherRepository.getFilepath());
    }
    public ArrayList<Teacher> deserializeTeacher(){
        return this.fileTeacherRepository.deserialization(this.fileTeacherRepository.getFilepath());
    }

    public ArrayList<Room> getRooms(){
        return this.roomIRepository.getRepo();
    }
    public ArrayList<Teacher> getTeachers(){
        return this.teacherRepository.getRepo();
    }

    public ArrayList<Activity> getActivities(){
        return this.activityRepository.getRepo();
    }

    public ArrayList<Discipline> getDisciplines(){
        return this.disciplineRepository.getRepo();
    }

    public Teacher getTeacherByIndex(int index){
        return this.teacherRepository.getByIndex(index);
    }

    public Activity getActivityByIndex(int index){
        return this.activityRepository.getByIndex(index);
    }

    public Room getRoomByIndex(int index){
        return  this.roomIRepository.getByIndex(index);
    }

    public  Discipline getDisciplineByIndex(int index){
        return this.disciplineRepository.getByIndex(index);
    }

    public ArrayList<Relation> getTeacherActivityRelations(){ return  this.teacherActivityRelationRepo.getRepo(); }

    public ArrayList<Relation> getActivityRoomRelations(){ return  this.activityRoomRelationRepo.getRepo(); }

    public Relation getTeacherActivityRelationByIndex(int index) {
        return  this.teacherActivityRelationRepo.getByIndex(index); }

    public void updateRoom(int index, int roomNumber, String building){
        Room room = this.roomIRepository.getByIndex(index);
        room.setRoomNumber(roomNumber);
        room.setBuilding(building);
        this.roomIRepository.updateByIndex(index, room);
    }

    public void updateTeacher(int index , String name, String status, String email){
        Teacher teacher = this.teacherRepository.getByIndex(index);
        teacher.setName(name);
        teacher.setStatus(status);
        teacher.setEmail(email);
        this.teacherRepository.updateByIndex(index, teacher);
    }
    public void updateActivity(int index, String name, String teacher){
        Activity activity = this.activityRepository.getByIndex(index);
        activity.setName(name);
        activity.setTeacher_name(teacher);
        this.activityRepository.updateByIndex(index, activity);
    }

    public void updateDiscipline(int index, String name){
        Discipline discipline = this.disciplineRepository.getByIndex(index);
        discipline.setName(name);
        this.disciplineRepository.updateByIndex(index, discipline);
    }

    public void removeRoom(int index){
        this.roomIRepository.deleteByIndex(index);
    }

    public void removeTeacher(int index){
        this.teacherRepository.deleteByIndex(index);
    }
    public void removeActivity(int index){
        this.activityRepository.deleteByIndex(index);
    }
    public void removeDiscipline(int index){
        this.disciplineRepository.deleteByIndex(index);
    }



    public ArrayList<Teacher> teachersByRank(String rank){
        ArrayList<Teacher> teachers = this.getTeachers();
        Stream<Teacher> teacherStream =
        teachers.stream().filter(teacher -> teacher.getStatus().equals(rank))
                         .sorted(Comparator.comparing(Teacher::getName));
        ArrayList<Teacher> result = new ArrayList<Teacher>();
        teacherStream.forEach(result::add);

        return result;
    }

}
