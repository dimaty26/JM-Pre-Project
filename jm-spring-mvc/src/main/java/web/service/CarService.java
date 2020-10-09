package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import web.model.CarList;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final CarList carList = new CarList();

    public List<Car> getCars(int count) {

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            if (count >= carList.getCarList().size()) {
                break;
            }
            cars.add(carList.getCarList().get(i));
        }

        return cars;
    }

    public List<Car> getAllCars() {
        return carList.getCarList();
    }
}
