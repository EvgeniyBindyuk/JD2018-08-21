package by.it.artemliashkov.project.java.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdError extends Cmd{

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
}