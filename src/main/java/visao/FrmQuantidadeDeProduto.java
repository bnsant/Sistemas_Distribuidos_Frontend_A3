package visao;

import service.EstoqueService;
import javax.swing.JOptionPane;
import java.util.List;
import modelo.Produto;
import javax.swing.table.DefaultTableModel;

public class FrmQuantidadeDeProduto extends javax.swing.JFrame {

    private EstoqueService estoqueService;
    private List<Produto> produtosLista;
    
    public FrmQuantidadeDeProduto() {
        initComponents();
    }
    
    public FrmQuantidadeDeProduto(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
        initComponents();
        carregarProdutos();
    }
    
    private void carregarProdutos() {
        if (estoqueService == null) {
            JOptionPane.showMessageDialog(this, "Servidor não conectado!");
            return;
        }
        
        try {
            produtosLista = estoqueService.listarProdutos();
            DefaultTableModel modelo = (DefaultTableModel) JTQuantidadeProdutoCategoria.getModel();
            modelo.setRowCount(0);
            
            for (Produto p : produtosLista) {
                modelo.addRow(new Object[]{
                    p.getNome(),
                    p.getQuantidade()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTQuantidadeProdutoCategoria = new javax.swing.JTable();
        JBAtualizar = new javax.swing.JToggleButton();
        JBFechar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));jLabel1.setText("Quantidade de produto");

        JTQuantidadeProdutoCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Produto", "Quantidade"
            }
        ));
        jScrollPane1.setViewportView(JTQuantidadeProdutoCategoria);

        JBAtualizar.setText("Atualizar");
        JBAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAtualizarActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(JBAtualizar)
                        .addGap(52, 52, 52)
                        .addComponent(JBFechar)))
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBAtualizar)
                    .addComponent(JBFechar))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }

    private void JBAtualizarActionPerformed(java.awt.event.ActionEvent evt) {
        if (estoqueService == null) {
            JOptionPane.showMessageDialog(this, "Servidor não conectado!");
            return;
        }
        
        try {
            int linhaSelecionada = JTQuantidadeProdutoCategoria.getSelectedRow();
            if (linhaSelecionada == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um produto.");
                return;
            }
            
            String nomeProduto = (String) JTQuantidadeProdutoCategoria.getValueAt(linhaSelecionada, 0);
            Object quantidadeObj = JTQuantidadeProdutoCategoria.getValueAt(linhaSelecionada, 1);
            
            if (nomeProduto == null || quantidadeObj == null) {
                JOptionPane.showMessageDialog(this, "Dados inválidos na tabela.");
                return;
            }
            
            String quantidadeTexto = quantidadeObj.toString().trim();
            if (quantidadeTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Informe a quantidade.");
                return;
            }
            
            int novaQuantidade = Integer.parseInt(quantidadeTexto);
            
            Produto produtoSelecionado = null;
            for (Produto p : produtosLista) {
                if (p.getNome().equals(nomeProduto)) {
                    produtoSelecionado = p;
                    break;
                }
            }
            
            if (produtoSelecionado == null) {
                produtoSelecionado = estoqueService.buscarProdutoPorNome(nomeProduto);
            }
            
            if (produtoSelecionado == null) {
                JOptionPane.showMessageDialog(this, "Produto não encontrado.");
                return;
            }
            
            produtoSelecionado.setQuantidade(novaQuantidade);
            estoqueService.atualizarProduto(produtoSelecionado);
            
            JOptionPane.showMessageDialog(this, "Quantidade atualizada com sucesso!");
            carregarProdutos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida. Digite um número inteiro.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar quantidade: " + e.getMessage());
        }
    }
    
    private void JBFecharActionPerformed(java.awt.event.ActionEvent evt) {
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
            java.util.logging.Logger.getLogger(FrmQuantidadeDeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmQuantidadeDeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmQuantidadeDeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmQuantidadeDeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmQuantidadeDeProduto().setVisible(true);
            }
        });
    }

    private javax.swing.JToggleButton JBAtualizar;
    private javax.swing.JToggleButton JBFechar;
    private javax.swing.JTable JTQuantidadeProdutoCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;

}
