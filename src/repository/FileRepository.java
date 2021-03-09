package repository;

import domain.Entity;
import domain.Teacher;

import java.io.*;
import java.util.ArrayList;

public class FileRepository<T extends Entity>  implements IRepository<T> {
    private String filepath;

    public FileRepository(String filepath) {
        this.filepath = filepath;

    }

    public ArrayList<Teacher> readTeachers(String filepath){
        ArrayList<Teacher> teachers = new ArrayList<>();
        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader(filepath));
            String line = null;
            while((line = br.readLine()) != null){
                String[] elems = line.split("[,]");
                if (elems.length < 4 )
                    continue;
                Teacher t = new Teacher(Integer.parseInt(elems[0].strip()), elems[1].strip(), elems[2].strip(), elems[3].strip());
                teachers.add(t);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return teachers;

    }

    public void writeTeachers(ArrayList<Teacher> teachers, String filepath){
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(filepath, false));
            for(Teacher t: teachers){
                bw.write(t.getId() + " , " + t.getName() + " , " + t.getStatus() + " , " + t.getEmail());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void addObject(Entity newObject) throws IOException {

    }

    @Override
    public ArrayList getRepo() {
        return null;
    }

    @Override
    public T getByIndex(int index) {
        return null;
    }

    @Override
    public void updateByIndex(int index, Entity newObject) {

    }

    @Override
    public void deleteByIndex(int index) {

    }

    public String getFilepath() {
        return filepath;
    }
}
