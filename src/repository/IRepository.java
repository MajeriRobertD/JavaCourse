package repository;

import domain.Entity;

import java.io.IOException;
import java.util.ArrayList;

public interface IRepository<T extends Entity> {

    public void addObject(T newObject) throws IOException;
    public ArrayList<T> getRepo();
    public T getByIndex(int index);
    public void updateByIndex(int index, T newObject);
    public void deleteByIndex(int index);
}
