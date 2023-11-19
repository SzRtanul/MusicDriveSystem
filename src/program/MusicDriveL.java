/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author SzabóRoland(SZOFT_20
 */
public class MusicDriveL {
    
    public static void Save(String FileName, List<String> items){
        File f = new File(FileName);
        Writer fileWriter;
        try {
            fileWriter = new OutputStreamWriter(new FileOutputStream(FileName), StandardCharsets.UTF_8);
            PrintWriter pn = new PrintWriter(fileWriter);
            for (String item : items){
                pn.println(item);
                pn.flush();
            }
            pn.close();
        } catch (IOException ex) {
            Logger.getLogger(MusicDriveL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List Load(String FileName)/* throws FileNotFoundException */{
        File f = new File(FileName);
        List<String> items = new ArrayList<String>();
        try(Scanner sc = new Scanner(f)){
            while(sc.hasNextLine()){
                String a = sc.nextLine();
                items.add(a);
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(MusicDriveL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return items;
    }
}
