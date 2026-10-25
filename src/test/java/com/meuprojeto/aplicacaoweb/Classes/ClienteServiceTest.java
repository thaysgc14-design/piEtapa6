
package com.meuprojeto.aplicacaoweb.Classes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteServiceTest {
    private ClienteService clienteService;
    
    @BeforeEach
    public void setUp() {
        // Inicializa a classe de serviço antes de cada teste
        clienteService = new ClienteService();
    }
    
    @Test
    @DisplayName("Deve formatar o CPF corretamente com pontos e traço quando o CPF contiver 11 dígitos numéricos")
    public void deveFormatarCpfCorretamente() {
        Cliente cliente = new Cliente("João da Silva", "12345678901", "10/10/1990", "11988887777");

        // Executa a validação em memória
        clienteService.validarRegrasCliente(cliente);

        // Verifica se a máscara do CPF foi aplicada
        assertEquals("123.456.789-01", cliente.getCPF());
    }
    
    @Test
    @DisplayName("Deve lançar exceção quando o CPF possuir menos de 11 dígitos")
    public void deveLancarExcecaoParaCpfInvalido() {
        Cliente cliente = new Cliente("Maria Souza", "12345", "10/10/1990", "11988887777");

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> clienteService.validarRegrasCliente(cliente)
        );

        assertEquals("O CPF precisa ter exatos 11 dígitos.", exception.getMessage());
    }
    
    @Test
    @DisplayName("Deve lançar exceção quando o nome do cliente for nulo ou vazio")
    public void deveLancarExcecaoParaNomeVazio() {
        Cliente cliente = new Cliente("", "12345678901", "10/10/1990", "11988887777");

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> clienteService.validarRegrasCliente(cliente)
        );

        assertEquals("Informe o nome do Cliente.", exception.getMessage());
    }
    
}
