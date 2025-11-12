
package visao;

import cliente.ClienteRMI;
import modelo.Produto;
import service.EstoqueService;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.rmi.RemoteException;
import java.util.List;


public class FrmBalancoFisico extends javax.swing.JFrame {

    private ClienteRMI clienteRMI;
    
    
    public FrmBalancoFisico() {
        initComponents();
        clienteRMI = new ClienteRMI();
        if (!clienteRMI.conectar()) {
            JOptionPane.showMessageDialog(this, 
                "Não foi possível conectar ao servidor RMI.",
                "Erro de Conexão", 
                JOptionPane.ERROR_MESSAGE);
        } else {
            carregarBalanco();
        }
    }
    
    public FrmBalancoFisico(ClienteRMI cliente) {
        initComponents();
        this.clienteRMI = cliente;
        if (!clienteRMI.estaConectado() && !clienteRMI.conectar()) {
            JOptionPane.showMessageDialog(this, 
                "Não foi possível conectar ao servidor RMI.",
                "Erro de Conexão", 
                JOptionPane.ERROR_MESSAGE);
        } else {
            carregarBalanco();
        }
    }
    
    private void carregarBalanco() {
        try {
            EstoqueService service = clienteRMI.getService();
            List<Object[]> balanco = service.listarBalancoFisicoFinanceiro();
            
            DefaultTableModel modelo = (DefaultTableModel) JTBalanco.getModel();
            modelo.setRowCount(0);
            
            double totalEstoque = 0.0;
            for (Object[] row : balanco) {
                String nome = (String) row[0];
                String categoria = (String) row[1];
                int quantidade = (Integer) row[2];
                double preco = (Double) row[3];
                double valorTotal = quantidade * preco;
                totalEstoque += valorTotal;
                
                modelo.addRow(new Object[]{
                    nome,
                    categoria,
                    quantidade,
                    String.format("R$ %.2f", preco),
                    String.format("R$ %.2f", valorTotal)
                });
            }
            
            JLTotal.setText("💰 Total do Estoque: R$ " + String.format("%.2f", totalEstoque));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar balanço: " + e.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTBalanco = new javax.swing.JTable();
        JTFBuscar = new javax.swing.JTextField();
        JBFiltrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        JLTotal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JBFechar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTBalanco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Categoria", "Quantidade Disponivel", "Preço Unitário", "Valor Total"
            }
        ));
        jScrollPane1.setViewportView(JTBalanco);

        JTFBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFBuscarActionPerformed(evt);
            }
        });

        JBFiltrar.setText("Filtrar");
        JBFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBFiltrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar:");

        JLTotal.setText("💰 Total do Estoque: R$ 0,00");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));jLabel1.setText("Balanço Físico/Financeiro");

        JBFechar.setBackground(new java.awt.Color(220, 53, 69));
        JBFechar.setText("Fechar");
        JBFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(JBFiltrar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(183, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(416, 416, 416))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JLTotal)
                        .addGap(468, 468, 468))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JBFechar)
                        .addGap(503, 503, 503))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(JBFiltrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JLTotal)
                .addGap(13, 13, 13)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JBFechar)
                .addGap(37, 37, 37))
        );

        pack();
    }

    private void JTFBuscarActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void JBFiltrarActionPerformed(java.awt.event.ActionEvent evt) {
        String texto = JTFBuscar.getText().trim().toLowerCase();
        try {
            EstoqueService service = clienteRMI.getService();
            List<Produto> lista = service.listarProdutosOrdenadosPorNome();
            DefaultTableModel modelo = (DefaultTableModel) JTBalanco.getModel();
            modelo.setRowCount(0);

            double totalEstoque = 0.0;

            for (Produto p : lista) {
                if (p.getNome().toLowerCase().contains(texto)) {
                    double valorTotal = p.getQuantidade() * p.getPreco();
                    totalEstoque += valorTotal;

                    modelo.addRow(new Object[]{
                        p.getNome(),
                        p.getCategoria(),
                        p.getQuantidade(),
                        String.format("R$ %.2f", p.getPreco()),
                        String.format("R$ %.2f", valorTotal)
                    });
                }
            }

            JLTotal.setText("💰 Total do Estoque: R$ " + String.format("%.2f", totalEstoque));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao filtrar: " + e.getMessage());
        }
    }

    private void JBFecharActionPerformed(java.awt.event.ActionEvent evt) {
        FrmRelatorio relatorio = new FrmRelatorio(clienteRMI, null);
        relatorio.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(FrmBalancoFisico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBalancoFisico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBalancoFisico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBalancoFisico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBalancoFisico().setVisible(true);
            }
        });
    }

    private javax.swing.JButton JBFechar;
    private javax.swing.JButton JBFiltrar;
    private javax.swing.JButton JBSalvar;
    private javax.swing.JButton JBSalvar1;
    private javax.swing.JButton JBSalvar2;
    private javax.swing.JButton JBSalvar3;
    private javax.swing.JLabel JLTotal;
    private javax.swing.JTable JTBalanco;
    private javax.swing.JTextField JTFBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;

}
