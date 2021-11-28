package services;

import dataaccess.UserDB;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

public class AccountService {
    
    public User login(String email, String password, String path) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", email);
                
                //Simple plain text email
                GmailService.sendMail(email, "New Login to Notes App", "User has logged in", false);
                

                String to = user.getEmail();
                String subject = "Notes App Login";
                String template = path + "/emailtemplates/login.html";
                
                HashMap<String, String> tags = new HashMap<>();
                tags.put("firstname", user.getFirstName());
                tags.put("lastname", user.getLastName());
                tags.put("date", (new java.util.Date()).toString());
                
                GmailService.sendMail(to, subject, template, tags);

                return user;
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public boolean forgotPassword(String email, String path) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", email);
                

                String to = user.getEmail();
                String subject = "Forgotten Password";
                String template = path + "/emailtemplates/forgotPassword.html";
                
                HashMap<String, String> tags = new HashMap<>();
                tags.put("firstname", user.getFirstName());
                tags.put("lastname", user.getLastName());
                tags.put("email", user.getEmail());
                tags.put("password", user.getPassword());
                
                GmailService.sendMail(to, subject, template, tags);

                return true;
            
        } catch (Exception e) {
        }
        
        return false;
    }
}
