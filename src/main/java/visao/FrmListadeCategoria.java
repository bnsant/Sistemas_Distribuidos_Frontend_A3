/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import cliente.ClienteRMI;
import modelo.Categoria;
import service.EstoqueService;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Tela para listagem e gerenciamento de categorias no sistema de controle de estoque.
 * Permite visualizar, cadastrar, editar e excluir categorias.
 * 
 * @author Sistema de Controle de Estoque
 * @version 1.0
 */
public class FrmListadeCategoria extends javax.swing.JFrame {

    /**
     * Cliente RMI para comunicação com o servidor.
     */
    private ClienteRMI clienteRMI;
    
    /**
     * Referência à janela anterior para retorno.
     */
    private javax.swing.JFrame janelaAnterior;
    
    /**
     * Construtor padrão que inicializa a tela e cria uma nova conexão RMI.
     */
    public FrmListadeCategoria() {
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
    
    /**
     * Construtor que recebe cliente RMI e janela anterior.
     * 
     * @param cliente Cliente RMI para comunicação com o servidor
     * @param anterior Janela anterior para retorno
     */
    public FrmListadeCategoria(ClienteRMI cliente, javax.swing.JFrame anterior) {
        initComponents();
        this.clienteRMI = cliente;
        this.janelaAnterior = anterior;
        if (!clienteRMI.estaConectado() && !clienteRMI.conectar()) {
            JOptionPane.showMessageDialog(this, 
                "Não foi possível conectar ao servidor RMI.",
                "Erro de Conexão", 
                JOptionPane.ERROR_MESSAGE);
        } else {
            carregarTabela();
        }
    }
    
    /**
     * Carrega a lista de categorias do servidor e exibe na tabela.
     */
    public void carregarTabela() {
        try {
            EstoqueService service = clienteRMI.getService();
            List<Categoria> categorias = service.listarCategorias();
            
            DefaultTableModel modelo = (DefaultTableModel) JTListaCategoria.getModel();
            modelo.setRowCount(0);
            
            for (Categoria c : categorias) {
                modelo.addRow(new Object[]{
                    c.getId(),
                    c.getNomeCategoria(),
                    c.getTamanho(),
                    c.getEmbalagem()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar categorias: " + e.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JBAdicionar = new javax.swing.JButton();
        JBEditar = new javax.swing.JButton();
        JBVoltarLC = new javax.swing.JButton();
        JBExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTListaCategoria = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));jLabel1.setText("Lista de Categoria");

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

        JBVoltarLC.setText("Voltar");
        JBVoltarLC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarLCActionPerformed(evt);
            }
        });

        JBExcluir.setBackground(new java.awt.Color(220, 53, 69));
        JBExcluir.setText("Excluir");
        JBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBExcluirActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(256, 256, 256))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(JBAdicionar)
                        .addGap(64, 64, 64)
                        .addComponent(JBEditar)
                        .addGap(66, 66, 66)
                        .addComponent(JBVoltarLC)
                        .addGap(66, 66, 66)
                        .addComponent(JBExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBAdicionar)
                    .addComponent(JBEditar)
                    .addComponent(JBVoltarLC)
                    .addComponent(JBExcluir))
                .addGap(93, 93, 93))
        );

        pack();
    }

    private void JBAdicionarActionPerformed(java.awt.event.ActionEvent evt) {
        FrmCadastroDeCategoria cadastro = new FrmCadastroDeCategoria(this);
        cadastro.setVisible(true);
        this.setVisible(false);
    }

    private void JBEditarActionPerformed(java.awt.event.ActionEvent evt) {
        int linhaSelecionada = JTListaCategoria.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma categoria para editar.");
            return;
        }

        int id = (int) JTListaCategoria.getValueAt(linhaSelecionada, 0);
        String nome = (String) JTListaCategoria.getValueAt(linhaSelecionada, 1);
        String tamanho = (String) JTListaCategoria.getValueAt(linhaSelecionada, 2);
        String embalagem = (String) JTListaCategoria.getValueAt(linhaSelecionada, 3);

        Categoria categoria = new Categoria(id, nome, tamanho, embalagem);

        FrmCadastroDeCategoria telaEdicao = new FrmCadastroDeCategoria(this, categoria);
        telaEdicao.setVisible(true);
    }

    private void JBVoltarLCActionPerformed(java.awt.event.ActionEvent evt) {
        if (janelaAnterior != null) {
            janelaAnterior.setVisible(true);
        }
        dispose();
    }

    private void JBExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        int linhaSelecionada = JTListaCategoria.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma categoria para excluir.");
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir essa categoria?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirmacao != JOptionPane.YES_OPTION) {
            return;
        }

        int idCategoria = (int) JTListaCategoria.getValueAt(linhaSelecionada, 0); // ID na coluna 0

        try {
            EstoqueService service = clienteRMI.getService();
            service.excluirCategoria(idCategoria);

            JOptionPane.showMessageDialog(this, "Categoria excluída com sucesso!");
            carregarTabela();

        } catch (RemoteException e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir categoria: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(FrmListadeCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(FrmListadeCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListadeCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListadeCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListadeCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListadeCategoria().setVisible(true);
            }
        });
    }

    private javax.swing.JButton JBAdicionar;
    private javax.swing.JButton JBEditar;
    private javax.swing.JButton JBExcluir;
    private javax.swing.JButton JBVoltarLC;
    private javax.swing.JTable JTListaCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;

}
