package br.com.fiap.repository;

import br.com.fiap.model.Consulta;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {

    private final List<Consulta> consultas = new ArrayList<>();

    // cadastra nova consulta
    public void cadastrar(Consulta consulta) {
        consultas.add(consulta);
    }

    // retorna cópia da lista
    public List<Consulta> listarTodos() {
        return new ArrayList<>(consultas);
    }

    // busca por id
    public Consulta buscarPorId(int id) {
        return consultas.stream()
                .filter(c -> c.getConsultaId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Atualiza os campos editáveis da consulta já existente.
     * Retorna true se encontrou e atualizou, false caso contrário.
     */
    public boolean atualizarConsulta(Consulta nova) {
        Consulta atual = buscarPorId(nova.getConsultaId());
        if (atual == null) return false;

        // atualiza somente os campos que existem no modelo/banco
        atual.setTipo(nova.getTipo());
        atual.setEspecialidade(nova.getEspecialidade());
        atual.setConsultaData(nova.getConsultaData());
        atual.setConsultaHora(nova.getConsultaHora());
        atual.setUsuario(nova.getUsuario());
        atual.setFuncionario(nova.getFuncionario());
        return true;
    }

    // remove por id
    public boolean remover(int id) {
        return consultas.removeIf(c -> c.getConsultaId() == id);
    }
}