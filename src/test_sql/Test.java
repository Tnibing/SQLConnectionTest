package test_sql;

import java.sql.*;

/**
 *
 * @author Fran <6W>
 * 
 */

public class Test {
    public static void main(String[] args) {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/all_f1_final", "uName!!", "psswd!!");
            
            Statement st = conn.createStatement();
            
            String query = "SELECT * FROM log_movimientos_gp;";
            
            ResultSet rs = st.executeQuery(query);
            
            StringBuilder resultado = new StringBuilder();

            while (rs.next()) {
                resultado.append("Operación: ").append(rs.getString("operacion")).append("\nPremio: ").append(rs.getString("nombre_GP")).append("\n\n");
            }
            
            System.out.println(resultado.toString());
            
            rs.close();
            st.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
