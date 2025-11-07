package br.com.fiap.model;

import java.time.LocalDate;

public class Consulta {
    private int consultaId;
    private String tipo;
    private String especialidade;
    private LocalDate consultaData;
    private String consultaHora;
    private Usuario usuario;
    private Funcionario funcionario;
    private String status;

    // Construtor
    public Consulta(int consultaId, String tipo, String especialidade,
                    LocalDate consultaData, String consultaHora,
                    Usuario usuario, Funcionario funcionario) {
        this.consultaId = consultaId;
        this.tipo = tipo;
        this.especialidade = especialidade;
        this.consultaData = consultaData;
        this.consultaHora = consultaHora;
        this.usuario = usuario;
        this.funcionario = funcionario;
        this.status = "AGENDADA"; // status padrão
    }

    // Getters e Setters
    public int getConsultaId() { return consultaId; }
    public void setConsultaId(int consultaId) { this.consultaId = consultaId; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public LocalDate getConsultaData() { return consultaData; }
    public void setConsultaData(LocalDate consultaData) { this.consultaData = consultaData; }

    public String getConsultaHora() { return consultaHora; }
    public void setConsultaHora(String consultaHora) { this.consultaHora = consultaHora; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Funcionario getFuncionario() { return funcionario; }
    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Consulta{" +
                "consultaId=" + consultaId +
                ", tipo='" + tipo + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", consultaData=" + consultaData +
                ", consultaHora='" + consultaHora + '\'' +
                ", usuario=" + (usuario != null ? usuario.getNome() : "null") +
                ", funcionario=" + (funcionario != null ? funcionario.getNome() : "null") +
                ", status='" + status + '\'' +
                '}';
    }
}