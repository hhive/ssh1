package dao;

import model.User;

public interface UserDao {
    public User validate(String username, String password);
}
