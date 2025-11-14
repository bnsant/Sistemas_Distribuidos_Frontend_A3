package visao;

import cliente.ClienteRMI;
import service.EstoqueService;
import javax.swing.JOptionPane;
import java.util.List;
import modelo.Produto;
import modelo.Categoria;

/**
 * Tela principal de relatórios do sistema de controle de estoque.
 * Fornece acesso a diferentes tipos de relatórios: lista de preços,
 * balanço físico-financeiro, produtos abaixo do mínimo e quantidade por categoria.
 * 
 * @author Sistema de Controle de Estoque
 * @version 1.0
 */
public class FrmRelatorio extends javax.swing.JFrame {

    /**
     * Serviço remoto de estoque para comunicação com o servidor RMI.
     */
    private EstoqueService estoqueService;
    
    /**
     * Cliente RMI para gerenciar a conexão com o servidor.
     */
    private ClienteRMI clienteRMI;
    
    /**
     * Referência à janela anterior para retorno.
     */
    private javax.swing.JFrame janelaAnterior;
    
    /**
     * Construtor padrão que inicializa apenas os componentes da interface.
     */
    public FrmRelatorio() {
        initComponents();
    }
    
    /**
     * Construtor que recebe cliente RMI e janela anterior.
     * 
     * @param cliente Cliente RMI para comunicação com o servidor
     * @param anterior Janela anterior para retorno
     */
    public FrmRelatorio(ClienteRMI cliente, javax.swing.JFrame anterior) {
        initComponents();
        this.clienteRMI = cliente;
        this.janelaAnterior = anterior;
        if (!clienteRMI.estaConectado() && !clienteRMI.conectar()) {
            JOptionPane.showMessageDialog(this, 
                "Não foi possível conectar ao servidor RMI.",
                "Erro de Conexão", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Construtor que recebe o serviço de estoque diretamente.
     * 
     * @param estoqueService Serviço remoto de estoque
     */
    public FrmRelatorio(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
        initComponents();
        carregarRelatorio();
    }
    
    /**
     * Carrega dados iniciais do relatório.
     */
    private void carregarRelatorio() {
        if (estoqueService == null) {
            JOptionPane.showMessageDialog(this, "Servidor não conectado!");
            return;
        }
        
        try {
            List<Produto> produtos = estoqueService.listarProdutos();
            List<Categoria> categorias = estoqueService.listarCategorias();
            int totalProdutos = produtos.size();
            int totalCategorias = categorias.size();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar relatório: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JBListadePreco = new javax.swing.JToggleButton();
        JBBalanço = new javax.swing.JToggleButton();
        JBProdutosAbaixo = new javax.swing.JToggleButton();
        JBQuantidadeProdutoCategoria = new javax.swing.JToggleButton();
        JBFechar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));jLabel1.setText("Relatórios");

        JBListadePreco.setText("Lista de preços");
        JBListadePreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBListadePrecoActionPerformed(evt);
            }
        });

        JBBalanço.setText("Balanço Físico-Financeiro");
        JBBalanço.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBalançoActionPerformed(evt);
            }
        });

        JBProdutosAbaixo.setText("Produtos Abaixo do Mínimo/Máximo");
        JBProdutosAbaixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBProdutosAbaixoActionPerformed(evt);
            }
        });

        JBQuantidadeProdutoCategoria.setText("Quantidade de Produtos por Categoria");
        JBQuantidadeProdutoCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBQuantidadeProdutoCategoriaActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JBBalanço, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JBListadePreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JBProdutosAbaixo, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(JBQuantidadeProdutoCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(JBFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel1)))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addComponent(JBListadePreco)
                .addGap(18, 18, 18)
                .addComponent(JBBalanço)
                .addGap(18, 18, 18)
                .addComponent(JBProdutosAbaixo)
                .addGap(18, 18, 18)
                .addComponent(JBQuantidadeProdutoCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBFechar)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        pack();
    }

    /**
     * Trata o evento de clique no botão Lista de Preços.
     * Abre a tela de lista de preços dos produtos.
     * 
     * @param evt Evento de ação do botão
     */
    private void JBListadePrecoActionPerformed(java.awt.event.ActionEvent evt) {
        if (clienteRMI != null) {
            FrmListaDePreco listaPreco = new FrmListaDePreco(clienteRMI);
            listaPreco.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Servidor não conectado!");
        }
    }

    /**
     * Trata o evento de clique no botão Balanço Físico-Financeiro.
     * Abre a tela de balanço físico e financeiro do estoque.
     * 
     * @param evt Evento de ação do botão
     */
    private void JBBalançoActionPerformed(java.awt.event.ActionEvent evt) {
        if (clienteRMI != null) {
            FrmBalancoFisico balanco = new FrmBalancoFisico(clienteRMI);
            balanco.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Servidor não conectado!");
        }
    }

    /**
     * Trata o evento de clique no botão Produtos Abaixo do Mínimo.
     * Exibe uma mensagem com a lista de produtos que estão com estoque abaixo do mínimo.
     * 
     * @param evt Evento de ação do botão
     */
    private void JBProdutosAbaixoActionPerformed(java.awt.event.ActionEvent evt) {
        if (estoqueService != null) {
            try {
                List<Produto> produtosAbaixo = estoqueService.listarProdutosAbaixoMinimo();
                StringBuilder mensagem = new StringBuilder();
                mensagem.append("Produtos abaixo do mínimo:\n\n");
                if (produtosAbaixo.isEmpty()) {
                    mensagem.append("Nenhum produto abaixo do mínimo.");
                } else {
                    for (Produto p : produtosAbaixo) {
                        mensagem.append("- ").append(p.getNome()).append(" (Estoque: ").append(p.getQuantidade()).append(", Mínimo: ").append(p.getMin()).append(")\n");
                    }
                }
                JOptionPane.showMessageDialog(this, mensagem.toString(), "Produtos Abaixo do Mínimo", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao buscar produtos: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Servidor não conectado!");
        }
    }

    /**
     * Trata o evento de clique no botão Quantidade de Produtos por Categoria.
     * Exibe uma mensagem com a quantidade de produtos agrupados por categoria.
     * 
     * @param evt Evento de ação do botão
     */
    private void JBQuantidadeProdutoCategoriaActionPerformed(java.awt.event.ActionEvent evt) {
        if (estoqueService != null) {
            try {
                List<String[]> quantidadePorCategoria = estoqueService.listarQuantidadePorCategoria();
                StringBuilder mensagem = new StringBuilder();
                mensagem.append("Quantidade de Produtos por Categoria:\n\n");
                if (quantidadePorCategoria.isEmpty()) {
                    mensagem.append("Nenhuma categoria encontrada.");
                } else {
                    for (String[] item : quantidadePorCategoria) {
                        if (item.length >= 2) {
                            mensagem.append("- ").append(item[0]).append(": ").append(item[1]).append(" produtos\n");
                        }
                    }
                }
                JOptionPane.showMessageDialog(this, mensagem.toString(), "Quantidade por Categoria", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao buscar quantidade por categoria: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Servidor não conectado!");
        }
    }
    
    /**
     * Trata o evento de clique no botão Fechar.
     * Retorna para a janela anterior e fecha a tela de relatórios.
     * 
     * @param evt Evento de ação do botão
     */
    private void JBFecharActionPerformed(java.awt.event.ActionEvent evt) {
        if (janelaAnterior != null) {
            janelaAnterior.setVisible(true);
        }
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
            java.util.logging.Logger.getLogger(FrmRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRelatorio().setVisible(true);
            }
        });
    }

    private javax.swing.JToggleButton JBBalanço;
    private javax.swing.JToggleButton JBFechar;
    private javax.swing.JToggleButton JBListadePreco;
    private javax.swing.JToggleButton JBProdutosAbaixo;
    private javax.swing.JToggleButton JBQuantidadeProdutoCategoria;
    private javax.swing.JLabel jLabel1;

}
