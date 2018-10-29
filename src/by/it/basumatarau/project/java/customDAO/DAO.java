package by.it.basumatarau.project.java.customDAO;

import by.it.basumatarau.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

    private static DAO dao;

    public RoleDAO role;
    public UserDAO user;
    public VenueDAO venue;
    public PlaceDAO place;

    public static DAO getDAO(){
        if(dao==null){
            synchronized (DAO.class){
                if (dao==null){
                    dao = new DAO();
                    dao.role = new RoleDAO();
                    dao.user = new UserDAO();
                    dao.venue = new VenueDAO();
                    dao.place = new PlaceDAO();
                }
            }
        }
        return dao;
    }

    long executeUpdate(String sqlStatement) throws SQLException {
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ){

            if(sqlStatement.toLowerCase().matches("^\\s*insert.*")) {
                if (statement.executeUpdate(sqlStatement, Statement.RETURN_GENERATED_KEYS) == 1) {
                    ResultSet generatedKeys = statement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        return generatedKeys.getLong(1);
                    }
                }
            }else{
                return statement.executeUpdate(sqlStatement);
            }
        }
        return -1;
    }
}
