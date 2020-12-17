
package Principal.funcoes;

import DAO.FuncionarioDAO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.BevelBorder;

public interface Funcoes{
    Color cabfab=new Color(202,191,171);
    Color back=new Color(95,103,105);
    Color button_back=new Color(65,68,75);
    //Resolução padrão JFrames
    public default void resolucaoPadrao(JFrame frame){
        String funcionario_nome=new FuncionarioDAO().funcionarioAtual();
        frame.setTitle("Video Locadora - "+funcionario_nome);
        frame.setPreferredSize(new Dimension(800,450));
        frame.setDefaultCloseOperation(2);
        frame.setSize(800,450);
        frame.setLocationRelativeTo(null);
    }
    //estética padrao de JPanel
        public default JPanel JPanelPadrao(){
          JPanel panel=new JPanel();
          panel.setBackground(back);
          panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(cabfab, 10),
          BorderFactory.createBevelBorder(BevelBorder.RAISED)));
       return panel;
    }
    //apaga campos (Superclasse JTextField ou classes filhas)
    public default void apagarCampos(JTextField...fields){
        for(JTextField txt:fields)txt.setText("");
    }
    //estética jbutton padrão
    public default JButton jbuttonPadrao(String nome){
        JButton button=new JButton();
        button.setFont(new Font("Arial Black",0,14));
        button.setBorderPainted(true);
        button.setBorder(BorderFactory.createLineBorder(button_back));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBackground(button_back);
        button.setForeground(cabfab);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setIconTextGap(5);
        button.setText(nome);
        button.setFocusPainted(true);
        
        return button;
    }
    //<editor-fold desc="estética campos padrão">
    public default JTextField jTextFieldPadrao(){
        JTextField field=new JTextField();
        field.setCaretColor(cabfab);
        field.setForeground(cabfab);
        field.setBorder(BorderFactory.createMatteBorder(0,0,2,0,cabfab));
        field.setFont(new Font("Arial",0,14));
        field.setBackground(back);
                return field;
    }
    public default JPasswordField jPasswordPadrao(){
        JPasswordField field=new JPasswordField();
        field.setCaretColor(cabfab);
        field.setForeground(cabfab);
        field.setBorder(BorderFactory.createMatteBorder(0,0,2,0,cabfab));
        field.setFont(new Font("Arial",0,14));
        field.setBackground(back);
                return field;
    }
        public default JFormattedTextField jJFormattedTextFieldPadrao(){
        JFormattedTextField field=new JFormattedTextField();
        field.setCaretColor(cabfab);
        field.setForeground(cabfab);
        field.setBorder(BorderFactory.createMatteBorder(0,0,2,0,cabfab));
        field.setFont(new Font("Arial",0,14));
        field.setBackground(back);
                return field;
    }
    //</editor-fold>
    //Transita entre JFrames
    public default void transita(JFrame from,JFrame to){
        from.dispose();
        to.setVisible(true);
    }
}
