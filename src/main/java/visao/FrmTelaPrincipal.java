
package visao;

import cliente.ClienteRMI;
import javax.swing.JOptionPane;

public class FrmTelaPrincipal extends javax.swing.JFrame {

    private ClienteRMI clienteRMI;
    
    public FrmTelaPrincipal() {
        initComponents();
        clienteRMI = new ClienteRMI();
        if (!clienteRMI.conectar()) {
            JOptionPane.showMessageDialog(this, 
                "Não foi possível conectar ao servidor RMI.\nVerifique se o servidor está rodando.",
                "Erro de Conexão", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public FrmTelaPrincipal(ClienteRMI cliente) {
        initComponents();
        this.clienteRMI = cliente;
        if (!clienteRMI.estaConectado() && !clienteRMI.conectar()) {
            JOptionPane.showMessageDialog(this, 
                "Não foi possível conectar ao servidor RMI.\nVerifique se o servidor está rodando.",
                "Erro de Conexão", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JBSair = new javax.swing.JButton();
        JBRelatorios = new javax.swing.JToggleButton();
        JBCategorias = new javax.swing.JToggleButton();
        JBMovimentacao = new javax.swing.JToggleButton();
        JBProdutos1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Controle de estoque");

        JBSair.setText("Sair");
        JBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSairActionPerformed(evt);
            }
        });

        JBRelatorios.setText("Relatorios");
        JBRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRelatoriosActionPerformed(evt);
            }
        });

        JBCategorias.setText("Categorias");
        JBCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCategoriasActionPerformed(evt);
            }
        });

        JBMovimentacao.setText("Movimentação de estoque");
        JBMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBMovimentacaoActionPerformed(evt);
            }
        });

        JBProdutos1.setText("Produtos");
        JBProdutos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBProdutos1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JBMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JBRelatorios)
                                .addGap(18, 18, 18)
                                .addComponent(JBCategorias))
                            .addComponent(jLabel1))
                        .addGap(124, 124, 124))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(JBProdutos1)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(JBSair)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(JBProdutos1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBCategorias)
                    .addComponent(JBRelatorios, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(JBMovimentacao)
                .addGap(18, 18, 18)
                .addComponent(JBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSairActionPerformed
        if (clienteRMI != null) {
            clienteRMI.desconectar();
        }
        System.exit(0);
    }//GEN-LAST:event_JBSairActionPerformed

    private void JBMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBMovimentacaoActionPerformed
        JOptionPane.showMessageDialog(this, "Funcionalidade de movimentação ainda não implementada.");
    }//GEN-LAST:event_JBMovimentacaoActionPerformed

    private void JBProdutos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBProdutos1ActionPerformed
        FrmListadeProduto listaProdutos = new FrmListadeProduto(clienteRMI, this);
        listaProdutos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_JBProdutos1ActionPerformed

    private void JBRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {
        FrmRelatorio relatorio = new FrmRelatorio(clienteRMI, this);
        relatorio.setVisible(true);
        this.setVisible(false);
    }

    private void JBCategoriasActionPerformed(java.awt.event.ActionEvent evt) {
        FrmListadeCategoria listaCategorias = new FrmListadeCategoria(clienteRMI, this);
        listaCategorias.setVisible(true);
        this.setVisible(false);
    }

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
    private javax.swing.JToggleButton JBCategorias;
    private javax.swing.JToggleButton JBMovimentacao;
    private javax.swing.JButton JBProdutos1;
    private javax.swing.JToggleButton JBRelatorios;
    private javax.swing.JButton JBSair;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
