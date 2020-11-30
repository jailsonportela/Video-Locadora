package visao.consultar;

import DAO.ClienteDAO;
import DAO.Conexao;
import Modelo.Cliente;
import Principal.Menu;
import Principal.funcoes.Funcoes;
import java.sql.Connection;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class ConsulCliente extends JFrame implements Funcoes{
    public ConsulCliente() {
        resolucaoPadrao(this);
        initComponents();
        atualizaTable();
    }
    private void preencherTable(Connection con,List<Cliente>lista){
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        int i=0;
        for(Cliente c:lista){
            model.addRow(new Object[i]);
            jTable1.setValueAt(c.getCodigo(), i, 0);
            jTable1.setValueAt(c.getNome(), i, 1);
            jTable1.setValueAt(c.getRG(), i, 2);
            jTable1.setValueAt(c.getCPF(), i, 3);
            jTable1.setValueAt(c.getTelefone(), i, 4);
            jTable1.setValueAt(c.getEmail(), i, 5);
            i++;
        }
        Conexao.fecharConexao(con);
    }
    private void atualizaTable(){
            ClienteDAO sql=new ClienteDAO();
            preencherTable(sql.getCon(),sql.listar_clientes());
    }
        private void atualizaTable_PesquisaCodigo(int codigo){
            ClienteDAO sql=new ClienteDAO();
            preencherTable(sql.getCon(),sql.pegarPorCodigo(codigo));
    }
        private void atualizaTable_PesquisaNome(String nome){
            ClienteDAO sql=new ClienteDAO();
            preencherTable(sql.getCon(),sql.pegarPorNome(nome));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtPesquisarCodigoCliente = new javax.swing.JFormattedTextField();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        txtPesquisarNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(95, 103, 105));
        panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setBackground(new java.awt.Color(65, 68, 75));
        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(202, 191, 171));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cliente", "RG", "CPF", "Telefone", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(202, 191, 171));
        jTable1.setSelectionBackground(new java.awt.Color(202, 191, 171));
        jTable1.setSelectionForeground(new java.awt.Color(65, 68, 75));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(202, 191, 171));
        jLabel1.setText("Pesquisar por nome:");

        jButton5.setBackground(new java.awt.Color(65, 68, 75));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/loupe.png"))); // NOI18N
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusPainted(false);
        jButton5.setOpaque(true);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(65, 68, 75));
        jButton6.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(202, 191, 171));
        jButton6.setText("Todos");
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusPainted(false);
        jButton6.setOpaque(true);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(202, 191, 171));
        jLabel13.setText("Pesquisar por Código:");

        txtPesquisarCodigoCliente.setBackground(new java.awt.Color(95, 103, 105));
        txtPesquisarCodigoCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(202, 191, 171)));
        txtPesquisarCodigoCliente.setForeground(new java.awt.Color(202, 191, 171));
        txtPesquisarCodigoCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtPesquisarCodigoCliente.setCaretColor(new java.awt.Color(202, 191, 171));
        txtPesquisarCodigoCliente.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jButton8.setBackground(new java.awt.Color(65, 68, 75));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/loupe.png"))); // NOI18N
        jButton8.setContentAreaFilled(false);
        jButton8.setFocusPainted(false);
        jButton8.setOpaque(true);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(65, 68, 75));
        jButton7.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(202, 191, 171));
        jButton7.setText("Cancelar");
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusPainted(false);
        jButton7.setOpaque(true);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        txtPesquisarNome.setBackground(new java.awt.Color(95, 103, 105));
        txtPesquisarNome.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtPesquisarNome.setForeground(new java.awt.Color(202, 191, 171));
        txtPesquisarNome.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(202, 191, 171)));
        txtPesquisarNome.setCaretColor(new java.awt.Color(202, 191, 171));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPesquisarNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)
                                .addGap(51, 51, 51))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPesquisarCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                                .addComponent(jButton6)
                                .addGap(18, 18, 18)))
                        .addComponent(jButton7)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(txtPesquisarCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        transita(this, new Menu());
    }//GEN-LAST:event_jButton7ActionPerformed
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int num=Integer.parseInt(txtPesquisarCodigoCliente.getText());
        atualizaTable_PesquisaCodigo(num);
    }//GEN-LAST:event_jButton8ActionPerformed
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        atualizaTable();
    }//GEN-LAST:event_jButton6ActionPerformed
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      atualizaTable_PesquisaNome(txtPesquisarNome.getText());
    }//GEN-LAST:event_jButton5ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panel;
    private javax.swing.JFormattedTextField txtPesquisarCodigoCliente;
    private javax.swing.JTextField txtPesquisarNome;
    // End of variables declaration//GEN-END:variables
}
