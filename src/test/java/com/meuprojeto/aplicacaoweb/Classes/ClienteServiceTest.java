
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
    
}
