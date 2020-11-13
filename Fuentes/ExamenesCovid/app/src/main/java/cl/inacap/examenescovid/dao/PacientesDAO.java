package cl.inacap.examenescovid.dao;

import java.util.List;

import cl.inacap.examenescovid.dto.Paciente;

public interface PacientesDAO {

    List<Paciente> getAll();
    Paciente save(Paciente p);
}
