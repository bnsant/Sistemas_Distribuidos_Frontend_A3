package cliente;

import javax.swing.SwingUtilities;
import visao.FrmTelaPrincipal;

/**
 * Classe principal que inicia a aplicação cliente do sistema de controle de estoque.
 * Cria uma instância do cliente RMI e exibe a tela principal da aplicação.
 * 
 * @author Sistema de Controle de Estoque
 * @version 1.0
 */
public class Main {
    
    /**
     * Método principal que inicia a aplicação.
     * Cria o cliente RMI e inicializa a interface gráfica na thread de eventos Swing.
     * 
     * @param args Argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        ClienteRMI cliente = new ClienteRMI();
        SwingUtilities.invokeLater(() -> {
            FrmTelaPrincipal frame = new FrmTelaPrincipal(cliente);
            frame.setVisible(true);
        });
    }
}