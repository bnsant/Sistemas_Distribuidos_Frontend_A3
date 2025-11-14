
package visao;

import cliente.ClienteRMI;
import interfaces.EstoqueService;
import javax.swing.JOptionPane;
 
public class FrmTelaPrincipal extends javax.swing.JFrame {
    
    private ClienteRMI clienteRMI;
    private EstoqueService estoqueService;


    
    public FrmTelaPrincipal() {
        initComponents();
        conectarServidorRMI();
    }
    
    public FrmTelaPrincipal(ClienteRMI clienteRMI) {
        initComponents();   
        this.clienteRMI = clienteRMI;
        conectarServidorRMI();

    }
    
    private void conectarServidorRMI() {
        try {
            if (this.clienteRMI == null) {
                this.clienteRMI = new ClienteRMI();
            }

            if (this.clienteRMI.conectar()) {
                this.estoqueService = this.clienteRMI.getService();
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Não foi possível conectar ao servidor RMI.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao conectar ao servidor RMI: " + e.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBRelatorios = new javax.swing.JButton();
        JBSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JBProdutos = new javax.swing.JButton();
        JBCategorias = new javax.swing.JButton();
        JBMovimentação = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JBRelatorios.setText("Relatórios");
        JBRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRelatoriosActionPerformed(evt);
            }
        });

        JBSair.setBackground(new java.awt.Color(220, 53, 69));
        JBSair.setText("Sair");
        JBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSairActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Controle de Estoque");

        JBProdutos.setText("Produtos");
        JBProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBProdutosActionPerformed(evt);
            }
        });

        JBCategorias.setText("Categorias");
        JBCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCategoriasActionPerformed(evt);
            }
        });

        JBMovimentação.setText("Movimentação de Estoque");
        JBMovimentação.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBMovimentaçãoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(JBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JBRelatorios)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JBCategorias))
                                    .addComponent(JBMovimentação, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(JBProdutos)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(JBProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBRelatorios)
                    .addComponent(JBCategorias))
                .addGap(18, 18, 18)
                .addComponent(JBMovimentação)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBSair)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRelatoriosActionPerformed
        FrmRelatorio tela = new FrmRelatorio(this.clienteRMI);
        tela.setVisible(true);
    }//GEN-LAST:event_JBRelatoriosActionPerformed

    private void JBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBSairActionPerformed

    private void JBProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBProdutosActionPerformed
        FrmListadeProduto tela = new FrmListadeProduto(this.clienteRMI);
        tela.setVisible(true);

    }//GEN-LAST:event_JBProdutosActionPerformed

    private void JBCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCategoriasActionPerformed
        FrmListadeCategoria tela = new FrmListadeCategoria(this.clienteRMI);
        tela.setVisible(true);
    }//GEN-LAST:event_JBCategoriasActionPerformed

    private void JBMovimentaçãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBMovimentaçãoActionPerformed
        FrmMovimentacaoDeEstoque tela = new FrmMovimentacaoDeEstoque(this.clienteRMI);
        tela.setVisible(true);
    }//GEN-LAST:event_JBMovimentaçãoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCategorias;
    private javax.swing.JButton JBMovimentação;
    private javax.swing.JButton JBProdutos;
    private javax.swing.JButton JBRelatorios;
    private javax.swing.JButton JBSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
