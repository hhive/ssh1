package service.serviceImp;

import dao.UserDao;
import dao.daoImp.UserDaoImp;
import model.User;
import service.UserService;

public class UserServiceImp implements UserService {
    private UserDao userDao;
    public User validateUser(String username, String password) {
        return userDao.validate(username,password);
    }
    public User registerUser(User user) {
        userDao.saveUser(user);
        return validateUser(user.getUsername(),user.getPassword());
    }
}
