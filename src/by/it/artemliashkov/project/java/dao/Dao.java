package by.it.artemliashkov.project.java.dao;


public class Dao {
    private static Dao dao;

    public AgentDao agent;
    public CompanyDao company;
    public RoleDao role;

    private Dao() {
    }

    public static Dao getDAO() {
        if (dao == null) {
            synchronized (Dao.class) {
                if (dao == null) {
                    dao = new Dao();
                    dao.agent = new AgentDao();
                    dao.company = new CompanyDao();
                    dao.role = new RoleDao();
                }
            }
        }
        return dao;
    }

    public void reset() {
        Reset.main(new String[0]);
    }
}
