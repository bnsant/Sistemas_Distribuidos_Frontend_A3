package cliente;

import java.rmi.Naming;
import java.rmi.RemoteException;
import service.EstoqueService;

public class ClienteRMI {
    
    private EstoqueService estoqueService;
    private static final String SERVER_URL = "rmi://localhost:1099/EstoqueService";
    private boolean conectado = false;
    
    public boolean conectar() {
        try {
            estoqueService = (EstoqueService) Naming.lookup(SERVER_URL);
            conectado = true;
            System.out.println("✅ Cliente RMI conectado ao servidor com sucesso!");
            return true;
        } catch (Exception e) {
            System.err.println("❌ Erro ao conectar ao servidor RMI: " + e.getMessage());
            System.err.println("   Verifique se o servidor está rodando em: " + SERVER_URL);
            e.printStackTrace();
            conectado = false;
            return false;
        }
    }
    
    public boolean conectar(String host, int porta) {
        try {
            String url = "rmi://" + host + ":" + porta + "/EstoqueService";
            estoqueService = (EstoqueService) Naming.lookup(url);
            conectado = true;
            System.out.println("✅ Cliente RMI conectado ao servidor em " + url);
            return true;
        } catch (Exception e) {
            System.err.println("❌ Erro ao conectar ao servidor RMI: " + e.getMessage());
            e.printStackTrace();
            conectado = false;
            return false;
        }
    }
    
    public EstoqueService getService() throws Exception {
        if (!conectado || estoqueService == null) {
            throw new Exception("Cliente não está conectado ao servidor. Chame o método conectar() primeiro.");
        }
        return estoqueService;
    }
    
    public boolean estaConectado() {
        return conectado && estoqueService != null;
    }
    
    public void desconectar() {
        estoqueService = null;
        conectado = false;
        System.out.println("Cliente RMI desconectado do servidor.");
    }
    
    public boolean testarConexao() {
        try {
            if (!estaConectado()) {
                System.err.println("❌ Cliente não está conectado.");
                return false;
            }
            
            estoqueService.listarProdutos();
            System.out.println("✅ Teste de conexão bem-sucedido!");
            return true;
        } catch (RemoteException e) {
            System.err.println("❌ Erro ao testar conexão: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public static void main(String[] args) {
        ClienteRMI cliente = new ClienteRMI();
        
        System.out.println("=== Teste de Conexão RMI ===");
        System.out.println("Tentando conectar ao servidor: " + SERVER_URL);
        
        if (cliente.conectar()) {
            System.out.println("\n=== Testando operações do serviço ===");
            
            if (cliente.testarConexao()) {
                try {
                    EstoqueService service = cliente.getService();
                    
                    System.out.println("\n--- Listando produtos ---");
                    var produtos = service.listarProdutos();
                    System.out.println("Total de produtos: " + produtos.size());
                    
                    System.out.println("\n--- Listando categorias ---");
                    var categorias = service.listarCategorias();
                    System.out.println("Total de categorias: " + categorias.size());
                    
                    System.out.println("\n--- Calculando valor total do estoque ---");
                    double valorTotal = service.calcularValorTotalEstoque();
                    System.out.println("Valor total do estoque: R$ " + valorTotal);
                    
                } catch (Exception e) {
                    System.err.println("❌ Erro ao executar testes: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        } else {
            System.err.println("\n❌ Não foi possível conectar ao servidor.");
            System.err.println("   Certifique-se de que o servidor RMI está rodando.");
        }
    }
}

