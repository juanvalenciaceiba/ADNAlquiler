package com.ceiba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DtoAlquiler {
    private  int tiempoAlquilado;
    private  String fechaAlquiler;
    private  String  fechaDevolucion;

}
