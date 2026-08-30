package com.meuprojeto.aplicacaoweb.Classes;

public class UsuarioService {

    public UsuarioDao usuarioDao;

    public UsuarioService() {
        this.usuarioDao = new UsuarioDao();
    }

    public void salvarUsuario(Usuario usuario) throws IllegalArgumentException {
        if (usuario.getNomeUsu() == null || usuario.getNomeUsu().trim().isEmpty()) {
            throw new IllegalArgumentException("Informe o nome do Usuário.");
        }
        if (usuario.getFuncao() == null || usuario.getFuncao().trim().isEmpty()) {
            throw new IllegalArgumentException("Informe a função do Usuário.");
        }
        if (usuario.getLogin() == null || usuario.getLogin().trim().isEmpty()) {
            throw new IllegalArgumentException("Informe o login do Usuário.");
        }
        if (usuario.getSenha() == null || usuario.getSenha().trim().isEmpty()) {
            throw new IllegalArgumentException("Informe a senha do Usuário.");
        }
        if (usuario.getDataNas() == null || usuario.getDataNas().length() != 10) {
            throw new IllegalArgumentException("A data precisa estar no formato dd/mm/aaaa.");
        }
        int resultado = usuarioDao.salvar(usuario);

        if (resultado == 0) {
            throw new RuntimeException("Erro interno ao tentar cadastrar o usuário.");
        }
    }

    public Usuario autenticarUsuario(String login, String senha) throws IllegalArgumentException {
        if (login == null || login.trim().isEmpty() || senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("Login e senha devem ser preenchidos.");
        }

        Usuario usuario = usuarioDao.validarLogin(login, senha);

        if (usuario == null) {
            throw new IllegalArgumentException("Login ou Senha incorretos!");
        }

        return usuario;
    }

}
