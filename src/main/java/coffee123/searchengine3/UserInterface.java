/*
 * Search Engine.
 * COP 2805C (Java II) Project
 * Team: Coffee123: Adriel Lopez, Manuel Tamayo
 */
package coffee123.searchengine3;

import java.awt.*;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import java.awt.event.*;

/**
 *
 * @author Team: Coffee123: Adriel Lopez, Manuel Tamayo
 */
public class UserInterface {
    

  // Display User Interface Method
  void displayUI() {
      
  Frame fr=new Frame("Search Engine :: Team: Coffee123");

  fr.setSize(800,500);
  fr.setVisible(true);
  fr.setLocationRelativeTo(null); // center the frame
  // Close window on x
  fr.addWindowListener(new WindowAdapter(){
  @Override
  public void windowClosing(WindowEvent e){
  System.exit(0);
  }
  });
  
  Panel p = new Panel();
  Panel p1 = new Panel();
  Panel p2 = new Panel();
  Panel p3 = new Panel();
 
  Label lblSeachEngine =new Label("COFFEE123 SEARCH ENGINE");
  Label lblLabel1 =new Label("");
  Label lblSearchTerms = new Label("Search Terms:");
  TextField txtSearchTerms = new TextField(20);
  Label lblAllTerms =new Label("All of the Search terms");
  Label lblAnyTerms =new Label("Any of the Search terms");
  Label lblExactTerms =new Label("Exact Phrase");
  CheckboxGroup cbg = new CheckboxGroup();  
  Checkbox checkBox1 = new Checkbox("", cbg, true);   
  Checkbox checkBox2 = new Checkbox("", cbg, false);
  Checkbox checkBox3 = new Checkbox("", cbg, false);
  Label lblResults = new Label("Results");
  Label lblBlank1 = new Label("");

  
  
  // Top panel  
  p.setLayout(new GridLayout(7,2));  // 7 rows 2 columns
  p.add(lblSeachEngine);  p.add(lblLabel1);
  p.add(lblSearchTerms);  p.add(txtSearchTerms);
  p.add(lblAllTerms);  p.add(checkBox1);
  p.add(lblAnyTerms);  p.add(checkBox2);
  p.add(lblExactTerms);  p.add(checkBox3);
  Button Search=new Button("Search");
  p.add(Search);  p.add(lblBlank1); 
  p.add(lblResults); // p.add(txtResults);
  TextArea OutText = new TextArea(10,65); // Output area
  
  p1.add(p);
  fr.add(p1,BorderLayout.NORTH);   
  
  // Left panel
  p2.add(lblResults);
  p2.add(OutText);
  fr.add(p2,BorderLayout.WEST); 

 // Bottom panel
  Button Maintenance = new Button("Maintenance");
  p3.add(Maintenance);
  Label lblNumOfFiles = new Label("Number of Files Indexed = 0");
  p3.add(lblNumOfFiles);
  Button About = new Button("About");
  p3.add(About);
  fr.add(p3,BorderLayout.SOUTH); 
  
 
  ///maintenance panel
  Maintenance.addActionListener((ActionEvent e) -> {
            Frame fr2=new Frame("Maintenance");            
            fr2.setSize(600,500);            
            fr2.setVisible(true);
            
            Panel p_M = new Panel();  // NORTH
            Panel p_M2 = new Panel();  // EAST
            Panel p_M3 = new Panel();  // bottom 1
            Panel p_M4 = new Panel();  // bottom 2
            Panel p_M_Outside = new Panel(); // bottom panel

            
            Label lbl_Title =new Label("  SEARCH ENGINE - INDEX MAINTENANCE");
            Label lbl_Label1 =new Label("  ");
            Label lbl_FileName =new Label("  File Name");
            Label lbl_Status =new Label("  Status");           
            Label label_one;
            //diplays Success! label
            label_one = new Label("  Success!!");
            
            
            

            fr2.setVisible(true);
            fr2.setLocationRelativeTo(null); // center the frame
            
               // Top maintenance panel  NORTH
            p_M.setLayout(new GridLayout(2,2));  // 3 rows 2 columns
            p_M.add(lbl_Title); p_M.add(lbl_Label1);
            p_M.add(lbl_FileName); p_M.add(lbl_Status);
            fr2.add(p_M,BorderLayout.NORTH); 
            
            
              // Left panel  WEST      
            p_M2.add(label_one); //diplays Success! label
            fr2.add(p_M2,BorderLayout.WEST); 
            
             // Bottom panel
            p_M_Outside.setLayout(new GridLayout(2,3));  // 2 rows 3 columns

            Button AddFile = new Button("Add File");  
            Button Rebuild_Outofdate = new Button("Rebuild Out-of-date");
            Button RemoveSelectedFiles = new Button("Remove Selected Files"); 
            Button ResetWindows = new Button("Reset Windows");  
            Label lblNumOfFiles2 = new Label("Number of Files Indexed = 0");
            Label SEversion = new Label("Search Engine V. 1.1");
            
             //Row 1 
            p_M3.add(AddFile);
            p_M3.add(Rebuild_Outofdate);
            p_M3.add(RemoveSelectedFiles);


             // Row 2
            p_M4.add(ResetWindows);
            p_M4.add(lblNumOfFiles2);
            p_M4.add(SEversion);
           

            // Add rows to the bottom SOUTH panel
            p_M_Outside.add(p_M3); 
            p_M_Outside.add(p_M4);
            fr2.add(p_M_Outside,BorderLayout.SOUTH); 
            
            
           // Temp 
            System.out.println("Success! Maintenance button was clicked.");
            
            
            // disposes of window on x
            fr2.addWindowListener(new WindowAdapter(){
                ;
                    
                    @Override
                    public void windowClosing(WindowEvent e){
                        fr2.dispose(); 
                    }
                    
            });
              // Set Bold Text for Labels
  Font BoldFont = new Font("Serif",Font.BOLD,12);
  lblSeachEngine.setFont(BoldFont);
  lbl_Label1.setFont(BoldFont);
  lbl_Title.setFont(BoldFont);
  });
 
  
  
  // Set Bold Text for Labels
  Font BoldFont = new Font("Serif",Font.BOLD,12);
  lblSeachEngine.setFont(BoldFont);
  lblLabel1.setFont(BoldFont);
    
}
  // Search Method
  void Search(){
      
  }
  
    // About Method
  void About(){
      
  }
  
    // AddFile Method
  void AddFile(){
      
  }
  
    // Rebuild Out-of-date Method
  void Rebuild_Outofdate(){
      
  }
  
    // Remove selected files Method
  void RemoveSelectedFiles(){
      
  }
  
    // Reset Windows Method
  void ResetWindows(){
      
  }
  
      // Count Files Indexed Method
  void CountFilesIndexed(){
      
  }
  
      // Main
  public static void main(String[] args)  {
       UserInterface object = new UserInterface();
       object.displayUI();   
  }
  
}
