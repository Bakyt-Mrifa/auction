package kg.mrifa.auction.controllers;

import io.swagger.annotations.Api;
import kg.mrifa.auction.models.dto.StatusDto;
import kg.mrifa.auction.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/statuses")
@Api(value = "Управление статусами", description = "Методы для управленя статусами аукциона")
public class StatusController {
    @Autowired
    private StatusService statusService;
    @PostMapping(value="/save")
    public StatusDto saveStatus (StatusDto statusDto){
        return statusService.saveStatus(statusDto);
    }
    @GetMapping("/list")
    public List<StatusDto> getStatusList (
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "2", name ="size") Integer pageSize,
            @RequestParam(defaultValue = "name") String sortBy
    ){
        return statusService.findStatuses(pageNo,pageSize,sortBy);
    }
}
