package thankous.eshopAppbackend.services;

import thankous.eshopAppbackend.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(long id);
    User saveUser(User user);
    void deleteAllUsers();
    void deleteUserById(long id);
    User updateUser(User user, long id);
}
