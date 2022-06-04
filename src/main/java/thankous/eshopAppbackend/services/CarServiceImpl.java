package thankous.eshopAppbackend.services;

import com.ianmac.webapp3.exceptions.ResourceNotFoundException;
import com.ianmac.webapp3.model.Car;
import com.ianmac.webapp3.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

//    @Autowired
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car saveCar(Car car) {

        return carRepository.save(car);

    }

    @Override
    public Car getCarById(long id) {

//        if (id.equals(null)) {
//            throw new InvalidInputException("Id is not valid!. Id must be a number!");
//        }
        Optional<Car> carToFind = carRepository.findById(id);
        Car car;
//        Car car1 = carRepository.findById(id);
//        return new ResponseEntity<>(car1, HttpStatus.OK);
        if (carToFind.isPresent()) {
            car = carToFind.get();
            return car;
        } else {
            throw new ResourceNotFoundException("Car with id: " + id + ", not found");
////            return new ResponseEntity<>(new RuntimeException(), HttpStatus.NOT_FOUND);
////            throw new ResourceNotFoundException("Car wasn't found");
        }
//        return car;
    }

    @Override
    public void deleteCarById(long id) {



        Optional<Car> car = carRepository.findById(id);

        if (car.isPresent()) {
            carRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Car with id: " + id + ", not found");
        }

    }

    @Override
    public void deleteAllCars() {
        carRepository.deleteAll();
    }

    @Override
    public Car updateCar(long id, Car car) {
        Car car1 = getCarById(id);
        car1.setBrand(car.getBrand());
        car1.setModel(car.getModel());
        car1.setColour(car.getColour());
        return carRepository.save(car1);
    }
}
