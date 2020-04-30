package kg.mrifa.auction.controllers;

import io.swagger.annotations.Api;
import kg.mrifa.auction.models.dto.LotDto;
import kg.mrifa.auction.services.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/lots")
@Api(value = "Управление лотом", description = "Методы для управления лотами")
public class LotController {
    @Autowired
    private LotService lotService;
    @PostMapping(value = "/save")
    public LotDto saveLot(@RequestBody LotDto lotDto){
        System.out.println("Controller - lotDto: "+lotDto);
        return lotService.saveLot(lotDto);
    }
    @GetMapping("/get")
    public LotDto getLot(
           @RequestParam(defaultValue = "1") Long id)
    {
        return lotService.findById(id);
    }

}
