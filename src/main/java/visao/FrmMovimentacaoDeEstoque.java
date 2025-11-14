
package visao;

import cliente.ClienteRMI;
import interfaces.EstoqueService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Movimentacao;
import modelo.Produto;


public class FrmMovimentacaoDeEstoque extends javax.swing.JFrame {
    
    private ClienteRMI clienteRMI;
    private EstoqueService estoqueService;

    
    public FrmMovimentacaoDeEstoque() {
        initComponents();
        conectarServidorRMI();
        carregarProdutos();
        carregarMovimentacoes();
    }
    
    public FrmMovimentacaoDeEstoque(ClienteRMI clienteRMI) {
        initComponents();
        this.clienteRMI = clienteRMI;
        conectarServidorRMI();
        carregarProdutos();
        carregarMovimentacoes();
    }
    
    private void conectarServidorRMI() {
        try {
            if (this.clienteRMI == null)
                this.clienteRMI = new ClienteRMI();

            if (this.clienteRMI.conectar()) {
                this.estoqueService = this.clienteRMI.getService();
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

        JBLimpar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        JBSair = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTMovimentacao = new javax.swing.JTable();
        JCBProduto = new javax.swing.JComboBox<>();
        JRBEntrada = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        JRBSaida = new javax.swing.JRadioButton();
        JTFQuantidade = new javax.swing.JTextField();
        JTFData = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        JBRegistrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JBLimpar.setText("Limpar");
        JBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimparActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo:");

        JBSair.setBackground(new java.awt.Color(220, 53, 69));
        JBSair.setText("Sair");
        JBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSairActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantidade:");

        jLabel5.setText("Data:");

        jScrollPane1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jScrollPane1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        JTMovimentacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Data", "Produto", "Tipo", "Quantidade", "Saldo"
            }
        ));
        jScrollPane1.setViewportView(JTMovimentacao);

        JCBProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JRBEntrada.setText("Entrada");

        jLabel6.setText("Movimentações recentes: ");

        JRBSaida.setText("Saída");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Movimentação de Estoque");

        JBRegistrar.setText("Registrar");
        JBRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRegistrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Produto:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(197, 197, 197))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCBProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JRBEntrada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JRBSaida))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBRegistrar)
                .addGap(18, 18, 18)
                .addComponent(JBLimpar)
                .addGap(18, 18, 18)
                .addComponent(JBSair)
                .addGap(192, 192, 192))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JCBProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JRBEntrada)
                    .addComponent(JRBSaida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(JTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBRegistrar)
                    .addComponent(JBLimpar)
                    .addComponent(JBSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void carregarProdutos() {
        try {
            List<Produto> lista = estoqueService.listarProdutos();
            JCBProduto.removeAllItems();
            for (Produto p : lista) {
                JCBProduto.addItem(p.getNome());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao carregar produtos: " + e.getMessage());
        }
    }

private void carregarMovimentacoes() {
        try {
            DefaultTableModel model =
                (DefaultTableModel) JTMovimentacao.getModel();

            model.setRowCount(0);

            List<Movimentacao> movs = estoqueService.listarMovimentacoes();

            for (Movimentacao m : movs) {
                model.addRow(new Object[]{
                    m.getId(),
                    m.getProduto().getNome(),
                    m.getTipo(),
                    m.getQuantidade(),
                    m.getData()
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao carregar movimentações: " + e.getMessage());
        }
    }

    
    private void limparCampos() {
        JTFQuantidade.setText("");
        JTFData.setText("");
        JREntrada.setSelected(true);
    }
    private void JBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_JBLimparActionPerformed

    private void JBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSairActionPerformed
        this.dispose();
        janelaAnterior.setVisible(true);
    }//GEN-LAST:event_JBSairActionPerformed

    private void jScrollPane1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jScrollPane1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1AncestorAdded

    private void JBRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRegistrarActionPerformed
        private void JBRegistrarActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            String produtoNome = (String) JCBProduto.getSelectedItem();
            if (produtoNome == null) {
                JOptionPane.showMessageDialog(this, "Selecione um produto.");
                return;
            }

            List<Produto> lista = estoqueService.listarProdutos();
            Produto produto = lista.stream()
                    .filter(p -> p.getNome().equals(produtoNome))
                    .findFirst()
                    .orElse(null);

            if (produto == null) {
                JOptionPane.showMessageDialog(this, "Produto inválido.");
                return;
            }

            int qtd = Integer.parseInt(JTFQuantidade.getText());
            String data = JTFData.getText();

            String tipo = JREntrada.isSelected() ? "Entrada" : "Saída";

            if (tipo.equals("Saída") && qtd > produto.getQuantidade()) {
                JOptionPane.showMessageDialog(this,
                    "Saída maior que a quantidade em estoque.");
                return;
            }

            
            int novoEstoque = tipo.equals("Entrada")
                    ? produto.getQuantidade() + qtd
                    : produto.getQuantidade() - qtd;

            produto.setQuantidade(novoEstoque);
            estoqueService.atualizarProduto(produto);

            
            Movimentacao mov = new Movimentacao();
            mov.setProduto(produto);
            mov.setQuantidade(qtd);
            mov.setTipo(tipo);
            mov.setData(data);

            estoqueService.registrarMovimentacao(mov);

            JOptionPane.showMessageDialog(this,
                "Movimentação registrada com sucesso!");

            carregarMovimentacoes();
            limparCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao registrar movimentação: " + e.getMessage());
        }
    }//GEN-LAST:event_JBRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMovimentacaoDeEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentacaoDeEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentacaoDeEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentacaoDeEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMovimentacaoDeEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBLimpar;
    private javax.swing.JButton JBRegistrar;
    private javax.swing.JButton JBSair;
    private javax.swing.JComboBox<String> JCBProduto;
    private javax.swing.JRadioButton JRBEntrada;
    private javax.swing.JRadioButton JRBSaida;
    private javax.swing.JTextField JTFData;
    private javax.swing.JTextField JTFQuantidade;
    private javax.swing.JTable JTMovimentacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
