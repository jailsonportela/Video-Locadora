
package Principal;

import javax.swing.UIManager;
public class Main {
    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc="Look and Feel ">
        try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        new Login().setVisible(true);
    }
}
