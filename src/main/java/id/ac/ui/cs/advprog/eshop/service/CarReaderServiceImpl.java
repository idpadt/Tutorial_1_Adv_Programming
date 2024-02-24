package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepoReader;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CarReaderServiceImpl implements CarReaderService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getData() {
        return carRepository.getData();
    }

    @Override
    public Car findById(String carId) {
        return CarRepoReader.getCarById(carRepository.getData(), carId);
    }
}
