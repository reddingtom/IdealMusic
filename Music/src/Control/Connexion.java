/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Programador.carioca
 */
public class Connexion {
    
    public Connection getConnexion () {
    
        try {
            
            Connection conn = DriverManager.getConnection(
            
                    // Alterar para "jdbc:sqlite:src/resources/Account.db"
                    
                    "jdbc:mysql://localhost:3306/account?user=root&password="
            
            );
            
            return conn;
            
        } catch (SQLException erro) {
            
            System.out.println("ERROR : " + erro.getMessage());
            return null;
            
        }
    
    }
    
}
