package by.it.artemliashkov.project.java.cmd;

import by.it.artemliashkov.project.java.beans.Company;
import by.it.artemliashkov.project.java.dao.Dao;
import by.it.artemliashkov.project.java.utils.Form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CmdIndex extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (Form.isGet(req)) {
            Dao dao = Dao.getDAO();

            List<Company> companies = dao.company.getAll("");
            if (companies.size() > 0) {
                req.setAttribute("companies", companies);
            }
        }
        return null;
    }
}
