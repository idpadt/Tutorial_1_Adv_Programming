package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import java.util.List;

public interface CarRepository {

    public Car add(Car car);

    public Car edit(Car car);

    public void delete(String id);

    public List<Car> getData();
}
