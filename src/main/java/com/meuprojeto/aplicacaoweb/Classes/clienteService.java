package com.meuprojeto.aplicacaoweb.Classes;

import java.util.List;

public class ClienteService {

    public ClienteDAO clienteDao;

    public ClienteService() {
        this.clienteDao = new ClienteDAO();
    }
    public List<Cliente> buscarTodosClientes() {
    return clienteDao.listarClientes();
}

    public void salvarCliente(Cliente cliente) throws IllegalArgumentException {

        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Informe o nome do Cliente.");
        }
        String CPFC = cliente.getCPF().replaceAll("[^0-9]", "");
        if (CPFC.length() != 11) {
            throw new IllegalArgumentException("O CPF precisa ter exatos 11 dígitos.");

        }
        String cpfFormatado = CPFC.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        cliente.setCPF(cpfFormatado);
        
        if (cliente.getDataNasc() == null || cliente.getDataNasc().length() != 10) {
            throw new IllegalArgumentException("A data precisa estar no formato dd/mm/aaaa.");
        }
        if (cliente.getTelefoneCli() == null || cliente.getTelefoneCli().trim().length() < 10) {
            throw new IllegalArgumentException("O Telefone está inválido ou incompleto.");
        }
        int resultado = clienteDao.salvar(cliente);
        
        if (resultado == 0) {
            throw new RuntimeException("Erro interno ao tentar salvar o cliente no banco de dados.");
        }

    }

}
