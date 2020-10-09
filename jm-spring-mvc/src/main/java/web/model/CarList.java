package web.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {

    public List<Car> getCarList() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Germany", "Audi", 2015));
        cars.add(new Car("Germany", "BMW", 2018));
        cars.add(new Car("Germany", "VW", 2017));
        cars.add(new Car("USA", "Ford", 2019));
        cars.add(new Car("Great Britain", "Aston Martin", 2020));

        return cars;
    }
}
