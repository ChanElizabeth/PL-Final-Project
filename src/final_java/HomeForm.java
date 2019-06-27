package final_java;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class HomeForm extends javax.swing.JFrame {

    public HomeForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelSearch = new javax.swing.JLabel();
        jLabelUpdate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Nanum Myeongjo", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("JLabelUsr");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 60, 110, 29);

        jLabel3.setFont(new java.awt.Font("Nanum Myeongjo", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Welcome,");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 60, 110, 29);

        jLabelSearch.setFont(new java.awt.Font("Nanum Myeongjo", 2, 18)); // NOI18N
        jLabelSearch.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSearch.setText("Find Soulmate");
        jLabelSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 153, 204), new java.awt.Color(255, 153, 204), new java.awt.Color(255, 255, 255)));
        jLabelSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSearchMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelSearch);
        jLabelSearch.setBounds(430, 250, 120, 30);

        jLabelUpdate.setFont(new java.awt.Font("Nanum Myeongjo", 2, 18)); // NOI18N
        jLabelUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUpdate.setText("Update Personalities");
        jLabelUpdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 153, 204), new java.awt.Color(255, 153, 204), new java.awt.Color(255, 255, 255)));
        jLabelUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelUpdateMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelUpdate);
        jLabelUpdate.setBounds(430, 300, 170, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon("/Users/elizabethchan/Documents/java/final_java/pinkback.jpg")); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-120, -150, 780, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSearchMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                javax.swing.JFrame f = new SearchForm();
                f.setVisible(true);
                f.setLocationRelativeTo(null);
            }
        });
        
        this.dispose();
    }//GEN-LAST:event_jLabelSearchMouseClicked

    private void jLabelUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelUpdateMouseClicked
        PreparedStatement ps;
        ResultSet rs;
        String usrname = jLabel1.getText();
        
        String query = "SELECT * FROM people WHERE people_user =? ";
        
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
            ps.setString(1, usrname);
            
            rs = ps.executeQuery();
            
            if (rs.next())
            {
                UpdateForm uf = new UpdateForm();
                uf.setVisible(true);
                uf.setLocationRelativeTo(null);
                uf.pack();
                uf.setSize(400, 736);
                uf.jLabelUsr.setText(usrname);
                
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Incorrect Username", "Login Failed", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelUpdateMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelUpdate;
    // End of variables declaration//GEN-END:variables
}
