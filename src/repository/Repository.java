package repository;

import domain.Entity;

import java.util.ArrayList;

public class Repository<T extends Entity> implements IRepository<T> {
    private ArrayList<T> repo  = new ArrayList<T>();




    @Override
    public void addObject(T newObject) {
        this.repo.add(newObject);

    }

    public ArrayList<T> getRepo() {
        return repo;
    }

    public T getByIndex(int index){
        return this.repo.get(index);
    }

    @Override
    public void updateByIndex(int index, T newObject){
        this.repo.set(index, newObject);
    }

    public void deleteByIndex(int index){
        this.repo.remove(index);
    }
}