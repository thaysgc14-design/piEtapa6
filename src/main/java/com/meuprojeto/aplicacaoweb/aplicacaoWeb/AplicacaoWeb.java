package com.meuprojeto.aplicacaoweb.aplicacaoWeb;

import com.meuprojeto.aplicacaoweb.Classes.Cliente;
import com.meuprojeto.aplicacaoweb.Classes.ClienteService;
import com.meuprojeto.aplicacaoweb.Classes.Usuario;
import com.meuprojeto.aplicacaoweb.Classes.UsuarioService;

/**
 *
 * @author thays
 */
public class AplicacaoWeb {

    public static void main(String[] args) {
        System.out.println("=== TESTANDO CAMADA DE SERVIÇO E DAO ===");

        try {
            // Teste de Cadastro de Usuário
            UsuarioService usuarioService = new UsuarioService();
            Usuario user = new Usuario("Teste Web", "01/01/2000", "Admin", "admin.test", "123456");
            usuarioService.salvarUsuario(user);
            System.out.println("✓ Usuário cadastrado com sucesso!");

            // Teste de Autenticação
            Usuario logado = usuarioService.autenticarUsuario("admin.test", "123456");
            System.out.println("✓ Login efetuado com sucesso para: " + logado.getNomeUsu());

            // Teste de Cadastro de Cliente
            ClienteService clienteService = new ClienteService();
            Cliente cliente = new Cliente("Cliente Teste", "123.456.789-00", "10/10/1995", "11999998888");
            clienteService.salvarCliente(cliente);
            System.out.println("✓ Cliente cadastrado com sucesso!");

        } catch (Exception e) {
            System.err.println("x Erro durante os testes: " + e.getMessage());
        }
    }
}
