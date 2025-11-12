package cliente;

import java.rmi.Naming;
import service.EstoqueService;

public class ClienteRMI {
    
    private EstoqueService estoqueService;
    private String host;
    private int porta;
    private boolean conectado = false;
    
    public ClienteRMI() {
        this("localhost", 1099);
    }
    
    public ClienteRMI(String host, int porta) {
        this.host = host;
        this.porta = porta;
    }
    
    public boolean conectar() {
        try {
            String url = "rmi://" + host + ":" + porta + "/EstoqueService";
            estoqueService = (EstoqueService) Naming.lookup(url);
            conectado = true;
            return true;
        } catch (Exception e) {
            conectado = false;
            return false;
        }
    }
    
    public EstoqueService getService() {
        return estoqueService;
    }
    
    public boolean estaConectado() {
        return conectado && estoqueService != null;
    }
    
    public void desconectar() {
        estoqueService = null;
        conectado = false;
    }
}

