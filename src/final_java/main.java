package final_java;

//main class
public class main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                javax.swing.JFrame f = new MainForm();
                f.setVisible(true);
                f.setLocationRelativeTo(null); //center form in the screen
            }
        });
    }
    
}
