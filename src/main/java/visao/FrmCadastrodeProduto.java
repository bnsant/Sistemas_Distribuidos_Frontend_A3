/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import cliente.ClienteRMI;
import modelo.Produto;
import modelo.Categoria;
import service.EstoqueService;
import javax.swing.JOptionPane;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Tela para cadastro e edição de produtos no sistema de controle de estoque.
 * Permite criar novos produtos ou editar produtos existentes, validando
 * os dados informados antes de salvar no servidor.
 * 
 * @author Sistema de Controle de Estoque
 * @version 1.0
 */
public class FrmCadastrodeProduto extends javax.swing.JFrame {

    /**
     * Cliente RMI para comunicação com o servidor.
     */
    private ClienteRMI clienteRMI;
    
    /**
     * Referência à tela anterior para retorno após salvar ou cancelar.
     */
    private javax.swing.JFrame telaAnterior;
    
    /**
     * Produto em edição, null se for um novo cadastro.
     */
    private Produto produtoEmEdicao;
    
    /**
     * Construtor padrão que inicializa a tela e cria uma nova conexão RMI.
     */
    public FrmCadastrodeProduto() {
        initComponents();
        clienteRMI = new ClienteRMI();
        if (!clienteRMI.conectar()) {
            JOptionPane.showMessageDialog(this, 
                "Não foi possível conectar ao servidor RMI.",
                "Erro de Conexão", 
                JOptionPane.ERROR_MESSAGE);
        } else {
            carregarCategorias();
        }
    }
    
    /**
     * Construtor que recebe cliente RMI, tela anterior e produto para edição.
     * 
     * @param cliente Cliente RMI para comunicação com o servidor
     * @param anterior Tela anterior para retorno após salvar ou cancelar
     * @param produto Produto a ser editado, ou null para novo cadastro
     */
    public FrmCadastrodeProduto(ClienteRMI cliente, javax.swing.JFrame anterior, Produto produto) {
        initComponents();
        this.clienteRMI = cliente;
        this.telaAnterior = anterior;
        this.produtoEmEdicao = produto;
        
        if (!clienteRMI.estaConectado() && !clienteRMI.conectar()) {
            JOptionPane.showMessageDialog(this, 
                "Não foi possível conectar ao servidor RMI.",
                "Erro de Conexão", 
                JOptionPane.ERROR_MESSAGE);
        } else {
            carregarCategorias();
            if (produto != null) {
                preencherCampos(produto);
            }
        }
    }
    
    /**
     * Carrega as categorias do servidor e popula o combo box.
     * Se não houver categorias, usa categorias padrão.
     */
    private void carregarCategorias() {
        try {
            EstoqueService service = clienteRMI.getService();
            List<Categoria> categorias = service.listarCategorias();
            List<String> nomesCategorias = new ArrayList<>();
            for (Categoria cat : categorias) {
                nomesCategorias.add(cat.getNomeCategoria());
            }
            if (nomesCategorias.isEmpty()) {
                nomesCategorias.add("Bebidas");
                nomesCategorias.add("Alimentos");
                nomesCategorias.add("Higiene");
                nomesCategorias.add("Limpeza");
            }
            JCBCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(nomesCategorias.toArray(new String[0])));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar categorias: " + e.getMessage());
            JCBCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bebidas", "Alimentos", "Higiene", "Limpeza" }));
        }
    }
    
    /**
     * Preenche os campos do formulário com os dados do produto.
     * 
     * @param produto Produto com os dados a serem exibidos
     */
    private void preencherCampos(Produto produto) {
        JTFNome.setText(produto.getNome());
        JTFPreco.setText(String.valueOf(produto.getPreco()));
        JTFQuantidade.setText(String.valueOf(produto.getQuantidade()));
        JTFUnidade.setText(produto.getUnidade());
        JTFMin.setText(String.valueOf(produto.getMin()));
        JTFMax.setText(String.valueOf(produto.getMax()));
        JCBCategoria.setSelectedItem(produto.getCategoria());
    }

    
    @SuppressWarnings("unchecked")

    private void initComponents() {

        JCBCategoria = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JTFNome = new javax.swing.JTextField();
        JTFPreco = new javax.swing.JTextField();
        JTFMax = new javax.swing.JTextField();
        JTFUnidade = new javax.swing.JTextField();
        Nome = new javax.swing.JLabel();
        JTFQuantidade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTFMin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JBSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        JBCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JCBCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bebidas", "Alimentos", "Higiene", "Limpeza" }));
        JCBCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBCategoriaActionPerformed(evt);
            }
        });

        jLabel6.setText("Minimo");

        jLabel7.setText("Maximo");

        JTFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNomeActionPerformed(evt);
            }
        });

        Nome.setText("Nome");

        jLabel2.setText("Preço");

        jLabel3.setText("Unidade");

        JBSalvar.setText("Salvar");
        JBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSalvarActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantidade");

        JBCancelar.setBackground(new java.awt.Color(220, 53, 69));
        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Categoria");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nome))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(JTFPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(JTFUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(JCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(JTFMin, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(JTFMax, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(JBSalvar)
                        .addGap(39, 39, 39)
                        .addComponent(JBCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nome)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBSalvar)
                    .addComponent(JBCancelar))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        pack();
    }

    private void JCBCategoriaActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void JTFNomeActionPerformed(java.awt.event.ActionEvent evt) {

    }

    /**
     * Trata o evento de clique no botão Salvar.
     * Valida os dados informados e salva o produto no servidor (cria novo ou atualiza existente).
     * 
     * @param evt Evento de ação do botão
     */
    private void JBSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        if (JTFNome.getText().isEmpty()
            || JTFUnidade.getText().isEmpty()
            || JTFPreco.getText().isEmpty()
            || JTFQuantidade.getText().isEmpty()
            || JTFMin.getText().isEmpty()
            || JTFMax.getText().isEmpty()
            || JCBCategoria.getSelectedItem() == null) {

            JOptionPane.showMessageDialog(this,
                "Por favor, preencha todos os campos antes de salvar.",
                "Campos obrigatórios",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double preco = Double.parseDouble(JTFPreco.getText());
            int quantidade = Integer.parseInt(JTFQuantidade.getText());
            int min = Integer.parseInt(JTFMin.getText());
            int max = Integer.parseInt(JTFMax.getText());

            if (preco < 0 || quantidade < 0) {
                JOptionPane.showMessageDialog(this,
                    "Preço e quantidade não podem ser negativos.",
                    "Erro de validação",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (min > max) {
                JOptionPane.showMessageDialog(this,
                    "O valor mínimo não pode ser maior que o máximo.",
                    "Erro de validação",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            String nome = JTFNome.getText();
            String unidade = JTFUnidade.getText();
            String categoria = JCBCategoria.getSelectedItem().toString();

            try {
                EstoqueService service = clienteRMI.getService();

                if (produtoEmEdicao == null) {
                    Produto novoProduto = new Produto(0, nome, unidade, preco, quantidade, min, max, categoria);
                    service.criarProduto(novoProduto);
                    JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
                } else {
                    produtoEmEdicao.setNome(nome);
                    produtoEmEdicao.setUnidade(unidade);
                    produtoEmEdicao.setPreco(preco);
                    produtoEmEdicao.setQuantidade(quantidade);
                    produtoEmEdicao.setMin(min);
                    produtoEmEdicao.setMax(max);
                    produtoEmEdicao.setCategoria(categoria);
                    service.atualizarProduto(produtoEmEdicao);
                    JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!");
                }

                if (telaAnterior instanceof FrmListaDePreco precoTela) {
                    precoTela.carregarTabela();
                    precoTela.setVisible(true);
                } else if (telaAnterior instanceof FrmListadeProduto produtoTela) {
                    produtoTela.carregarTabelaProdutos();
                    produtoTela.setVisible(true);
                }
                this.dispose();
            } catch (RemoteException e) {
                JOptionPane.showMessageDialog(this,
                    "Erro ao salvar produto: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(FrmCadastrodeProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Erro: Preço, Quantidade, Mínimo e Máximo devem conter apenas números válidos.",
                "Erro de validação",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Trata o evento de clique no botão Cancelar.
     * Retorna para a tela anterior e fecha a janela de cadastro.
     * 
     * @param evt Evento de ação do botão
     */
    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        if (telaAnterior != null) {
            telaAnterior.setVisible(true);
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
            java.util.logging.Logger.getLogger(FrmCadastrodeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrodeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrodeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrodeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastrodeProduto().setVisible(true);
            }
        });
    }

    private javax.swing.JButton JBCancelar;
    private javax.swing.JButton JBSalvar;
    private javax.swing.JComboBox<String> JCBCategoria;
    private javax.swing.JTextField JTFMax;
    private javax.swing.JTextField JTFMin;
    private javax.swing.JTextField JTFNome;
    private javax.swing.JTextField JTFPreco;
    private javax.swing.JTextField JTFQuantidade;
    private javax.swing.JTextField JTFUnidade;
    private javax.swing.JLabel Nome;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;

}
