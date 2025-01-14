package com.desafiovotacao.entrypoint;

import com.desafiovotacao.dto.ApiResponse;
import com.desafiovotacao.dto.AssociadoDTO;
import com.desafiovotacao.dto.VotoAssociadoDTO;
import com.desafiovotacao.service.interfaces.ICriarVotoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/voto")
public class VotoController {

    private final ICriarVotoService criarVotoService;

    public VotoController(
            ICriarVotoService criarVotoService
    ) {
        this.criarVotoService = criarVotoService;
    }

    @ApiOperation(value = "Endpoint utilizado para realizar o voto")
    @PostMapping(produces="application/json")
    public ResponseEntity<ApiResponse<VotoAssociadoDTO>> votar(@Validated @RequestBody VotoAssociadoDTO votoAssociadoDTO) {
        ApiResponse<VotoAssociadoDTO> response = new ApiResponse<>();
        try{
            response.setData(this.criarVotoService.criar(votoAssociadoDTO));
        } catch (Exception e) {
            response.setError(e.getMessage() != null  ? e.getMessage() : "Ocorreu um erro. Tente novamente mais tarde.");
        }
        return ResponseEntity.ok(response);
    }
}
