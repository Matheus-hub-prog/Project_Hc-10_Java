package br.com.fiap.controll;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import br.com.fiap.model.Consulta;
import br.com.fiap.service.ConsultaService;
import java.util.List;

@Path("/consultas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConsultaController {


    // 1️⃣ Listar todas as consultas
    @GET
    public List<Consulta> listarConsultas() {
        ConsultaService consultaService = new ConsultaService();
        return consultaService.listarConsultas();
    }

    // 2️⃣ Cadastrar nova consulta
    @POST
    public Response cadastrarConsulta(Consulta consulta) {
        ConsultaService consultaService = new ConsultaService();

        consultaService.cadastrarConsulta(consulta);
        return Response.status(Response.Status.CREATED)
                .entity("Consulta cadastrada com sucesso!")
                .build();
    }

    // 3️⃣ Registrar falta em uma consulta
    @PUT
    @Path("/{id}/falta")
    public Response registrarFalta(@PathParam("id") int id) {
        ConsultaService consultaService = new ConsultaService();

        consultaService.registrarFalta(id);
        return Response.ok("Falta registrada para a consulta ID: " + id).build();
    }

    // 4️⃣ Calcular taxa de absenteísmo
    @GET
    @Path("/taxa")
    public Response calcularTaxaAbsenteismo() {
        ConsultaService consultaService = new ConsultaService();

        double taxa = consultaService.calcularTaxaAbsenteismoPercentual();
        return Response.ok(taxa).build();
    }
}