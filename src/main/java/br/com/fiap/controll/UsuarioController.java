package br.com.fiap.controll;

import br.com.fiap.model.Usuario;
import br.com.fiap.repository.UsuarioDAO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioController {


    // 1️⃣ Listar todos os usuários
    @GET
    public List<Usuario> listarUsuarios() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.listarTodos();
    }

    // 2️⃣ Cadastrar novo usuário
    @POST
    public Response cadastrarUsuario(Usuario usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        usuarioDAO.cadastrar(usuario);
        return Response.status(Response.Status.CREATED)
                .entity("Usuário cadastrado com sucesso!")
                .build();
    }

    // 3️⃣ Buscar usuário por ID
    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") int id) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscarPorId(id);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Usuário não encontrado")
                    .build();
        }
        return Response.ok(usuario).build();
    }

    // 4️⃣ Deletar usuário
    @DELETE
    @Path("/{id}")
    public Response deletarUsuario(@PathParam("id") int id) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        boolean removido = usuarioDAO.remover(id);
        if (removido) {
            return Response.ok("Usuário removido com sucesso!").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Usuário não encontrado")
                    .build();
        }
    }
}
