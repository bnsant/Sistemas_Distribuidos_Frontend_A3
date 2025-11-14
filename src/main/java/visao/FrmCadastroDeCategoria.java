/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import cliente.ClienteRMI;
import modelo.Categoria;
import service.EstoqueService;
import javax.swing.JOptionPane;
import java.rmi.RemoteException;

/**
 * Tela para cadastro e edição de categorias no sistema de controle de estoque.
 * Permite criar novas categorias ou editar categorias existentes.
 * 
 * @author Sistema de Controle de Estoque
 * @version 1.0
 */
public class FrmCadastroDeCategoria extends javax.swing.JFrame {

    /**
     * Cliente RMI para comunicação com o servidor.
     */
    private ClienteRMI clienteRMI;
    
    /**
     * Referência à janela anterior para retorno após salvar ou cancelar.
     */
    private javax.swing.JFrame janelaAnterior;
    
    /**
     * ID da categoria em edição, 0 se for um novo cadastro.
     */
    private int idCategoria;
    
    /**
     * Construtor padrão que inicializa a tela e cria uma nova conexão RMI.
     */
    public FrmCadastroDeCategoria() {
        initComponents();
        clienteRMI = new ClienteRMI();
        idCategoria = 0;
        if (!clienteRMI.conectar()) {
            JOptionPane.showMessageDialog(this, 
                "Não foi possível conectar ao servidor RMI.",
                "Erro de Conexão", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Construtor que recebe a janela anterior para novo cadastro.
     * 
     * @param anterior Janela anterior para retorno após salvar ou cancelar
     */
    public FrmCadastroDeCategoria(javax.swing.JFrame anterior) {
        initComponents();
        clienteRMI = new ClienteRMI();
        this.janelaAnterior = anterior;
        idCategoria = 0;
        if (!clienteRMI.conectar()) {
            JOptionPane.showMessageDialog(this, 
                "Não foi possível conectar ao servidor RMI.",
                "Erro de Conexão", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Construtor que recebe a janela anterior e categoria para edição.
     * 
     * @param anterior Janela anterior para retorno após salvar ou cancelar
     * @param categoria Categoria a ser editada
     */
    public FrmCadastroDeCategoria(javax.swing.JFrame anterior, Categoria categoria) {
        initComponents();
        clienteRMI = new ClienteRMI();
        this.janelaAnterior = anterior;
        this.idCategoria = categoria.getId();
        if (!clienteRMI.conectar()) {
            JOptionPane.showMessageDialog(this, 
                "Não foi possível conectar ao servidor RMI.",
                "Erro de Conexão", 
                JOptionPane.ERROR_MESSAGE);
        } else {
            preencherCampos(categoria);
        }
    }
    
    /**
     * Preenche os campos do formulário com os dados da categoria.
     * 
     * @param categoria Categoria com os dados a serem exibidos
     */
    private void preencherCampos(Categoria categoria) {
        JTFNomeCategoria.setText(categoria.getNomeCategoria());
        JCBTamanho.setSelectedItem(categoria.getTamanho());
        JCBEmbalagem.setSelectedItem(categoria.getEmbalagem());
    }

    
    @SuppressWarnings("unchecked")

    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        JBSalvar = new javax.swing.JButton();
        JBLimpar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JBCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JTFNomeCategoria = new javax.swing.JTextField();
        JCBTamanho = new javax.swing.JComboBox<>();
        JCBEmbalagem = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JBSalvar.setText("💾 Salvar");
        JBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSalvarActionPerformed(evt);
            }
        });

        JBLimpar.setText("🗑️ Limpar");
        JBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimparActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));jLabel1.setText("Cadastro de Categoria");

        JBCancelar.setText("✖ Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12));jLabel2.setText("Nome da Categoria:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12));jLabel3.setText("Tamanho:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12));jLabel4.setText("Embalagem:");

        JTFNomeCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNomeCategoriaActionPerformed(evt);
            }
        });

        JCBTamanho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pequeno", "Médio", "Grande" }));
        JCBTamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBTamanhoActionPerformed(evt);
            }
        });

        JCBEmbalagem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lata", "Vidro", "Plástico", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCBEmbalagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCBTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFNomeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(JBSalvar)
                .addGap(83, 83, 83)
                .addComponent(JBLimpar)
                .addGap(74, 74, 74)
                .addComponent(JBCancelar)
                .addGap(105, 105, 105))
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTFNomeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JCBTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(JCBEmbalagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBSalvar)
                    .addComponent(JBLimpar)
                    .addComponent(JBCancelar))
                .addGap(14, 14, 14))
        );

        pack();
    }

    private void JBSalvarActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            String nome = JTFNomeCategoria.getText().trim();
            String tamanho = JCBTamanho.getSelectedItem().toString();
            String embalagem = JCBEmbalagem.getSelectedItem().toString();

            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha o nome da categoria.");
                return;
            }

            try {
                EstoqueService service = clienteRMI.getService();
                Categoria categoria;

                if (idCategoria == 0) {
                    categoria = new Categoria(nome, tamanho, embalagem);
                    service.criarCategoria(categoria);
                    JOptionPane.showMessageDialog(this, "Categoria salva com sucesso!");
                } else {
                    categoria = new Categoria(idCategoria, nome, tamanho, embalagem);
                    service.atualizarCategoria(categoria);
                    JOptionPane.showMessageDialog(this, "Categoria atualizada com sucesso!");
                }

                if (janelaAnterior instanceof FrmListadeCategoria) {
                    ((FrmListadeCategoria) janelaAnterior).carregarTabela();
                    janelaAnterior.setVisible(true);
                }

                this.dispose();
            } catch (RemoteException e) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar categoria: " + e.getMessage());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void JBLimparActionPerformed(java.awt.event.ActionEvent evt) {
        JTFNomeCategoria.setText("");
        JCBTamanho.setSelectedIndex(0);
        JCBEmbalagem.setSelectedIndex(0);

        JTFNomeCategoria.requestFocus();
    }

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        if (janelaAnterior != null) {
            janelaAnterior.setVisible(true);
        }
        this.dispose();
    }

    private void JTFNomeCategoriaActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void JCBTamanhoActionPerformed(java.awt.event.ActionEvent evt) {

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
            java.util.logging.Logger.getLogger(FrmCadastroDeCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroDeCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroDeCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroDeCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroDeCategoria().setVisible(true);
            }
        });
    }

    private javax.swing.JButton JBCancelar;
    private javax.swing.JButton JBLimpar;
    private javax.swing.JButton JBSalvar;
    private javax.swing.JComboBox<String> JCBEmbalagem;
    private javax.swing.JComboBox<String> JCBTamanho;
    private javax.swing.JTextField JTFNomeCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;

}
