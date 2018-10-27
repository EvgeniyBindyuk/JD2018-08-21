package by.it.nesterovich.project.java;

import by.it.nesterovich.project.java.cmd.*;

public enum Action {

    INDEX {{
        cmd = new CmdIndex();
    }},
    LOGIN {{
        cmd = new CmdLogin();
    }},
    RESET {{
        cmd = new CmdReset();
    }},
    SIGNUP {{
        cmd = new CmdSignUp();
    }},
    LISTFILM {{
        cmd = new CmdListFilm();
    }},
    LISTCINEMA {{
        cmd = new CmdListCinema();
    }},
    USERCABINET {{
        cmd = new CmdUserCabinet();
    }},
    USERINFO {{
        cmd = new CmdUserInfo();
    }},
    RESERVEDTICKET {{
        cmd = new CmdReservedTicket();
    }},
    ERROR {{
        cmd = new CmdError();
    }};

    public String getJsp() {
        return "/" + this.cmd.toString().toLowerCase() + ".jsp";
    }

    public Cmd cmd = new CmdError();

}
