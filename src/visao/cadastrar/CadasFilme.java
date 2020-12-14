
package visao.cadastrar;

import DAO.CategoriaDAO;
import DAO.ClassificacaoDAO;
import DAO.Conexao;
import DAO.ExecuteSQL;
import DAO.FilmeDAO;
import Modelo.Filme;
import Principal.Menu;
import Principal.funcoes.Funcoes;
import java.io.File;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CadasFilme extends javax.swing.JFrame implements Funcoes{

    public CadasFilme() {
        resolucaoPadrao(this);
        initComponents();
        preencherClassificacoes();
        preencherCategoria();
    }
//<editor-fold desc="mudar o código dinamicamente de acordo com a escolha da combobox">
    private void txtCodigo(ExecuteSQL sql){
        if(sql instanceof ClassificacaoDAO){
            txtCodigoClassificacao.setText(""+new ClassificacaoDAO().pegarPorCodigo(cbClassificacao.getSelectedItem().toString()) );
            //cbClassificacao.getModel().setSelectedItem(new ClassificacaoDAO().);
        }
        if(sql instanceof CategoriaDAO){
            txtCodigoCategoria1.setText(""+new CategoriaDAO().pegarPorCodigo(cbCategoria.getSelectedItem().toString()) );
        }
        Conexao.fecharConexao(sql.getCon());
    }
  //</editor-fold>
    //<editor-fold desc="mudar o código dinamicamente de acordo com a escolha da combobox e vice-versa">
    private void txtCbNome(ExecuteSQL sql){
        if(sql instanceof ClassificacaoDAO){
            cbClassificacao.getModel().setSelectedItem(new ClassificacaoDAO().pegarONome(txtCodigoClassificacao.getText()));
        }
        if(sql instanceof CategoriaDAO){
            cbCategoria.getModel().setSelectedItem(new CategoriaDAO().pegarONome(txtCodigoCategoria1.getText()));
        }
        Conexao.fecharConexao(sql.getCon());
    }
  //</editor-fold>
//<editor-fold desc="preenche a combobox">
private void preencherClassificacoes(){
    ClassificacaoDAO sql=new ClassificacaoDAO();
    sql.listaClassificacoes().forEach((nome) -> {
        cbClassificacao.addItem(nome.getNome());
        });
    txtCodigo(new ClassificacaoDAO());
    Conexao.fecharConexao(sql.getCon());
}
private void preencherCategoria(){
    CategoriaDAO sql=new CategoriaDAO();
    sql.listaCategoria().forEach((nome) -> {
        cbCategoria.addItem(nome.getNome());
        });
     txtCodigo(new CategoriaDAO());
    Conexao.fecharConexao(sql.getCon());
}
//</editor-fold>
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbClassificacao = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lblCapa = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(202, 191, 171));
        jLabel2.setLabelFor(txtTitulo);
        jLabel2.setText("Título:");

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(202, 191, 171));
        jLabel3.setLabelFor(txtDuracao);
        jLabel3.setText("Duração:");

        cbCategoria.setBackground(new java.awt.Color(204, 204, 204));
        cbCategoria.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbCategoria.setForeground(new java.awt.Color(65, 68, 75));
        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(202, 191, 171));
        jLabel4.setLabelFor(txtCodigoClassificacao);
        jLabel4.setText("Categoria:");

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(202, 191, 171));
        jLabel5.setLabelFor(txtCapa);
        jLabel5.setText("Capa:");

        cbClassificacao.setBackground(new java.awt.Color(204, 204, 204));
        cbClassificacao.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbClassificacao.setForeground(new java.awt.Color(65, 68, 75));
        cbClassificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClassificacaoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(202, 191, 171));
        jLabel6.setLabelFor(cbClassificacao);
        jLabel6.setText("Classificação:");

        txtCapa.setEditable(false);

        jButton4.setBackground(new java.awt.Color(65, 68, 75));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        lblCapa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/movie.png"))); // NOI18N

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(202, 191, 171));
        jLabel8.setLabelFor(txtDuracao);
        jLabel8.setText("Ano:");

        txtCodigoClassificacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtCodigoClassificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoClassificacaoActionPerformed(evt);
            }
        });

        txtCodigoCategoria1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtCodigoCategoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoCategoria1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(202, 191, 171));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Filme");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filler2, javax.swing.GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTitulo))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                        .addGap(0, 15, Short.MAX_VALUE)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCodigoClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCodigoCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCapa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(1, 1, 1)))
                .addComponent(lblCapa, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(filler3, javax.swing.GroupLayout.DEFAULT_SIZE, 9, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCodigoCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCodigoClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(jButton3))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(lblCapa, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(filler3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                  String titulo=txtTitulo.getText();
                  String ano=txtAno.getText();
                  String duracao=txtDuracao.getText();
                  String codigoCategoria=txtCodigoCategoria1.getText();
                  String codigoClassificacao=txtCodigoClassificacao.getText();
                  String capa="C:/VideoLocadora/Pictures/"+txtCapa.getText();
                  try {
                        Connection con=Conexao.abrirConexao();
                        FilmeDAO sql=new FilmeDAO();
                        Filme filme=new Filme();
                        filme.setTitulo(titulo);
                        filme.setAno(Integer.parseInt(ano));
                        filme.setDuracao(duracao);
                        filme.setCodigo_categoria(Integer.parseInt(codigoCategoria));
                        filme.setCodigo_classificacao(Integer.parseInt(codigoClassificacao));
                        filme.setCapa(capa);
                        sql.inserirFilme(filme);
                        Conexao.fecharConexao(con);
                        JOptionPane.showMessageDialog(null,"Filme cadastrado","Video Locadora",
                        JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
                      JOptionPane.showMessageDialog(null,"Erro ao cadastrar o filme","Video Locadora",
                              JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       transita(this,new Menu());
    }//GEN-LAST:event_jButton3ActionPerformed
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
               try {
            JFileChooser capa=new JFileChooser();
            FileNameExtensionFilter filtro=new FileNameExtensionFilter("'Imagens", "png","jpg","jpeg");
            capa.addChoosableFileFilter(filtro);
            capa.setAcceptAllFileFilterUsed(false);
            capa.setCurrentDirectory(new File("C:/VideoLocadora/Pictures"));
            capa.setDialogTitle("Carregar Capa");
            capa.showOpenDialog(this);
            String foto=capa.getSelectedFile().getName();
            txtCapa.setText(foto);
            lblCapa.setIcon(new ImageIcon(capa.getSelectedFile().getAbsolutePath()));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbClassificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClassificacaoActionPerformed
       txtCodigo(new ClassificacaoDAO());
    }//GEN-LAST:event_cbClassificacaoActionPerformed

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        txtCodigo(new CategoriaDAO());
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        apagarCampos(txtCodigoClassificacao,txtAno,txtCapa,txtCodigoCategoria1,txtDuracao,txtTitulo);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCodigoCategoria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoCategoria1ActionPerformed
        txtCbNome(new CategoriaDAO());
    }//GEN-LAST:event_txtCodigoCategoria1ActionPerformed

    private void txtCodigoClassificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoClassificacaoActionPerformed
        txtCbNome(new ClassificacaoDAO());
    }//GEN-LAST:event_txtCodigoClassificacaoActionPerformed

    public static void main(String args[]) {
                new CadasFilme().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbClassificacao;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private final javax.swing.JButton jButton1 = jbuttonPadrao("Limpar");
    private final javax.swing.JButton jButton2 = jbuttonPadrao("Cadastrar");
    private final javax.swing.JButton jButton3 = jbuttonPadrao("Cancelar");
    private final javax.swing.JButton jButton4 = jbuttonPadrao("Selecionar");
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblCapa;
    private final javax.swing.JPanel panel = JPanelPadrao();
    private final javax.swing.JFormattedTextField txtAno = jJFormattedTextFieldPadrao();
    private final javax.swing.JTextField txtCapa = jTextFieldPadrao();
    private final javax.swing.JFormattedTextField txtCodigoCategoria1 = jJFormattedTextFieldPadrao();
    private final javax.swing.JFormattedTextField txtCodigoClassificacao = jJFormattedTextFieldPadrao();
    private final javax.swing.JFormattedTextField txtDuracao = jJFormattedTextFieldPadrao();
    private final javax.swing.JTextField txtTitulo = jTextFieldPadrao();
    // End of variables declaration//GEN-END:variables
}
