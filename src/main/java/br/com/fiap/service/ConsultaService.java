package br.com.fiap.service;

import br.com.fiap.model.Consulta;
import br.com.fiap.repository.ConsultaDAO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ConsultaService {

    @Inject
    ConsultaDAO consultaDAO;   // ✅ injetado, Singleton

    private int faltas = 0;

    // ✅ Cadastrar consulta
    public void cadastrarConsulta(Consulta consulta) {
        consultaDAO.cadastrar(consulta);
    }

    // ✅ Listar consultas
    public List<Consulta> listarConsultas() {
        return consultaDAO.listarTodos();
    }

    // ✅ Registrar falta (agora retorna boolean)
    public boolean registrarFalta(int consultaId) {
        boolean registrada = consultaDAO.registrarFalta(consultaId);
        if (registrada) {
            faltas++;
            return true;
        }
        return false;
    }

    // ✅ Calcular taxa
    public double calcularTaxaAbsenteismoPercentual() {
        List<Consulta> consultas = consultaDAO.listarTodos();

        if (consultas.isEmpty())
            return 0.0;

        return ((double) faltas / consultas.size()) * 100.0;
    }
}
