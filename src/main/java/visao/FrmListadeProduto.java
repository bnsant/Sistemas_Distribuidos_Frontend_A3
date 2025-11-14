
package visao;

import cliente.ClienteRMI;
import interfaces.EstoqueService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.Produto;


public class FrmListadeProduto extends javax.swing.JFrame {
    
    private ClienteRMI clienteRMI;
    private EstoqueService estoqueService;

    
    public FrmListadeProduto() {
        initComponents();
        conectarServidorRMI();
        carregarCategorias();
        carregarTabelaProdutos();
    }
    
    public FrmListadeProduto(ClienteRMI clienteRMI) {
        initComponents();
        this.clienteRMI = clienteRMI;
        conectarServidorRMI();
        carregarCategorias();
        carregarTabelaProdutos();
    }
    
    public ClienteRMI getClienteRMI() {
        return this.clienteRMI;
    }
    
    private void conectarServidorRMI() {
        try {
            if (clienteRMI == null)
                clienteRMI = new ClienteRMI();

            if (clienteRMI.conectar()) {
                estoqueService = clienteRMI.getService();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao conectar ao servidor RMI.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBReajustar = new javax.swing.JButton();
        JTFBuscar = new javax.swing.JTextField();
        JCBCategoria = new javax.swing.JComboBox<>();
        JBFiltrar = new javax.swing.JButton();
        JSPTabeladeProdutos = new javax.swing.JScrollPane();
        JTTabelaProdutos = new javax.swing.JTable();
        JBNovoProduto = new javax.swing.JButton();
        JBEditar = new javax.swing.JButton();
        JBExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JLBuscar = new javax.swing.JLabel();
        JBVoltarLP = new javax.swing.JButton();
        JLCategoria = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JBReajustar.setText("Reajustar Preços");
        JBReajustar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBReajustarActionPerformed(evt);
            }
        });

        JTFBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFBuscarActionPerformed(evt);
            }
        });

        JCBCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JCBCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBCategoriaActionPerformed(evt);
            }
        });

        JBFiltrar.setText("Filtrar");
        JBFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBFiltrarActionPerformed(evt);
            }
        });

        JTTabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Quantidade", "Unidade", "Categoria"
            }
        ));
        JSPTabeladeProdutos.setViewportView(JTTabelaProdutos);

        JBNovoProduto.setText("Novo Produto");
        JBNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBNovoProdutoActionPerformed(evt);
            }
        });

        JBEditar.setText("Editar");
        JBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEditarActionPerformed(evt);
            }
        });

        JBExcluir.setBackground(new java.awt.Color(220, 53, 69));
        JBExcluir.setText("Excluir");
        JBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBExcluirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Lista de Produtos");

        JLBuscar.setText("Buscar:");

        JBVoltarLP.setText("Voltar");
        JBVoltarLP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarLPActionPerformed(evt);
            }
        });

        JLCategoria.setText("Categoria:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JLBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JLCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(JBFiltrar)
                        .addGap(185, 185, 185))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JSPTabeladeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(JBNovoProduto)
                        .addGap(40, 40, 40)
                        .addComponent(JBEditar)
                        .addGap(34, 34, 34)
                        .addComponent(JBExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(JBVoltarLP)
                        .addGap(18, 18, 18)
                        .addComponent(JBReajustar)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLBuscar)
                    .addComponent(JLCategoria)
                    .addComponent(JTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBFiltrar))
                .addGap(31, 31, 31)
                .addComponent(JSPTabeladeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBReajustar)
                    .addComponent(JBVoltarLP)
                    .addComponent(JBExcluir)
                    .addComponent(JBEditar)
                    .addComponent(JBNovoProduto))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void carregarCategorias() {
        try {
            JCBCategoria.removeAllItems();
            JCBCategoria.addItem("Todas");

            List<Categoria> categorias = estoqueService.listarCategorias();
            for (Categoria c : categorias) {
                JCBCategoria.addItem(c.getNome());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar categorias: " + e.getMessage());
        }
    }

public void carregarTabelaProdutos() {
        try {
            String filtroNome = JTBuscar.getText().trim();
            String filtroCategoria = (String) JCBCategoria.getSelectedItem();

            List<Produto> lista = estoqueService.listarProdutos();

            DefaultTableModel model =
                    (DefaultTableModel) JTabelaProdutos.getModel();

            model.setRowCount(0);

            for (Produto p : lista) {

                boolean passaNome = filtroNome.isEmpty()
                        || p.getNome().toLowerCase().contains(filtroNome.toLowerCase());

                boolean passaCategoria = filtroCategoria.equals("Todas")
                        || p.getCategoria().getNome().equals(filtroCategoria);

                if (passaNome && passaCategoria) {
                    model.addRow(new Object[]{
                        p.getId_produto(),
                        p.getNome(),
                        p.getCategoria().getNome(),
                        p.getQuantidade(),
                        p.getQuantidade_minima(),
                        p.getPreco()
                    });
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar tabela: " + e.getMessage());
        }
    }
    private void JBReajustarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBReajustarActionPerformed
         FrmReajustarPreco tela = new FrmReajustarPreco(this);
        tela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_JBReajustarActionPerformed

    private void JTFBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFBuscarActionPerformed
        carregarTabelaProdutos();
    }//GEN-LAST:event_JTFBuscarActionPerformed

    private void JCBCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBCategoriaActionPerformed
        carregarTabelaProdutos();
    }//GEN-LAST:event_JCBCategoriaActionPerformed

    private void JBFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBFiltrarActionPerformed
        carregarTabelaProdutos();
    }//GEN-LAST:event_JBFiltrarActionPerformed

    private void JBNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBNovoProdutoActionPerformed
        FrmCadastrodeProduto tela = new FrmCadastrodeProduto(this.clienteRMI);
        tela.setVisible(true);
    }//GEN-LAST:event_JBNovoProdutoActionPerformed

    private void JBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEditarActionPerformed
        int linha = JTabelaProdutos.getSelectedRow();

        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para editar.");
            return;
        }

        int id = (int) JTabelaProdutos.getValueAt(linha, 0);

        try {
            Produto p = estoqueService.buscarProduto(id);
            FrmCadastrodeProduto tela = new FrmCadastrodeProduto(this.clienteRMI, p);
            tela.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produto: " + e.getMessage());
        }
    }//GEN-LAST:event_JBEditarActionPerformed

    private void JBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExcluirActionPerformed
        int linha = JTabelaProdutos.getSelectedRow();

        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para excluir.");
            return;
        }

        int id = (int) JTabelaProdutos.getValueAt(linha, 0);

        int confirmar = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja excluir este produto?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (confirmar != JOptionPane.YES_OPTION) return;

        try {
            estoqueService.excluirProduto(id);
            carregarTabelaProdutos();
            JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir: " + e.getMessage());
        }
    }//GEN-LAST:event_JBExcluirActionPerformed

    private void JBVoltarLPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarLPActionPerformed
        janelaAnterior.setVisible(true);
        dispose();
    }//GEN-LAST:event_JBVoltarLPActionPerformed

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
            java.util.logging.Logger.getLogger(FrmListadeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListadeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListadeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListadeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListadeProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBEditar;
    private javax.swing.JButton JBExcluir;
    private javax.swing.JButton JBFiltrar;
    private javax.swing.JButton JBNovoProduto;
    private javax.swing.JButton JBReajustar;
    private javax.swing.JButton JBVoltarLP;
    private javax.swing.JComboBox<String> JCBCategoria;
    private javax.swing.JLabel JLBuscar;
    private javax.swing.JLabel JLCategoria;
    private javax.swing.JScrollPane JSPTabeladeProdutos;
    private javax.swing.JTextField JTFBuscar;
    private javax.swing.JTable JTTabelaProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
