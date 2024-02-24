package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.service.CarManipulatorService;
import id.ac.ui.cs.advprog.eshop.service.CarReaderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import jakarta.validation.*;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/car")
public class CarController{

    private final String createPage = "createCar";
    private final String editPage = "editCar";
    private final String redirectToList = "redirect:list";

    @Autowired
    private CarManipulatorService carManipulatorService;
    @Autowired
    private CarReaderService carReaderService;

    @GetMapping("/create")
    public String createCarPage(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return createPage;
    }

    @PostMapping("/create")
    public String createCarPost(@Valid @ModelAttribute Car car, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return createPage; // Return to the form with error messages
        }
        carManipulatorService.create(car);
        return redirectToList;
    }

    @GetMapping("/list")
    public String carListPage(Model model) {
        List<Car> allCars = carReaderService.getData();
        model.addAttribute("cars", allCars);
        return "carList";
    }

    @GetMapping("/edit/{carId}")
    public String editCarPage(@PathVariable String carId, Model model) {
        Car car = carReaderService.findById(carId);
        model.addAttribute("car", car);
        return editPage;
    }

    @PostMapping( "/edit")
    public String editCarPost(@Valid @ModelAttribute Car car, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return editPage;
        }
        carManipulatorService.update(car.getCarId(), car);
        return redirectToList;
    }

    @PostMapping("/delete")
    public String deleteCar(@RequestParam("carId") String carId) {
        carManipulatorService.deleteCarById(carId);
        return redirectToList;
    }
}