
package Principal.funcoes;

import DAO.FuncionarioDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.BevelBorder;

public interface Funcoes{
    //Resolução padrão JFrames
    public default void resolucaoPadrao(JFrame frame){
        String funcionario_nome=new FuncionarioDAO().funcionarioAtual();
        frame.setTitle("Video Locadora - "+funcionario_nome);
        frame.setPreferredSize(new Dimension(800,450));
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setSize(800,450);
        frame.setLocationRelativeTo(null);
    }
    //estética padrao de JPanel
        public default void JPanelPadrao(JPanel panel){
            panel.setBackground(new Color(95,103,105));
       panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(202, 191, 171), 10),
               BorderFactory.createBevelBorder(BevelBorder.RAISED)));
    }
    //apaga campos (Superclasse JTextField ou classes filhas)
    public default void apagarCampos(JTextField...fields){
        for(JTextField txt:fields)txt.setText("");
    }
    //Transita entre JFrames
    public default void transita(JFrame from,JFrame to){
        from.dispose();
        to.setVisible(true);
    }
}
