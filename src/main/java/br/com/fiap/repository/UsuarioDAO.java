package br.com.fiap.repository;

import br.com.fiap.model.Usuario;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UsuarioDAO {

    private List<Usuario> usuarios = new ArrayList<>();

    // Cadastrar novo usuário
    public void cadastrar(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Listar todos os usuários
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios); // retorna cópia
    }

    // Buscar usuário por ID
    public Usuario buscarPorId(int id) {
        return usuarios.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Atualizar usuário
    public boolean atualizar(int id, Usuario usuarioAtualizado) {
        Usuario existente = buscarPorId(id);

        if (existente == null) return false;

        existente.setNome(usuarioAtualizado.getNome());
        existente.setLogin(usuarioAtualizado.getLogin());
        existente.setSenha(usuarioAtualizado.getSenha());

        return true;
    }

    // Remover usuário por ID
    public boolean remover(int id) {
        Usuario usuário = buscarPorId(id);
        if (usuário != null) {
            usuarios.remove(usuário);
            return true;
        }
        return false;
    }
}
