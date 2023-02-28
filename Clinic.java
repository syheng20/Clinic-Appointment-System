/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package final_assignment.Assignment;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author SongYikk
 */
public class Clinic extends Home_Page{
    public void checkdata(String username, String password) throws IOException{
        boolean userfound = false;
        
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\assignment\\login.txt"))){
            
            String line;
            while ((line=br.readLine())!=null){
                String[] part = line.split(",");
                if (part.length >= 3){
                    String tempusername = part[1].trim();
                    String temppassword = part[2].trim();
                    
                    if(tempusername.equals(username) && temppassword.equals(password)){
                        userfound = true;
                        break;
                    }
                    
                }
            }
            if(userfound){
                JOptionPane.showMessageDialog(this, "Login Successful");
                User_DashBoard udb = new User_DashBoard();
                udb.setVisible(true);
                this.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(this, "Incorrect username or password");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Login_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }

