
package visao;

import cliente.ClienteRMI;
import modelo.Produto;
import service.EstoqueService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;


public class FrmReajustarPreco extends javax.swing.JFrame {
    
   private ClienteRMI clienteRMI;
    private EstoqueService estoqueService;
    private Produto produto;
    private FrmListadePreco telaAnterior;
    private List<Produto> produtos;

    
    public FrmReajustarPreco() {
        initComponents();
         this.clienteRMI = clienteRMI;
        this.produto = produto;
        this.telaAnterior = telaAnterior;
        
        conectarServidorRMI();
        carregarProdutosNoCombo();
        selectProdutoNoCombo(produto);
        atualizarPrecoAtual();
        
    }
    
    
    
    public FrmReajustarPreco(ClienteRMI clienteRMI) {
        initComponents();
        this.clienteRMI = clienteRMI;
        conectarServidorRMI();
        carregarProdutosNoCombo();
    }


    public FrmReajustarPreco(ClienteRMI clienteRMI, Produto produto, FrmListadePreco telaAnterior) {
        initComponents();
        this.clienteRMI = clienteRMI;
        this.produto = produto;
        this.telaAnterior = telaAnterior;

        conectarServidorRMI();
        carregarProdutosNoCombo(); 
        if (this.produto != null) {
            
            selectProdutoNoCombo(produto);
            atualizarPrecoAtual();
        }
    }
    
     private void conectarServidorRMI() {
        try {
            if (this.clienteRMI == null) {
                this.clienteRMI = new ClienteRMI();
            }

            if (this.clienteRMI.conectar()) {
                this.estoqueService = this.clienteRMI.getService();
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível conectar ao servidor RMI.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao servidor: " + e.getMessage());
        }
    }
     
     private void carregarProdutosNoCombo() {
        try {
            if (estoqueService == null) return;

            produtos = estoqueService.listarProdutos(); 
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            for (Produto p : produtos) {
                model.addElement(p.getNome());
            }
            JCBProduto.setModel(model);

            
            if (this.produto != null) {
                selectProdutoNoCombo(this.produto);
            } else if (!produtos.isEmpty()) {
                
                JCBProduto.setSelectedIndex(0);
                atualizarPrecoAtual();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + e.getMessage());
        }
    }
     
     private void selectProdutoNoCombo(Produto p) {
        if (p == null || produtos == null) return;
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == p.getId()) {
                JCBProduto.setSelectedIndex(i);
                return;
            }
        }
    }
     
      private void atualizarPrecoAtual() {
        int idx = JCBProduto.getSelectedIndex();
        if (idx >= 0 && produtos != null && idx < produtos.size()) {
            produto = produtos.get(idx);
            JTFPrecoAtual.setText(String.valueOf(produto.getPreco()));
        } else {
            JTFPrecoAtual.setText("");
        }
    }
      
      private void aplicarNovoPreco(double novoPreco, boolean fechar) {
        try {
            if (produto == null) {
                JOptionPane.showMessageDialog(this, "Nenhum produto selecionado.");
                return;
            }
            if (novoPreco < 0) {
                JOptionPane.showMessageDialog(this, "Preço inválido.");
                return;
            }

            produto.setPreco(novoPreco);
            estoqueService.atualizarProduto(produto);

            JOptionPane.showMessageDialog(this, "Preço atualizado com sucesso!");

            if (telaAnterior != null) {
                try {
                    telaAnterior.carregarListaDePrecos();
                } catch (Exception ex) {
                    
                }
            }

            if (fechar) dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar preço: " + e.getMessage());
        }
    }
      
      
      

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBAumentar = new javax.swing.JButton();
        JBReduzir = new javax.swing.JButton();
        JCBProduto = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        JBVoltar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JTFPrecoAtual = new javax.swing.JTextField();
        JTFPercentual = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JBAumentar.setText("➕ Aumentar");
        JBAumentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAumentarActionPerformed(evt);
            }
        });

        JBReduzir.setText("➖ Reduzir");
        JBReduzir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBReduzirActionPerformed(evt);
            }
        });

        JCBProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JCBProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBProdutoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Reajuste de Preço");

        JBVoltar.setText("Voltar");
        JBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarActionPerformed(evt);
            }
        });

        jLabel2.setText("Produto:");

        jLabel3.setText("Preço atual:");

        jLabel4.setText("Percentual:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(JTFPercentual, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(JBAumentar)
                        .addGap(30, 30, 30)
                        .addComponent(JBReduzir)
                        .addGap(35, 35, 35)
                        .addComponent(JBVoltar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTFPrecoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCBProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(134, 134, 134))
            .addComponent(jSeparator1)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JCBProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTFPrecoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JTFPercentual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBAumentar)
                    .addComponent(JBReduzir)
                    .addComponent(JBVoltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBAumentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAumentarActionPerformed
          try {
            double percentual = Double.parseDouble(JTFPercentual.getText());
            double precoAtual = produto != null ? produto.getPreco() : 0.0;
            double novo = precoAtual + (precoAtual * percentual / 100.0);
            aplicarNovoPreco(novo, true);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Percentual inválido.");
        }
    }//GEN-LAST:event_JBAumentarActionPerformed

    private void JBReduzirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBReduzirActionPerformed
         try {
            double percentual = Double.parseDouble(JTFPercentual.getText());
            double precoAtual = produto != null ? produto.getPreco() : 0.0;
            double novo = precoAtual - (precoAtual * percentual / 100.0);
            if (novo < 0) {
                JOptionPane.showMessageDialog(this, "O preço não pode ser negativo.");
                return;
            }
            aplicarNovoPreco(novo, true);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Percentual inválido.");
        }
    }//GEN-LAST:event_JBReduzirActionPerformed

    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarActionPerformed
        if (telaAnterior != null) {
            telaAnterior.setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_JBVoltarActionPerformed

    private void JCBProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBProdutoActionPerformed
        atualizarPrecoAtual();
    }//GEN-LAST:event_JCBProdutoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmReajustarPreco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReajustarPreco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReajustarPreco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReajustarPreco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReajustarPreco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAumentar;
    private javax.swing.JButton JBReduzir;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JComboBox<String> JCBProduto;
    private javax.swing.JTextField JTFPercentual;
    private javax.swing.JTextField JTFPrecoAtual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
