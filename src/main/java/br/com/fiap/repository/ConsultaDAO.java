package br.com.fiap.repository;

import br.com.fiap.model.Consulta;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton   // Garante 1 instância global no Quarkus
public class ConsultaDAO {

    // Lista compartilhada entre todos os endpoints
    private static final List<Consulta> consultas = new ArrayList<>();

    // Cadastrar nova consulta
    public void cadastrar(Consulta consulta) {
        consultas.add(consulta);
    }

    // Listar todas
    public List<Consulta> listarTodos() {
        return new ArrayList<>(consultas);
    }

    // Buscar por ID
    public Consulta buscarPorId(int id) {
        return consultas.stream()
                .filter(c -> c.getConsultaId() == id)
                .findFirst()
                .orElse(null);
    }

    // Atualizar consulta
    public boolean atualizarConsulta(Consulta nova) {
        Consulta atual = buscarPorId(nova.getConsultaId());
        if (atual == null) return false;

        atual.setTipo(nova.getTipo());
        atual.setEspecialidade(nova.getEspecialidade());
        atual.setConsultaData(nova.getConsultaData());
        atual.setConsultaHora(nova.getConsultaHora());
        atual.setUsuario(nova.getUsuario());
        atual.setFuncionario(nova.getFuncionario());

        return true;
    }

    // Registrar falta
    public boolean registrarFalta(int id) {
        Consulta consulta = buscarPorId(id);
        if (consulta != null) {
            consulta.setStatus("FALTA");
            return true;
        }
        return false;
    }

    // Remover consulta
    public boolean remover(int id) {
        return consultas.removeIf(c -> c.getConsultaId() == id);
    }
}
