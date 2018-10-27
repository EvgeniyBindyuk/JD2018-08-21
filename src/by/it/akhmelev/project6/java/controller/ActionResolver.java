package by.it.akhmelev.project6.java.controller;

import javax.servlet.http.HttpServletRequest;

public class ActionResolver {

    Action resovle(HttpServletRequest req) {
        Action result = Action.ERROR;
        String command = req.getParameter("command");
        try {
            Action action = Action.valueOf(command.toUpperCase());
            req.getServletContext().log("RESOLVE:"+action.cmd.toString());
            result = Action.valueOf(command.toUpperCase());
        } catch (IllegalArgumentException e) {
            //result = Action.ERROR;
            //message to error.jsp
        }
        return result;
    }

}
