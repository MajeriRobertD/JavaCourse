package repository;

import domain.Activity;
import domain.Entity;
import domain.Teacher;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DBRepository<T extends Entity> implements IRepository<T> {
    private static final String url = "jdbc:sqlite:/home/robert/IdeaProjects/first/lab_01/src/first.db";

    private Connection conn = null;


    public DBRepository() {
        this.openConnection();
        this.createSchema();
    }

    private void openConnection(){
        try{
            if(conn == null || conn.isClosed())
                conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection(){
        try{
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createSchema(){
        try{
            final Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS teachers(id int, name varchar(100), status varchar(100), email varchar(100));");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS activities(id int, name varchar(100), teacher_name varchar(100));");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addObject(T newObject) throws IOException {
        try{
            if( newObject instanceof Teacher) {
                PreparedStatement statement = conn.prepareStatement("INSERT INTO teachers VALUES(?, ?, ?, ?)");
                statement.setInt(1, newObject.getId());
                statement.setString(2, ((Teacher) newObject).getName());
                statement.setString(3, ((Teacher) newObject).getStatus());
                statement.setString(4, ((Teacher) newObject).getEmail());
                statement.executeUpdate();
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addActivity(Activity a){
        try{
            PreparedStatement statement = conn.prepareStatement("INSERT INTO activities VALUES(?, ?, ?)");
            statement.setInt(1, a.getId());
            statement.setString(2, a.getName());
            statement.setString(3, a.getTeacher_name());
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<T> getRepo() {
        return null;
    }
    public ArrayList<Activity> getActivities(){
        ArrayList<Activity> activities = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM activities");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Activity a = new Activity(rs.getInt("id"), rs.getString("name"), rs.getString("teacher_name"));
                activities.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activities;
    }

    public ArrayList<Teacher> getTeachers() {
        ArrayList<Teacher> teachers = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM teachers");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Teacher t = new Teacher(rs.getInt("id"), rs.getString("name"), rs.getString("status"), rs.getString("email"));
                teachers.add(t);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return teachers;
    }

    @Override
    public T getByIndex(int index) {
        return null;
    }

    @Override
    public void updateByIndex(int index, T newObject) {

    }

    @Override
    public void deleteByIndex(int index) {

    }
}
