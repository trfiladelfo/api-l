package com.fiap.lejour.controller

import com.fiap.lejour.dto.DashDTO
import com.fiap.lejour.dto.MesEnum
import com.fiap.lejour.service.DashService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.websocket.server.PathParam

@RestController
class DashController(
        @Autowired val dashService: DashService
) {

    @GetMapping(("/dash"))
    @CrossOrigin(origins = arrayOf("http://localhost:3000", "https://dashlejour.herokuapp.com"))
    private fun getFaixa(@PathParam("mes") mes: MesEnum?): DashDTO {

        return DashDTO(
                conversaoVenda = dashService.getConversaoVenda(),
                faixaInvestimento = dashService.getFaixaInvestimento(mes ?: MesEnum.NOVEMBRO),
                tagsPesquisadas = dashService.getTagsPesquisadas(),
                fornecedores = dashService.getFornecedores(),
                entradaCaixa = dashService.getEntradaCaixa(),
                servicosMaisContratados = dashService.getServicosMaisContratados(),
                casamento = dashService.getCasamento()
        )
    }
}