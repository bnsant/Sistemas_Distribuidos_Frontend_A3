/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import cliente.ClienteRMI;
import modelo.Produto;
import service.EstoqueService;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author eugus
 */
public class FrmListaDePreco extends javax.swing.JFrame {

    private ClienteRMI clienteRMI;
    
    /**
     * Creates new form FrmListaDePreco
     */
    public FrmListaDePreco() {
        initComponents();
        clienteRMI = new ClienteRMI();
        if (!clienteRMI.conectar()) {
            JOptionPane.showMessageDialog(this, 
                "Não foi possível conectar ao servidor RMI.",
                "Erro de Conexão", 
                JOptionPane.ERROR_MESSAGE);
        } else {
            carregarTabela();
        }
    }
    
    public FrmListaDePreco(ClienteRMI cliente) {
        initComponents();
        this.clienteRMI = cliente;
        if (!clienteRMI.estaConectado() && !clienteRMI.conectar()) {
            JOptionPane.showMessageDialog(this, 
                "Não foi possível conectar ao servidor RMI.",
                "Erro de Conexão", 
                JOptionPane.ERROR_MESSAGE);
        } else {
            carregarTabela();
        }
    }
    
    public void carregarTabela() {
        try {
            EstoqueService service = clienteRMI.getService();
            List<Produto> produtos = service.listarProdutosOrdenadosPorNome();
            
            DefaultTableModel modelo = (DefaultTableModel) JTListaDePreco.getModel();
            modelo.setRowCount(0);
            
            for (Produto p : produtos) {
                modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getUnidade(),
                    p.getCategoria(),
                    String.format("R$ %.2f", p.getPreco())
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar lista de preços: " + e.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JBEditar = new javax.swing.JButton();
        JBFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTListaDePreco = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));jLabel1.setText("Lista de Preços");

        JBEditar.setText("Editar");
        JBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEditarActionPerformed(evt);
            }
        });

        JBFechar.setBackground(new java.awt.Color(220, 53, 69));
        JBFechar.setText("Fechar");
        JBFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBFecharActionPerformed(evt);
            }
        });

        JTListaDePreco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Unidade", "Categoria", "Preço Unitário"
            }
        ));
        jScrollPane1.setViewportView(JTListaDePreco);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(JBEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBFechar)
                .addGap(130, 130, 130))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBEditar)
                    .addComponent(JBFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
        );

        pack();
    }

    private void JBEditarActionPerformed(java.awt.event.ActionEvent evt) {
        int linhaSelecionada = JTListaDePreco.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para editar.");
            return;
        }

        int idProduto = Integer.parseInt(JTListaDePreco.getValueAt(linhaSelecionada, 0).toString());

        try {
            EstoqueService service = clienteRMI.getService();
            Produto produto = service.buscarProdutoPorId(idProduto);

            FrmCadastrodeProduto editarProduto = new FrmCadastrodeProduto(clienteRMI, this, produto);
            editarProduto.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar produto: " + e.getMessage());
        }
    }

    private void JBFecharActionPerformed(java.awt.event.ActionEvent evt) {
        FrmRelatorio relatorio = new FrmRelatorio(clienteRMI, null);
        relatorio.setVisible(true);
        dispose();
    }

    
    public static void main(String args[]) {

        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmListaDePreco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListaDePreco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListaDePreco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListaDePreco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListaDePreco().setVisible(true);
            }
        });
    }

    private javax.swing.JButton JBEditar;
    private javax.swing.JButton JBFechar;
    private javax.swing.JTable JTListaDePreco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;

}
