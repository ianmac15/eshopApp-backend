package thankous.eshopAppbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import thankous.eshopAppbackend.exceptions.ResourceNotFoundException;
import thankous.eshopAppbackend.models.User;
import thankous.eshopAppbackend.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new ResourceNotFoundException("User with id: "+id+", doesn't exist!");
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public void deleteUserById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
        }
        throw new ResourceNotFoundException("User with id: "+id+", doesn't exist!");
    }

    @Override
    public User updateUser(User oldUser, long id) {
            User newUser = getUserById(id);
            newUser.setRoles(oldUser.getRoles());
            newUser.setCart(oldUser.getCart());
            newUser.setEmail(oldUser.getEmail());
            newUser.setUsername(oldUser.getUsername());
            newUser.setPassword(oldUser.getPassword());
            return newUser;
    }
}
