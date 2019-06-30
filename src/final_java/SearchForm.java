package final_java;

import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class SearchForm extends javax.swing.JFrame {

    public SearchForm() {
        initComponents();
        setSize(399, 492);
    }
    
    // Resize image
    public ImageIcon ResizeImg(ResultForm rf, String imagePath, byte[] pic){
        ImageIcon myImg = null;
        
        if(imagePath != null){
            myImg = new ImageIcon(imagePath);
        }else {
            myImg = new ImageIcon(pic);
        }
        
        Image img = myImg.getImage();
        Image img2 = img.getScaledInstance(rf.lbl_img.getWidth(), rf.lbl_img.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }
    
    public ArrayList<People> getPeopleList(String gender, String age, String height, String trait1, String trait2, String trait3){
        ArrayList<People> peopleList = new ArrayList();
        String q1 = "(people_age BETWEEN ? AND ?)";
        String q2 = "(people_height BETWEEN ? AND ?)";
        String q3 = "(people_trait1 = ? OR people_trait2 = ? OR people_trait3 = ? OR people_trait1 = ? OR people_trait2 = ? OR people_trait3 = ? OR people_trait1 = ? OR people_trait2 = ? OR people_trait3 = ?)";
        String query = "SELECT * FROM people WHERE " + q1 + " AND people_gender = ? AND " + q2 + " AND " + q3;
        PreparedStatement ps;
        Statement st;
        ResultSet rst;
         try{
            ps = MyConnection.getConnection().prepareStatement(query);
            
            switch(age){
                case "15-19":
                    ps.setInt(1, 15);
                    ps.setInt(2, 19);
                    break;
                case "20-24":
                    ps.setInt(1, 20);
                    ps.setInt(2, 24);
                    break;
                case "25-29":
                    ps.setInt(1, 25);
                    ps.setInt(2, 29);
                    break;
                case "30-34":
                    ps.setInt(1, 30);
                    ps.setInt(2, 34);
                    break;
                case "35-39":
                    ps.setInt(1, 35);
                    ps.setInt(2, 39);
                    break;
                case "40-44":
                    ps.setInt(1, 40);
                    ps.setInt(2, 44);
                    break;
                case "45-49":
                    ps.setInt(1, 45);
                    ps.setInt(2, 49);
                    break;
                case "50-54":
                    ps.setInt(1, 50);
                    ps.setInt(2, 54);
                    break;
                case "55-59":
                    ps.setInt(1, 55);
                    ps.setInt(2, 59);
                    break;
                case "60+":
                    ps.setInt(1, 60);
                    ps.setInt(2, 100);
                    break;
            }
            
            ps.setString(3, gender);
            
            switch(height){
                case "145-155":
                    ps.setDouble(4, 144);
                    ps.setDouble(5, 156);
                    break;
                case "155-165":
                    ps.setDouble(4, 154);
                    ps.setDouble(5, 166);
                    break;
                case "165-175":
                    ps.setDouble(4, 164);
                    ps.setDouble(5, 176);
                    break;
                case "175-185":
                    ps.setDouble(4, 174);
                    ps.setDouble(5, 186);
                    break;
                case "185+":
                    ps.setDouble(4, 184);
                    ps.setDouble(5, 201);
                    break;
            }
            
            ps.setString(6, trait1);
            ps.setString(7, trait2);
            ps.setString(8, trait3);
            
            ps.setString(9, trait2);
            ps.setString(10, trait1);
            ps.setString(11, trait2);
            
            ps.setString(12, trait3);
            ps.setString(13, trait3);
            ps.setString(14, trait1);
            
            rst = ps.executeQuery();

            People people;
            while(rst.next()){
                people = new People(rst.getString("people_user"), rst.getString("people_pass"), rst.getString("people_name"), rst.getInt("people_age"), rst.getString("people_gender"), rst.getDouble("people_height"), rst.getString("image"), rst.getString("WhatsApp"), rst.getString("Line"), rst.getString("Instagram"), rst.getString("Twitter"), rst.getString("Facebook"), rst.getString("Snapchat"), rst.getString("people_trait1"), rst.getString("people_trait2"), rst.getString("people_trait3"));
                peopleList.add(people);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return peopleList;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jCombo_trait1 = new javax.swing.JComboBox<>();
        jCombo_trait2 = new javax.swing.JComboBox<>();
        jCombo_trait3 = new javax.swing.JComboBox<>();
        jButton_cancel = new javax.swing.JButton();
        jButton_Search_ = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(227, 238, 255));
        jPanel2.setLayout(null);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Luminari", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 51, 153));
        jLabel10.setText("Gender :");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(70, 60, 86, 22);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("female");
        jRadioButton1.setContentAreaFilled(false);
        jPanel2.add(jRadioButton1);
        jRadioButton1.setBounds(150, 60, 80, 23);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("male");
        jPanel2.add(jRadioButton2);
        jRadioButton2.setBounds(250, 60, 70, 23);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Luminari", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 51, 153));
        jLabel12.setText("Personal traits :");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(70, 210, 130, 22);

        jCombo_trait1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adventurous", "Appreciative", "Caring", "Charismatic", "Confident", "Creative", "Dedicated", "Earnest", "Exciting", "Extraordinary", "Faithful", "Flexible", "Funny", "Generous", "Honorable", "Humorous", "Kind", "Loyal", "Modest", "Observant", "Optimistic", "Organized", "Patient", "Protective", "Realistic", "Relaxed", "Sociable", "Sympathetic", "Trusting", "Warm" }));
        jPanel2.add(jCombo_trait1);
        jCombo_trait1.setBounds(150, 240, 130, 27);

        jCombo_trait2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adventurous", "Appreciative", "Caring", "Charismatic", "Confident", "Creative", "Dedicated", "Earnest", "Exciting", "Extraordinary", "Faithful", "Flexible", "Funny", "Generous", "Honorable", "Humorous", "Kind", "Loyal", "Modest", "Obeservant", "Optimistic", "Organized", "Patient", "Protective", "Realistic", "Relaxed", "Sociable", "Sympathetic", "Trusting", "Warm" }));
        jPanel2.add(jCombo_trait2);
        jCombo_trait2.setBounds(150, 280, 130, 27);

        jCombo_trait3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adventurous", "Appreciative", "Caring", "Charismatic", "Confident", "Creative", "Dedicated", "Earnest", "Exciting", "Extraordinary", "Faithful", "Flexible", "Funny", "Generous", "Honorable", "Humorous", "Kind", "Loyal", "Modest", "Obeservant", "Optimistic", "Organized", "Patient", "Protective", "Realistic", "Relaxed", "Sociable", "Sympathetic", "Trusting", "Warm" }));
        jPanel2.add(jCombo_trait3);
        jCombo_trait3.setBounds(150, 320, 130, 27);

        jButton_cancel.setBackground(new java.awt.Color(255, 82, 102));
        jButton_cancel.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jButton_cancel.setForeground(new java.awt.Color(255, 82, 102));
        jButton_cancel.setText("CANCEL");
        jButton_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_cancel);
        jButton_cancel.setBounds(70, 390, 90, 38);

        jButton_Search_.setBackground(new java.awt.Color(255, 82, 102));
        jButton_Search_.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jButton_Search_.setForeground(new java.awt.Color(255, 82, 102));
        jButton_Search_.setText("SEARCH");
        jButton_Search_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Search_ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_Search_);
        jButton_Search_.setBounds(200, 390, 104, 38);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Luminari", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 51, 153));
        jLabel8.setText("Age :");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(70, 110, 86, 22);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "15-19", "20-24", "25-29", "30-34", "35-39", "40-44", "45-49", "50-54", "55-59", "60+" }));
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(150, 110, 96, 27);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Luminari", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 51, 153));
        jLabel6.setText("Height :");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(70, 160, 86, 22);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "145-155", "155-165", "165-175", "175-185", "185+" }));
        jPanel2.add(jComboBox2);
        jComboBox2.setBounds(150, 160, 112, 27);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static ArrayList<javax.swing.JFrame> matchWindows = new ArrayList();
    
    private void jButton_Search_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Search_ActionPerformed

        String gender = null;
        if (jRadioButton1.isSelected()){
            gender = "female";
        }
        else if (jRadioButton2.isSelected()){
            gender = "male";
        }
        String age = (String) jComboBox1.getSelectedItem();
        String height = (String) jComboBox2.getSelectedItem();

        String trait1 = (String) jCombo_trait1.getSelectedItem();
        String trait2 = (String) jCombo_trait2.getSelectedItem();
        String trait3 = (String) jCombo_trait3.getSelectedItem();        

        ArrayList<People> list = getPeopleList(gender, age, height, trait1, trait2, trait3);
        System.out.print(list.size());
        if(!list.isEmpty()){
            for(int i = 0; i < list.size(); i++){
                ResultForm rf = new ResultForm();
                matchWindows.add(rf);
                rf.setVisible(true);
                rf.setLocationRelativeTo(null);
                rf.pack();
                rf.setSize(400, 725);
                rf.LabelName.setText(list.get(i).getName());
                rf.LabelAge.setText(String.valueOf(list.get(i).getAge()) + " years old");
                rf.LabelHeight.setText(String.valueOf(list.get(i).getHeight()) + " cm");
                rf.Labeltrait1.setText(list.get(i).getTrait1());
                rf.Labeltrait2.setText(list.get(i).getTrait2());
                rf.Labeltrait3.setText(list.get(i).getTrait3());
                rf.lbl_img.setIcon(ResizeImg(rf, list.get(i).getImage(), null));
                if(list.get(i).getFacebook() == null){ 
                    rf.condet1.setText("");
                }
                else { 
                    rf.condet1.setText("FB : " + list.get(i).getFacebook());
                }
                if(list.get(i).getWhatsApp() == null){ rf.condet2.setText(""); }
                else{
                    rf.condet2.setText("WA : " + list.get(i).getWhatsApp());
                }

                if(list.get(i).getLine() == null){ rf.condet3.setText(""); }
                else{
                    rf.condet3.setText("Line : " + list.get(i).getLine());
                }

                if(list.get(i).getInstagram() == null){ rf.condet4.setText(""); }
                else{
                    rf.condet4.setText("IG : " + list.get(i).getInstagram());
                }

                if(list.get(i).getTwitter() == null){ rf.condet5.setText(""); }
                else{
                    rf.condet5.setText("Twitter : " + list.get(i).getTwitter());
                }

                if(list.get(i).getSnapchat() == null){ rf.condet6.setText(""); }
                else{
                    rf.condet6.setText("SC : " + list.get(i).getSnapchat());
                }   
            }
        }
        else{
            javax.swing.JFrame f = new SorryForm();
            f.setVisible(true);
            f.setLocationRelativeTo(null);
            f.setSize(399, 300);
        }

        this.dispose();
    }//GEN-LAST:event_jButton_Search_ActionPerformed
        
    private void jButton_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelActionPerformed
        javax.swing.JFrame f = new LoginForm();
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setSize(400, 315);
        
        this.dispose();
    }//GEN-LAST:event_jButton_cancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton_Search_;
    private javax.swing.JButton jButton_cancel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jCombo_trait1;
    private javax.swing.JComboBox<String> jCombo_trait2;
    private javax.swing.JComboBox<String> jCombo_trait3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    // End of variables declaration//GEN-END:variables
}
