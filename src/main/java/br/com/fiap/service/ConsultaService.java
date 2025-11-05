package br.com.fiap.service;

import br.com.fiap.model.Consulta;
import br.com.fiap.repository.ConsultaDAO;
import br.com.fiap.repository.UsuarioDAO;

import java.util.ArrayList;
import java.util.List;

public class ConsultaService {
    private final ConsultaDAO consultaDAO;
    private final UsuarioDAO usuarioDAO;

    private final List<Consulta> consultas = new ArrayList<>();
    private int faltas = 0;

    public ConsultaService() {
        this.consultaDAO = new ConsultaDAO();
        this.usuarioDAO = new UsuarioDAO();
    }

    public void cadastrarConsulta(Consulta consulta) {
        consultas.add(consulta);
        consultaDAO.cadastrar(consulta);
    }

    public List<Consulta> listarConsultas() {
        return consultas;
    }

    public void registrarFalta(int consultaId) {
        for (Consulta c : consultas) {
            if (c.getConsultaId() == consultaId) {
                faltas++;
                System.out.println("Falta registrada para consulta ID: " + consultaId);
                return;
            }
        }
        System.out.println("Consulta não encontrada para ID: " + consultaId);
    }

    public double calcularTaxaAbsenteismoPercentual() {
        if (consultas.isEmpty()) return 0.0;
        return ((double) faltas / consultas.size()) * 100.0;
    }
}
