package com.directi.training.srp.exercise_refactored;

import java.util.List;

public class CarComparator {
    private final CarRepository _carRepository;

    public CarComparator(CarRepository carRepository) {
        _carRepository = carRepository;
    }
    public Car getBestCar() {
        Car bestCar = null;
        List<Car> carsDb = _carRepository.getCarsFromDb();
        for (Car car : carsDb) {
            if (bestCar == null || car.getModel().compareTo(bestCar.getModel()) > 0) {
                bestCar = car;
            }
        }
        return bestCar;
    }
}
