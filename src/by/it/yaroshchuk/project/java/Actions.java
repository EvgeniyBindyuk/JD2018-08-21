package by.it.yaroshchuk.project.java;

public enum Actions {

    INDEX {
        {
            this.jsp = "/index.jsp";
        }
    },LOGIN {
        {
            this.jsp = "/login.jsp";
        }
    },LOGOUT {
        {
            this.jsp = "/logout.jsp";
        }
    },SIGNUP {
        {
            this.jsp = "/signup.jsp";
        }
    };

    public String jsp="/error.jasp";
}
