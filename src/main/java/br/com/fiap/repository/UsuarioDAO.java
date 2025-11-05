package br.com.fiap.repository;

import br.com.fiap.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private List<Usuario> usuarios = new ArrayList<>();

    // Cadastrar novo usuário
    public void cadastrar(Usuario u) {
        usuarios.add(u);
    }

    // Listar todos os usuários
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios); // retorna cópia para segurança
    }

    // Buscar usuário por ID
    public Usuario buscarPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    // Remover usuário por ID
    public boolean remover(int id) {
        Usuario usuario = buscarPorId(id);
        if (usuario != null) {
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }
}