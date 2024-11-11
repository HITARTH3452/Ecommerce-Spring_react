package service;

import model.User;
import repository.UserRepository;

public class UserService {
    public static User saveUser(User user) {
        UserRepository.save(user);
    }

    public boolean authenticate(String username, String passsword) {
    }
}
