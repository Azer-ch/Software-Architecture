package com.directi.training.srp.exercise_refactored;

import java.util.List;

public class CarCatalogue {
    private final CarRepository _carRepository;
    public CarCatalogue(CarRepository carRepository){
        _carRepository = carRepository;
    }
    public String getCarsNames()
    {
        List<Car> carsDb = _carRepository.getCarsFromDb();
        StringBuilder sb = new StringBuilder();
        for (Car car : carsDb) {
            sb.append(car.getBrand());
            sb.append(" ");
            sb.append(car.getModel());
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }
}
