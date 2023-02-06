package Control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConfigDatabase {
    
    private Connexion connexion = new Connexion();
    private Connection conn = this.connexion.getConnexion();
    private FileInputStream fis = null;
    
    public void dbClose(Connection conn, PreparedStatement stmt, ResultSet resultset) {

        if (resultset != null) try {

            resultset.close();

        } catch (SQLException erro) {
            
            System.out.println("ERROR : " + erro.getMessage());
            
        }

        if (stmt != null) try {

            stmt.close();

        } catch (SQLException erro) {

            System.out.println("ERROR : " + erro.getMessage());

        }

        if (conn != null) try {
            
            conn.close();
            
        } catch (SQLException erro) {
            
            System.out.println("ERROR : " + erro.getMessage());
            
        }

    }
    
    public void insertUser(User user) {

        String sql = "INSERT INTO user ( u_username, u_email, u_password, status ) VALUES ( ?, ?, ?, ?)";

        try {

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getStatus());
            stmt.execute();


        } catch (SQLException erro) {

            System.out.println("ERROR : " + erro.getMessage());

        }   finally {
   
            dbClose(conn, null, null);

        }

    }
    
        public void insertMusic(Music music) throws FileNotFoundException {

        String sql = "INSERT INTO music ( m_name, m_duration, m_banner, m_music) VALUES ( ?, ?, ?, ? )";

        try {

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, music.getName());
            stmt.setInt(2, music.getDuration());
            File image = new File("imagem.jpg");
            fis = new FileInputStream(image);
            stmt.setBinaryStream(3, fis, (int) image.length());
            File audio = new File("musica.mp3");
            fis = new FileInputStream(audio);
            stmt.setBinaryStream(3, fis, (int) audio.length());
            stmt.execute();


        } catch (SQLException | FileNotFoundException erro) {

            System.out.println("ERROR : " + erro.getMessage());

        }   finally {
   
            dbClose(conn, null, null);

        }

    }

    public void editUser(User user) {

        String sql = "UPDATE user SET username = ?, email = ?, passsword = ? WHERE id = ?";
        
        try {
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.execute();
            
        } catch (SQLException erro) {
            
            System.out.println("ERROR : " + erro.getMessage());
            
        } finally {

            dbClose(conn, null, null);

        }

    }
    
    public void editMusic(Music music) {

        String sql = "UPDATE music SET  m_name = ?, m_duration = ?, m_banner = ?, m_music = ? WHERE id = ?";

        try {

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, music.getName());
            stmt.setInt(2, music.getDuration());
            File image = new File("imagem.jpg");
            fis = new FileInputStream(image);
            stmt.setBinaryStream(3, fis, (int) image.length());
            File audio = new File("musica.mp3");
            fis = new FileInputStream(audio);
            stmt.setBinaryStream(3, fis, (int) audio.length());
            stmt.execute();


        } catch (SQLException | FileNotFoundException erro) {

            System.out.println("ERROR : " + erro.getMessage());

        }   finally {
   
            dbClose(conn, null, null);

        }

    }

    public void deleteUser(int u_id) {

        String sql = "UPDATE user SET u_status = 'del' WHERE u_id = ?";

        try {

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, u_id);
            stmt.execute();

        } catch (SQLException erro) {

            System.out.println("ERROR : " + erro.getMessage());

        } finally {
   
            dbClose(conn, null, null);

        }

    }
    
        public void deleteMusic(int m_id) {

        String sql = "DELETE FROM music WHERE m_id = ?";
        
        try {
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, m_id);
            stmt.execute();
            
        } catch (SQLException erro) {
            
            System.out.println("ERROR : " + erro.getMessage());
            
        }

    }
        
    public List<User> getUser() {
        
        String sql = "SELECT * FROM user";
    
        try {
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery();
            List<User> listUser = new ArrayList<>();
            
            while (resultset.next()) {
                
                User user = new User();
                user.setId(resultset.getInt("u_id"));
                user.setUsername(resultset.getString("u_username"));
                user.setEmail(resultset.getString("u_email"));
                user.setPassword(resultset.getString("u_password"));
                listUser.add(user);
                
            }
            
            return listUser;
            
        } catch (SQLException erro) {
            
            System.out.println("ERROR : " + erro.getMessage());
            
            return null;
            
        }
    
    }

}