package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {
    @GetMapping(value = "/cars")
    public String printCars(@RequestParam("count") int count, ModelMap model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("shevrolette", "2015", "firstowner"));
        cars.add(new Car("shevrolette1", "2013", "secondowner"));
        cars.add(new Car("shevrolette3", "2016", "firstowner"));
        cars.add(new Car("shevrolette3", "2016", "firstowner"));
        cars.add(new Car("shevrolette5", "2016", "firstowner"));

        try {
            cars = count < 5 ? new ArrayList<>(cars.subList(0, count)) : cars;
        } catch (IllegalArgumentException ignored) {}

        model.addAttribute("cars", cars);
        return "cars";
    }
}
