
package Principal.funcoes;

import DAO.FuncionarioDAO;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Jailson Portela
 */
public interface Funcoes{
    public default void resolucaoPadrao(JFrame frame){
        String funcionario_nome=new FuncionarioDAO().funcionarioAtual();
        frame.setTitle("Video Locadora - "+funcionario_nome);
        frame.setPreferredSize(new Dimension(800,450));
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setSize(800,450);
        frame.setLocationRelativeTo(null);
    }
        public default void JPanelPadrao(JPanel panel){
            panel.setBackground(new Color(95,103,105));
       panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(202, 191, 171), 10),
               BorderFactory.createBevelBorder(BevelBorder.RAISED)));
    }
    public default void apagarCampos(JTextField...fields){
        for(JTextField txt:fields)txt.setText("");
    }
    public default void transita(JFrame from,JFrame to){
        from.dispose();
        to.setVisible(true);
    }
    
}
