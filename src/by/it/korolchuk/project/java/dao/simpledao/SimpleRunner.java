package by.it.korolchuk.project.java.dao.simpledao;


import by.it.korolchuk.project.java.dao.beans.Ad;
import by.it.korolchuk.project.java.dao.beans.Role;
import by.it.korolchuk.project.java.dao.beans.User;

import java.sql.SQLException;

public class SimpleRunner {


    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.INSTANCE;

        User user = new User(0, "UserDao", "UserDao", "UserDao@user.ru", 2);
        if (dao.user.create(user))
            System.out.println("CREATE:\n" + dao.user.getAll());
        user = dao.user.read(user.getId());
        user.setLogin("uuuuuu");
        if (dao.user.update(user))
            System.out.println("UPDATE:\n" + dao.user.getAll());
        if (dao.user.delete(user))
            System.out.println("DELETE:\n" + dao.user.getAll());

        Role role = new Role(0, "RoleDao");
        if (dao.role.create(role))
            System.out.println("CREATE:\n" + dao.role.getAll());
        role = dao.role.read(role.getId());
        role.setRole("rrrrrrr");
        if (dao.role.update(role))
            System.out.println("UPDATE:\n" + dao.role.getAll());
        if (dao.role.delete(role))
            System.out.println("DELETE:\n" + dao.role.getAll());

        Ad ad = new Ad();
        ad.setDescription("ad dao test ad dao test ad dao test ");
        ad.setUsersId(2);
        if (dao.ad.create(ad))
            System.out.println("CREATE:\n" + dao.ad.getAll());
        ad = dao.ad.read(ad.getId());
        ad.setDescription("ddddddd");
        if (dao.ad.update(ad))
            System.out.println("UPDATE:\n" + dao.ad.getAll());
        if (dao.ad.delete(ad))
            System.out.println("DELETE:" + dao.ad.getAll());
    }
}