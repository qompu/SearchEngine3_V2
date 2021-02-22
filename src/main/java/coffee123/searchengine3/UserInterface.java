/*
 * Search Engine
 * COP 2805C (Java II) Project
 * Team: Coffee123: Adriel Lopez, Manuel Tamayo
 * TO DO: Maintanace UI
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
    
  public static void main(String[] args)  {
      
  Frame fr=new Frame("Search Engine :: Team: Coffee123");

  fr.setSize(800,500);

  fr.setVisible(true);
  // Close window on x
  fr.addWindowListener(new WindowAdapter(){
  @Override
  public void windowClosing(WindowEvent e){
  System.exit(0);
  }
  });
  
  Panel p = new Panel();
  Panel p1 = new Panel();
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
 // Label lblBlank2 = new Label("");
  TextField txtResults = new TextField(30);
  
  
  // Top panel  
  p.setLayout(new GridLayout(7,2));  // 7 rows 2 columns
  p.add(lblSeachEngine);  p.add(lblLabel1);
  p.add(lblSearchTerms);  p.add(txtSearchTerms);
  p.add(lblAllTerms);  p.add(checkBox1);
  p.add(lblAnyTerms);  p.add(checkBox2);
  p.add(lblExactTerms);  p.add(checkBox3);
  Button Search=new Button("Search");
  p.add(Search);  p.add(lblBlank1); 
  p.add(lblResults); p.add(txtResults);
  
  p1.add(p);
  fr.add(p1,BorderLayout.NORTH);   

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
            Frame fr2=new Frame("Maintanace");
            
            fr2.setSize(300,300);
            
            fr2.setVisible(true);
            Label label_one;
            //diplays Success! label
            label_one = new Label("Success!!");
            label_one.setBounds(130,100,150,50);
            fr2.add(label_one);
            fr2.setLayout(null);
            fr2.setVisible(true);
            
            
            // disposes of window on x
            fr2.addWindowListener(new WindowAdapter(){
                ;
                    
                    @Override
                    public void windowClosing(WindowEvent e){
                        fr2.dispose(); 
                    }
                    
            });
  });
 
  
  
  // Set Bold Text for Labels
  Font BoldFont = new Font("Serif",Font.BOLD,12);
  lblSeachEngine.setFont(BoldFont);
  lblLabel1.setFont(BoldFont);
       
}
}
