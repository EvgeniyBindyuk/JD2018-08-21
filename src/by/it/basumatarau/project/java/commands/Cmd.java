package by.it.basumatarau.project.java.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;


public abstract class Cmd {

    public abstract Cmd execute(HttpServletRequest request, HttpServletResponse response) throws SQLException;

    @Override
    public String toString() {

        return this.getClass().getSimpleName().replaceAll("Cmd","");

    }
}
