package com.ceiba.alquiler.adaptador.repositorio;

import com.ceiba.alquiler.adaptador.dao.MapeoAlquiler;
import com.ceiba.dto.AlquilerResumenDto;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.puerto.RepositorioAlquiler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioAlquilerPostgre implements RepositorioAlquiler {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoAlquiler mapeoAlquiler;

    public RepositorioAlquilerPostgre(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoAlquiler mapeoAlquiler) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoAlquiler = mapeoAlquiler;
    }

    @SqlStatement(namespace = "alquiler", value = "obteneralquilerporid")
    private static String sqlObtenerAlquilePorId;

    @SqlStatement(namespace = "alquiler", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "alquiler", value = "eliminar")
    private static String sqlEliminar;


    @Override
    public int crear(AlquilerResumenDto alquilerResumenDto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();

        paramSource.addValue("tiempo_alquiler", alquilerResumenDto.getTiempoAlquilado());
        paramSource.addValue("fecha_alquiler", alquilerResumenDto.getFechaAlquiler());
        paramSource.addValue("fecha_devolucion", alquilerResumenDto.getFechaDevolucion());
        paramSource.addValue("fecha_devolucion_real", alquilerResumenDto.getFechaDevolucionReal());
        paramSource.addValue("pago", alquilerResumenDto.getTotalAPagar());
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear).intValue();
    }

    @Override
    public AlquilerResumenDto consultarPorId(int id) {
        return null;
    }

    @Override
    public boolean existe(AlquilerResumenDto alquilerResumenDto) {
        return false;
    }

    @Override
    public int eliminar(int id) {
        return 0;
    }
}
