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

    @Inject
    UsuarioDAO usuarioDAO;

    // Listar todos os usuários
    @GET
    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listarTodos();
    }

    // Cadastrar novo usuário
    @POST
    public Response cadastrarUsuario(Usuario usuario) {
        usuarioDAO.cadastrar(usuario);
        return Response.status(Response.Status.CREATED)
                .entity("Usuário cadastrado com sucesso!")
                .build();
    }

    // Buscar usuário por ID
    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") int id) {
        Usuario usuario = usuarioDAO.buscarPorId(id);

        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Usuário não encontrado")
                    .build();
        }

        return Response.ok(usuario).build();
    }

    // Atualizar usuário
    @PUT
    @Path("/{id}")
    public Response atualizarUsuario(@PathParam("id") int id, Usuario usuarioAtualizado) {

        boolean atualizado = usuarioDAO.atualizar(id, usuarioAtualizado);

        if (atualizado) {
            return Response.ok("Usuário atualizado com sucesso!").build();
        }

        return Response.status(Response.Status.NOT_FOUND)
                .entity("Usuário não encontrado")
                .build();
    }

    // Deletar usuário
    @DELETE
    @Path("/{id}")
    public Response deletarUsuario(@PathParam("id") int id) {

        boolean removido = usuarioDAO.remover(id);

        if (removido) {
            return Response.ok("Usuário removido com sucesso!").build();
        }

        return Response.status(Response.Status.NOT_FOUND)
                .entity("Usuário não encontrado")
                .build();
    }
}

