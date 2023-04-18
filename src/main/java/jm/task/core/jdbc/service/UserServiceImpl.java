package jm.task.core.jdbc.service;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao udJBCi = new UserDaoJDBCImpl();

    public void createUsersTable() {
        udJBCi.createUsersTable();
    }

    public void dropUsersTable() {
        udJBCi.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        udJBCi.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        udJBCi.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return udJBCi.getAllUsers();
    }

    public void cleanUsersTable() {
        udJBCi.cleanUsersTable();
    }
}
