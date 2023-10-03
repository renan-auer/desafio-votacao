package com.desafiovotacao.dto;

import com.desafiovotacao.domain.Pauta;
import com.desafiovotacao.domain.SessaoPauta;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SessaoPautaDTO {

    private String id;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    private String pautaId;

    public SessaoPauta toEntity() {
        SessaoPauta sessaoPauta = new SessaoPauta();
        sessaoPauta.setId(this.id);
        sessaoPauta.setDataInicio(this.dataInicio);
        sessaoPauta.setDataFim(this.dataFim);
        return sessaoPauta;
    }

    public static SessaoPautaDTO fromEntity(SessaoPauta sessaoPauta) {
        SessaoPautaDTO sessaoPautaDTO = new SessaoPautaDTO();
        sessaoPautaDTO.setId(sessaoPauta.getId());
        sessaoPautaDTO.setDataInicio(sessaoPauta.getDataInicio());
        sessaoPautaDTO.setDataFim(sessaoPauta.getDataFim());
        sessaoPautaDTO.setPautaId(sessaoPauta.getPauta().getId());
        return sessaoPautaDTO;
    }
}
