
package visao;

import cliente.ClienteRMI;
import service.EstoqueService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;


public class FrmListadeCategoria extends javax.swing.JFrame {
    private ClienteRMI clienteRMI;
    private EstoqueService estoqueService;

    private List<Categoria> categorias;

    
    public FrmListadeCategoria() {
        initComponents();
        conectarServidorRMI();
        carregarCategorias();
    }
    
    public FrmListadeCategoria(ClienteRMI clienteRMI) {
    initComponents();
    this.clienteRMI = clienteRMI;
    conectarServidorRMI();
    carregarCategorias();
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
                JOptionPane.showMessageDialog(this,
                        "Erro ao conectar ao servidor RMI.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao conectar: " + e.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTListaCategoria = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        JBVoltarLC = new javax.swing.JButton();
        JBAdicionar = new javax.swing.JButton();
        JBEditar = new javax.swing.JButton();
        JBExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Lista de Categoria");

        JTListaCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Tamanho", "Embalagem"
            }
        ));
        jScrollPane1.setViewportView(JTListaCategoria);

        JBVoltarLC.setText("Voltar");
        JBVoltarLC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarLCActionPerformed(evt);
            }
        });

        JBAdicionar.setText("Adicionar");
        JBAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAdicionarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(JBAdicionar)
                        .addGap(42, 42, 42)
                        .addComponent(JBEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBVoltarLC)
                        .addGap(42, 42, 42)
                        .addComponent(JBExcluir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(230, 230, 230))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBVoltarLC)
                    .addComponent(JBAdicionar)
                    .addComponent(JBEditar)
                    .addComponent(JBExcluir))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void carregarCategorias() {
    try {
        categorias = estoqueService.listarCategorias();

        DefaultTableModel model =
            (DefaultTableModel) JTListaCategoria.getModel();

        model.setRowCount(0);

        for (Categoria c : categorias) {
            model.addRow(new Object[]{
                c.getId(),
                c.getNomeCategoria(),
                c.getTamanho(),
                c.getEmbalagem()
            });
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Erro ao carregar categorias: " + e.getMessage());
    }
}
    private void JBVoltarLCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarLCActionPerformed
        dispose();
    }//GEN-LAST:event_JBVoltarLCActionPerformed

    private void JBAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAdicionarActionPerformed
        FrmCadastroDeCategoria tela = new FrmCadastroDeCategoria(clienteRMI);
    tela.setVisible(true);
    }//GEN-LAST:event_JBAdicionarActionPerformed

    private void JBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEditarActionPerformed
        int linha = JTListaCategoria.getSelectedRow();

        if (linha < 0) {
            JOptionPane.showMessageDialog(this,
                "Selecione uma categoria para editar.");
            return;
        }

        int id = (int) JTListaCategoria.getValueAt(linha, 0);

        try {
            Categoria c = estoqueService.buscarCategoria(id);

            FrmCadastroDeCategoria tela =
    new FrmCadastroDeCategoria(clienteRMI, c);

tela.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao carregar categoria: " + e.getMessage());
        }
    }//GEN-LAST:event_JBEditarActionPerformed

    private void JBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExcluirActionPerformed
        int linha = JTListaCategoria.getSelectedRow();

        if (linha < 0) {
            JOptionPane.showMessageDialog(this,
                "Selecione uma categoria para excluir.");
            return;
        }

        int id = (int) JTListaCategoria.getValueAt(linha, 0);

        int confirmar = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja excluir esta categoria?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (confirmar != JOptionPane.YES_OPTION) return;

        try {
            estoqueService.excluirCategoria(id);
            carregarCategorias();

            JOptionPane.showMessageDialog(this,
                    "Categoria excluída com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao excluir categoria: " + e.getMessage());
        }
    }//GEN-LAST:event_JBExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(FrmListadeCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListadeCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListadeCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListadeCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListadeCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAdicionar;
    private javax.swing.JButton JBEditar;
    private javax.swing.JButton JBExcluir;
    private javax.swing.JButton JBVoltarLC;
    private javax.swing.JTable JTListaCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
