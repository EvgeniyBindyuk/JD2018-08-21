package by.it.artemliashkov.project.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Reset {

    static String URL_DB = "jdbc:mysql://127.0.0.1:2016/mydb" +
            "?useUnicode=true&characterEncoding=UTF-8";
    static String USER_DB = "root";
    static String PASSWORD_DB = "";


    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }


        try (Connection connection =
                     DriverManager.getConnection
                             (URL_DB, USER_DB, PASSWORD_DB);
        ) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `mydb` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `mydb`.`Role` (\n" +
                            "  `Role_id` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `role` VARCHAR(45) NULL,\n" +
                            "  PRIMARY KEY (`Role_id`))\n" +
                            "ENGINE = InnoDB;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `mydb`.`Agents` (\n" +
                    "  `Agents_id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NULL,\n" +
                    "  `address` VARCHAR(45) NULL,\n" +
                    "  `Role_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`Agents_id`),\n" +
                    "  INDEX `fk_Users_Role_idx` (`Role_id` ASC),\n" +
                    "  CONSTRAINT `fk_Users_Role`\n" +
                    "    FOREIGN KEY (`Role_id`)\n" +
                    "    REFERENCES `mydb`.`Role` (`Role_id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `mydb`.`Company` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(4500) NULL,\n" +
                    "  `type` VARCHAR(200) NULL,\n" +
                    "  `amount_agents` INT NULL,\n" +
                    "  `address` VARCHAR(100) NULL,\n" +
                    "  `Agents_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_Company_Agents1_idx` (`Agents_id` ASC),\n" +
                    "  CONSTRAINT `fk_Company_Agents1`\n" +
                    "    FOREIGN KEY (`Agents_id`)\n" +
                    "    REFERENCES `mydb`.`Agents` (`Agents_id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;\n");
            statement.executeUpdate("INSERT INTO `mydb`.`Role` (`Role_id`, `role`) VALUES (DEFAULT, 'user');\n");
            statement.executeUpdate("INSERT INTO `mydb`.`Role` (`Role_id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `mydb`.`Agents` (`Agents_id`, `name`, `address`, `Role_id`) VALUES (1, 'vera', 'ostoshitskaia', 1);");
            statement.executeUpdate("INSERT INTO `mydb`.`Agents` (`Agents_id`, `name`, `address`, `Role_id`) VALUES (2, 'artem', 'gintovta', 2);");
            statement.executeUpdate("INSERT INTO `mydb`.`Company` (`id`, `name`, `type`, `amount_agents`, `address`, `Agents_id`) VALUES (DEFAULT, 'TASK', 'insurance', 3468, 'nezavisimosti', 1);");
            statement.executeUpdate("INSERT INTO `mydb`.`Company` (`id`, `name`, `type`, `amount_agents`, `address`, `Agents_id`) VALUES (DEFAULT, 'Belneftestrach', 'insurance', 579, 'masherova', 2);");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
