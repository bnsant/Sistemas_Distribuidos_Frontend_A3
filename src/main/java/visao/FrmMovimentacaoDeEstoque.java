package visao;

import service.EstoqueService;
import modelo.Produto;
import modelo.RegistroMovimentacao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FrmMovimentacaoDeEstoque extends javax.swing.JFrame {

    private EstoqueService estoqueService;
    
    public FrmMovimentacaoDeEstoque() {
        initComponents();
    }
    
    public FrmMovimentacaoDeEstoque(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
        initComponents();
        carregarProdutos();
        carregarMovimentacoes();
    }
    
    private void carregarProdutos() {
        if (estoqueService == null) {
            JOptionPane.showMessageDialog(this, "Servidor não conectado!");
            return;
        }
        
        try {
            List<Produto> produtos = estoqueService.listarProdutos();
            JCBProduto.removeAllItems();
            for (Produto p : produtos) {
                JCBProduto.addItem(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + e.getMessage());
        }
    }
    
    private void carregarMovimentacoes() {
        if (estoqueService == null) {
            JOptionPane.showMessageDialog(this, "Servidor não conectado!");
            return;
        }
        
        try {
            List<RegistroMovimentacao> movimentacoes = estoqueService.listarMovimentacoes();
            DefaultTableModel modelo = (DefaultTableModel) JTMovimentacao.getModel();
            modelo.setRowCount(0);
            
            for (RegistroMovimentacao m : movimentacoes) {
                try {
                    Produto produto = estoqueService.buscarProdutoPorId(m.getProdutoId());
                    String nomeProduto = produto != null ? produto.getNome() : "Produto ID: " + m.getProdutoId();
                    int saldo = produto != null ? produto.getQuantidade() : 0;
                    
                    modelo.addRow(new Object[]{
                        m.getDataMovimentacao(),
                        nomeProduto,
                        m.getTipoMovimentacao(),
                        m.getQuantidade(),
                        saldo
                    });
                } catch (Exception e) {
                    modelo.addRow(new Object[]{
                        m.getDataMovimentacao(),
                        "Produto ID: " + m.getProdutoId(),
                        m.getTipoMovimentacao(),
                        m.getQuantidade(),
                        "-"
                    });
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar movimentações: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        JBRegistrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JBRegistrar.setText("Registrar");
        JBRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRegistrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Produto:");

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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));jLabel1.setText("Movimentação de Estoque");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel1)
                .addContainerGap(210, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addComponent(jSeparator2)
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
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(JBRegistrar)
                            .addGap(18, 18, 18)
                            .addComponent(JBLimpar)
                            .addGap(18, 18, 18)
                            .addComponent(JBSair)
                            .addGap(192, 192, 192)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(497, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addGap(37, 37, 37)))
        );

        pack();
    }

    private void JBRegistrarActionPerformed(java.awt.event.ActionEvent evt) {
        if (estoqueService == null) {
            JOptionPane.showMessageDialog(this, "Servidor não conectado!");
            return;
        }
        
        try {
            Produto produto = (Produto) JCBProduto.getSelectedItem();
            if (produto == null) {
                JOptionPane.showMessageDialog(this, "Selecione um produto.");
                return;
            }
            
            String quantidadeTexto = JTFQuantidade.getText().trim();
            if (quantidadeTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Informe a quantidade.");
                return;
            }
            
            int quantidade = Integer.parseInt(quantidadeTexto);
            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(this, "A quantidade deve ser maior que zero.");
                return;
            }
            
            String tipo = JRBEntrada.isSelected() ? "Entrada" : (JRBSaida.isSelected() ? "Saída" : "");
            if (tipo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Selecione o tipo de movimentação (Entrada ou Saída).");
                return;
            }
            
            String data = JTFData.getText().trim();
            if (data.isEmpty()) {
                LocalDate hoje = LocalDate.now();
                data = hoje.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
            
            RegistroMovimentacao movimentacao = new RegistroMovimentacao();
            movimentacao.setProdutoId(produto.getId());
            movimentacao.setTipoMovimentacao(tipo);
            movimentacao.setQuantidade(quantidade);
            movimentacao.setDataMovimentacao(data);
            
            estoqueService.registrarMovimentacao(movimentacao);
            
            if (tipo.equals("Entrada")) {
                produto.setQuantidade(produto.getQuantidade() + quantidade);
            } else {
                produto.setQuantidade(produto.getQuantidade() - quantidade);
            }
            estoqueService.atualizarProduto(produto);
            
            JOptionPane.showMessageDialog(this, tipo + " registrada com sucesso!");
            carregarMovimentacoes();
            JBLimparActionPerformed(null);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida. Digite um número inteiro.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao registrar movimentação: " + e.getMessage());
        }
    }

    private void JBLimparActionPerformed(java.awt.event.ActionEvent evt) {
        JCBProduto.setSelectedIndex(-1);
        JTFQuantidade.setText("");
        JTFData.setText("");
        JRBEntrada.setSelected(false);
        JRBSaida.setSelected(false);
    }

    private void JBSairActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void jScrollPane1AncestorAdded(javax.swing.event.AncestorEvent evt) {
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
            java.util.logging.Logger.getLogger(FrmMovimentacaoDeEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentacaoDeEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentacaoDeEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentacaoDeEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMovimentacaoDeEstoque().setVisible(true);
            }
        });
    }

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

}
