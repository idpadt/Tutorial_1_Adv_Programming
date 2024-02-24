package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import java.util.Iterator;
import java.util.List;

public class CarRepoReader {

    /**
    public static Iterator<Car> findAll(List<Car> carRepository) {
        return carRepository.iterator();
    }
     **/

    public static int findIndexById(List<Car> productRepository, String productId){
        for(int i=0; i < productRepository.size(); i++) {
            if (productRepository.get(i).getCarId().equals(productId)) {
                return i;
            }
        }
        return -1;
    }

    public static Car getCarById(List<Car> productRepository, String productId){
        int index = findIndexById(productRepository, productId);
        return productRepository.get(index);
    }
}
