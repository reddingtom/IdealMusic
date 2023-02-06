/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

public class User {
    
    private int u_id;
    private String u_username;
    private String u_email;
    private String u_password;
    private String u_status;
    
    
    public int getId() {
        return u_id;
    }

    public void setId(int id) {
        this.u_id = id;
    }

    public String getUsername() {
        return u_username;
    }

    public void setUsername(String username) {
        this.u_username = username;
    }

    public String getEmail() {
        return u_email;
    }

    public void setEmail(String email) {
        this.u_email = email;
    }

    public String getPassword() {
        return u_password;
    }

    public void setPassword(String password) {
        this.u_password = password;
    }

    public String getStatus() {
        return u_status;
    }

    public void setStatus(String status) {
        this.u_status = status;
    }
    
}
