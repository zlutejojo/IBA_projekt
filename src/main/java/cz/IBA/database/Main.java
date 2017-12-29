package cz.IBA.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbcDriver");
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:student","ja","heslo");

//      slouzi k provadeni SQL dotazu
        Statement st = conn.createStatement();

        String createTable = "CREATE TABLE mazlici (id integer, jmeno varchar(100), druh varchar(50), vek integer)";
        String insertRow1 = "INSERT INTO mazlici (id, jmeno, druh, vek) VALUES (1, 'Bublinka', 'kocka', 3)";
        String insertRow2 = "INSERT INTO mazlici (id, jmeno, druh, vek) VALUES (2, 'Ben', 'pes', 10)";
        String select = "SELECT * FROM mazlici WHERE jmeno='Bublinka'";

        st.executeUpdate(createTable);

        st.executeUpdate(insertRow1);
        st.executeUpdate(insertRow2);

        ResultSet rs = st.executeQuery(select);

        while(rs.next()) {
            System.out.println("Jmeno " + rs.getString(2) + " vek " + rs.getInt(4));
        }




//       toto cele udelat s try-catch-finally, aby bylo mozne zavrit spojeni v kazdem pripade: conn.close


    }

}
