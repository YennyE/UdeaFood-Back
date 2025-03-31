package com.UdeaFood_Back.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HorarioDTO {

    private Time horario1;
    private Time horario2;
    private Integer idTienda;
}
