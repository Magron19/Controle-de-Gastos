public class Usuario {
    private String login;
    private String senha; // Criptografia simples por enquanto

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = criptografarSenha(senha);
    }

    private String criptografarSenha(String senha) {
        // Exemplo simples de "criptografia" - use uma biblioteca de hash em produção
        return new StringBuilder(senha).reverse().toString();
    }

    @Override
    public String toString() {
        return "Usuário: " + login + ", Senha Criptografada: " + senha;
    }
}