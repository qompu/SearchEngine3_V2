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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.lucene.queryparser.classic.ParseException;

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
  /* Checkboxes remmed out
  Label lblAllTerms =new Label("All of the Search terms");
  Label lblAnyTerms =new Label("Any of the Search terms");
  Label lblExactTerms =new Label("Exact Phrase");
  CheckboxGroup cbg = new CheckboxGroup();  
  Checkbox checkBox1 = new Checkbox("", cbg, true);   
  Checkbox checkBox2 = new Checkbox("", cbg, false);
  Checkbox checkBox3 = new Checkbox("", cbg, false);
  */
  Label lblResults = new Label("Results");
  Label lblBlank1 = new Label("");

  
  
  // Top panel  
  p.setLayout(new GridLayout(7,2));  // 7 rows 2 columns
  p.add(lblSeachEngine);  p.add(lblLabel1);
  p.add(lblSearchTerms);  p.add(txtSearchTerms);
 // p.add(lblAllTerms);  p.add(checkBox1); // Checkboxes remmed out
 // p.add(lblAnyTerms);  p.add(checkBox2); // Checkboxes remmed out
 // p.add(lblExactTerms);  p.add(checkBox3); // Checkboxes remmed out
  Button Search=new Button("Search"); 
  p.add(Search);  p.add(lblBlank1); 
  p.add(lblResults); // p.add(txtResults);
  TextArea OutText = new TextArea(10,65); // Output area
  
  OutText.append("-----SE V2-----\n by coffee123\n------------------\n"); //format for output
  
  p1.add(p);
  fr.add(p1,BorderLayout.NORTH);   
  
  // Left panel
  p2.add(lblResults);
  p2.add(OutText);
  fr.add(p2,BorderLayout.WEST); 

 // Bottom panel
  Button Maintenance = new Button("Maintenance");
  p3.add(Maintenance);
//  Label lblNumOfFiles = new Label("Number of Files Indexed = 0");
//  p3.add(lblNumOfFiles);
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

            
            
          
            fr2.setLocationRelativeTo(null); // center the frame
            
               // Top maintenance panel  NORTH
            p_M.setLayout(new GridLayout(2,2));  
            p_M.add(lbl_Title);
            fr2.add(p_M,BorderLayout.NORTH); 
            
            
              // Left panel  WEST      
  
            fr2.add(p_M2,BorderLayout.WEST); 
            
             // Bottom panel
            p_M_Outside.setLayout(new GridLayout(2,3));  

      
            Button Rebuild_Outofdate = new Button("Rebuild Out-of-date");
            Button RemoveSelectedFiles = new Button("Remove Selected Files"); 
          
            Label SEversion = new Label("Search Engine V. 2.0");
            
             //Row 1 

            p_M3.add(Rebuild_Outofdate);
            p_M3.add(RemoveSelectedFiles);


             // Row 2

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
         //   lbl_Label1.setFont(BoldFont);
            lbl_Title.setFont(BoldFont);
            

            
              // Rebuild_Outofdate Button Action Listener
            Rebuild_Outofdate.addActionListener((ActionEvent ae) -> {
            Rebuild_OutofdateMethod();
            });
            
              // RemoveSelectedFiles Button Action Listener
            RemoveSelectedFiles.addActionListener((ActionEvent ae) -> {
                try {
                    RemoveSelectedFilesMethod();
                } catch (Exception ex) {
                    Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
  
            
            
            fr2.setSize(600,500); 
            }); // END Maintenance Method
 
  // Set Bold Text for Labels
  Font BoldFont = new Font("Serif",Font.BOLD,12);
  lblSeachEngine.setFont(BoldFont);
  lblLabel1.setFont(BoldFont);
  
  // Search Button Action Listener
  Search.addActionListener((ActionEvent e) -> {
  SearchMethod(txtSearchTerms.getText(),OutText);  //Call to search box content and OutText, the output text box
  });

    // About Button Action Listener
  About.addActionListener((ActionEvent e) -> {
  AboutMethod();
  });

 fr.setVisible(true); 
    
} // displayUI() END
  
  
  
  // Search Method
  void SearchMethod(String MytxtSearchTerms,TextArea OutText) {
    // Temp 
    System.out.println("Success! Search button was clicked.");
    OutText.append("Search terms: " + MytxtSearchTerms + "\n"); //format for output
      try {
          MainFunctions.searchFolder(MytxtSearchTerms,OutText);
      } catch (Exception ex) {
          System.out.println("Index folder not found error: " + MainFunctions.DOC_DIR);
          Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
    // About Method
  void AboutMethod(){
   // Temp 
    System.out.println("Success! About button was clicked.");   
  }
  

  
    // Rebuild Out-of-date Method
  void Rebuild_OutofdateMethod(){
    
    int result = JOptionPane.showConfirmDialog(null,"Rebuild the folder index?", MainFunctions.DOC_DIR,
         JOptionPane.YES_NO_OPTION,
         JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
              // label.setText("selected: Yes");
              System.out.println("Indexing folder " + MainFunctions.INDEX_DIR);
              MainFunctions.indexFolder();
              JOptionPane.showMessageDialog(null, "The folder was indexed ","Index: " + MainFunctions.INDEX_DIR, JOptionPane.INFORMATION_MESSAGE);
               
            }else if (result == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "The folder was NOT indexed ","Index: " + MainFunctions.INDEX_DIR, JOptionPane.INFORMATION_MESSAGE);
              // label.setText("selected: No");
            }else {
                JOptionPane.showMessageDialog(null, "The folder was NOT indexed ","Index: " + MainFunctions.INDEX_DIR, JOptionPane.INFORMATION_MESSAGE);
              // label.setText("None selected");
            }
    
        
  }
  
    // Remove selected files Method
  void RemoveSelectedFilesMethod() throws ParseException, Exception{
       // Temp 
    System.out.println("Removing docs from index " + MainFunctions.INDEX_DIR);
   //  Get term from user to delete from index docs containing term
     String myString = JOptionPane.showInputDialog("Delete from index docs containing term:");
     if(myString.isEmpty() ){ // if empty 
        JOptionPane.showMessageDialog(null, "No docs were removed from the index ","Index: " + MainFunctions.INDEX_DIR, JOptionPane.INFORMATION_MESSAGE);  
    } 
     else {  // delete docs from index and diplay message
         MainFunctions.deleteEntriesFromIndexUsingQuery(myString);
         JOptionPane.showMessageDialog(null, "Docs were removed from the index ","Index: " + MainFunctions.INDEX_DIR, JOptionPane.INFORMATION_MESSAGE);
     }

  }
  

  
      // Main
  public static void main(String[] args)  {
       UserInterface object = new UserInterface();
       object.displayUI();   
  }
  
}

