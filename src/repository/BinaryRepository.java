package repository;

import domain.Entity;

import java.io.*;
import java.util.ArrayList;

public class BinaryRepository<T extends Entity> implements IRepository<T> {
    private   String  filepath ;

    public BinaryRepository(String filepath) {
        this.filepath = filepath;
    }



    public void Serialization(ArrayList<T> entities, String filepath){
        ObjectOutputStream out = null;
        try{
            out = new ObjectOutputStream(new FileOutputStream(filepath));
            out.writeObject(entities);
            System.out.println("success");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public ArrayList<T> deserialization(String filepath){
        ObjectInputStream in = null;
        ArrayList<T> list = null;
        try{
            in = new ObjectInputStream(new FileInputStream(filepath));
            list =  (ArrayList<T>) in.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try{
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    @Override
    public void addObject(T newObject)  {
       try {
           FileOutputStream fileOut = new FileOutputStream(filepath);
           ObjectOutputStream objectOut =new ObjectOutputStream(fileOut);
           objectOut.writeObject(newObject);
           objectOut.close();
           System.out.println("succses");
       } catch (IOException e) {
           e.printStackTrace();
       }
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
    public void updateByIndex(int index, T newObject) {

    }

    @Override
    public void deleteByIndex(int index) {

    }

    public String getFilepath() {
        return filepath;
    }
}
