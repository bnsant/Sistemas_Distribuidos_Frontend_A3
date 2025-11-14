package cliente;

import javax.swing.SwingUtilities;
import visao.FrmTelaPrincipal;

public class Main {

    public static void main(String[] args) {
        ClienteRMI cliente = new ClienteRMI();

        SwingUtilities.invokeLater(() -> {
            FrmTelaPrincipal tela = new FrmTelaPrincipal(cliente);
            tela.setVisible(true);
        });
    }
}
