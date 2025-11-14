
package visao;

import cliente.ClienteRMI;
import interfaces.EstoqueService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Produto;


public class FrmProdutoAbaixoDoMin extends javax.swing.JFrame {
    
    private ClienteRMI clienteRMI;
    private EstoqueService estoqueService;

    
    public FrmProdutoAbaixoDoMin() {
        initComponents();
        conectarServidorRMI();
        carregarProdutosAbaixoDoMinimo(null);

    }
    
    public FrmProdutoAbaixoDoMin(ClienteRMI clienteRMI) {
        initComponents();
        this.clienteRMI = clienteRMI;
        conectarServidorRMI();
        carregarProdutosAbaixoDoMinimo(null);
    }
    
    private void conectarServidorRMI() {
        try {
            if (this.clienteRMI == null)
                this.clienteRMI = new ClienteRMI();

            if (this.clienteRMI.conectar()) {
                this.estoqueService = this.clienteRMI.getService();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Erro ao conectar ao servidor RMI.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao conectar ao servidor: " + e.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JCBFiltro = new javax.swing.JComboBox<>();
        JBBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTProdutoAbaixo = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        JBFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JCBFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JCBFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBFiltroActionPerformed(evt);
            }
        });

        JBBuscar.setText("Buscar");
        JBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBuscarActionPerformed(evt);
            }
        });

        JTProdutoAbaixo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Quantidade", "Mínimo", "Máximo"
            }
        ));
        jScrollPane1.setViewportView(JTProdutoAbaixo);

        jScrollPane2.setViewportView(jScrollPane1);

        JBFechar.setBackground(new java.awt.Color(220, 53, 69));
        JBFechar.setText("Fechar");
        JBFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBFecharActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Produtos Abaixo do Mínimo/Máximo");

        jLabel2.setText("Filtro por Categoria:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCBFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(JBBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(JBFechar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JCBFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(JBFechar)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void carregarProdutosAbaixoDoMinimo(String filtro) {
        try {
            DefaultTableModel model =
                (DefaultTableModel) JTProdutoAbaixo.getModel();
            model.setRowCount(0);

            List<Produto> produtos = estoqueService.listarProdutos();

            for (Produto p : produtos) {

                boolean abaixo = p.getQuantidade() < p.getQuantidade_minima();

                boolean filtraCategoria =
                    filtro != null &&
                    !filtro.equals("Todas") &&
                    !p.getCategoria().getNome().equalsIgnoreCase(filtro);

                if (!abaixo || filtraCategoria)
                    continue;

                model.addRow(new Object[]{
                    p.getId_produto(),
                    p.getNome(),
                    p.getCategoria().getNome(),
                    p.getQuantidade(),
                    p.getQuantidade_minima()
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao carregar produtos: " + e.getMessage());
        }
    }
    private void JBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBuscarActionPerformed
        String filtro = (String) JCBFiltro.getSelectedItem();
        carregarProdutosAbaixoDoMinimo(filtro);
    }//GEN-LAST:event_JBBuscarActionPerformed

    private void JBFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBFecharActionPerformed
        this.dispose();
        janelaAnterior.setVisible(true);
    }//GEN-LAST:event_JBFecharActionPerformed

    private void JCBFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBFiltroActionPerformed
        String filtro = (String) JCBFiltro.getSelectedItem();
        carregarProdutosAbaixoDoMinimo(filtro);
    }//GEN-LAST:event_JCBFiltroActionPerformed

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
            java.util.logging.Logger.getLogger(FrmProdutoAbaixoDoMin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProdutoAbaixoDoMin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProdutoAbaixoDoMin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProdutoAbaixoDoMin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProdutoAbaixoDoMin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBBuscar;
    private javax.swing.JButton JBFechar;
    private javax.swing.JComboBox<String> JCBFiltro;
    private javax.swing.JTable JTProdutoAbaixo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
