package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
//        UserServiceImpl usi = new UserServiceImpl();
        UserDaoHibernateImpl u = new UserDaoHibernateImpl();
//        usi.createUsersTable();
//        usi.saveUser("Vladimir","Ugryumov", (byte) 18);
//        usi.saveUser("Ivan","Strunov", (byte) 19);
//        usi.saveUser("David","Ovechkin", (byte) 20);
//        usi.saveUser("Ignat","Vasilyev", (byte) 21);
//        usi.getAllUsers().forEach(System.out::println);
//        usi.cleanUsersTable();
//        usi.dropUsersTable();
        u.createUsersTable();
        u.saveUser("Ivan","Strunov", (byte) 19);
        u.saveUser("Vladimir","Ugryumov", (byte) 19);
        u.saveUser("Ignat","Vasilyev", (byte) 21);
        u.saveUser("David","Ovechkin", (byte) 20);
        u.getAllUsers().forEach(System.out::println);
        u.cleanUsersTable();
        u.dropUsersTable();
    }
}
