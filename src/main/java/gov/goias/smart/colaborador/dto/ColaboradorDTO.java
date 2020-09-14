package gov.goias.smart.colaborador.dto;

import gov.goias.smart.colaborador.entity.Sexo;
import gov.goias.smart.colaborador.entity.Situacao;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Schema(name = "Colaborador", description = "Colaborador da Subsecretaria de Tecnologia da Informacao.")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ColaboradorDTO implements Serializable {

    @Schema(description = "Identificador do colaborador")
    private Long id;

    @Schema(description = "Nome do colaborador")
    private String nome;

    @Schema(description = "Email do colaborador")
    private String email;

    @Schema(description = "Cpf do colaborador")
    private String cpf;

    @Schema(description = "Data de Nascimento do colaborador")
    private LocalDate dataNascimento;

    @Schema(description = "Sexo do colaborador")
    private Sexo sexo;

    @Schema(description = "Situacao do colaborador")
    private Situacao situacao;
}