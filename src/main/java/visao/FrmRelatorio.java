
package visao;

       import cliente.ClienteRMI;
import service.EstoqueService;
import javax.swing.JOptionPane;

public class FrmRelatorio extends javax.swing.JFrame {
    
    private ClienteRMI clienteRMI;
    private EstoqueService estoqueService;
   
    public FrmRelatorio() {
        initComponents();
        conectarServidorRMI();
    }
    
    public FrmRelatorio(ClienteRMI clienteRMI) {
        initComponents();
        this.clienteRMI = clienteRMI;
        conectarServidorRMI();
    }

     private void conectarServidorRMI() {
        try {
            if (clienteRMI == null)
                clienteRMI = new ClienteRMI();

            if (clienteRMI.conectar()) {
                estoqueService = clienteRMI.getService();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Não foi possível conectar ao servidor RMI.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao conectar ao servidor: " + e.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JBFechar = new javax.swing.JToggleButton();
        JBListadePreco = new javax.swing.JButton();
        JBBalanco = new javax.swing.JButton();
        JBProdutosAbaixo = new javax.swing.JButton();
        JBQuantidadeProdutoCategoria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Relatórios");

        JBFechar.setBackground(new java.awt.Color(220, 53, 69));
        JBFechar.setText("Fechar");
        JBFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBFecharActionPerformed(evt);
            }
        });

        JBListadePreco.setText("Lista de Preços");
        JBListadePreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBListadePrecoActionPerformed(evt);
            }
        });

        JBBalanco.setText("Balanço Físico-Financeiro");
        JBBalanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBalancoActionPerformed(evt);
            }
        });

        JBProdutosAbaixo.setText("Produtos Abaixo do Mínimo/Máximo");
        JBProdutosAbaixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBProdutosAbaixoActionPerformed(evt);
            }
        });

        JBQuantidadeProdutoCategoria.setText("Quantidade de Produtos por Categoria");
        JBQuantidadeProdutoCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBQuantidadeProdutoCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(JBFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JBQuantidadeProdutoCategoria)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(68, 68, 68))
                                .addComponent(JBListadePreco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JBBalanco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JBProdutosAbaixo, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)))))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(JBListadePreco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBBalanco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBProdutosAbaixo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBQuantidadeProdutoCategoria)
                .addGap(62, 62, 62)
                .addComponent(JBFechar)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBFecharActionPerformed
        try {
            if (this.clienteRMI != null) {
                this.clienteRMI.desconectar();
            }
        } catch (Exception e) {
            
        } finally {
            dispose();
        }
    }//GEN-LAST:event_JBFecharActionPerformed

    private void JBListadePrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBListadePrecoActionPerformed
        FrmListadePreco tela = new FrmListadePreco(clienteRMI);
        tela.setVisible(true);
    }//GEN-LAST:event_JBListadePrecoActionPerformed

    private void JBBalancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBalancoActionPerformed
        FrmBalancoFisico tela = new FrmBalancoFisico(clienteRMI);
        tela.setVisible(true);
    }//GEN-LAST:event_JBBalancoActionPerformed

    private void JBProdutosAbaixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBProdutosAbaixoActionPerformed
         FrmProdutoAbaixoDoMin tela = new FrmProdutoAbaixoDoMin(clienteRMI);
        tela.setVisible(true);
    }//GEN-LAST:event_JBProdutosAbaixoActionPerformed

    private void JBQuantidadeProdutoCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBQuantidadeProdutoCategoriaActionPerformed
        FrmQuantidadeDeProduto tela = new FrmQuantidadeDeProduto(clienteRMI);
        tela.setVisible(true);
    }//GEN-LAST:event_JBQuantidadeProdutoCategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRelatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBBalanco;
    private javax.swing.JToggleButton JBFechar;
    private javax.swing.JButton JBListadePreco;
    private javax.swing.JButton JBProdutosAbaixo;
    private javax.swing.JButton JBQuantidadeProdutoCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
