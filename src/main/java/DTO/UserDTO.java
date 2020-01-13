/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;
import java.util.HashSet;
import java.util.Set;
import entities.User;

/**
 *
 * @author ahmed
 */
public class UserDTO {
    private String userName;
    private String mail;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.userName = user.getUserName();
    }

    public String getUserName() {
        return userName;
    }

    public String getMail() {
        return mail;
    }
    
    
    
    
}
