package com.ceiba.servicio;

import com.ceiba.modelo.Alquiler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServicioCalcularTiempoDevolucionTest {
    @Test
    void ValidaCalculoTiempoDevolucion()
    {
        int tiempoAlquilado = 5;
        String fechaAlquiler= "07/06/2022";
        String  fechaDevolucion= "12/06/2022";
        Alquiler alquiler = Alquiler.of(tiempoAlquilado,fechaAlquiler,fechaDevolucion);

        ServicioCalcularTimpoDevolucionAlquiler servicio= new ServicioCalcularTimpoDevolucionAlquiler();

        String fecha = servicio.CalcularFechaDevolucon(alquiler);

        Assertions.assertEquals("12/06/2022",fecha);

    }
}