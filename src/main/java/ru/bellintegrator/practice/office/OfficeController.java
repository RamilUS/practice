package ru.bellintegrator.practice.office;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OfficeController", description = "Управление информацией о офисах")
@RestController
@RequestMapping(value = "/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {
    private final OfficeService officeService;

    @Autowired
    public OfficeController (OfficeService officeService) {
        this.officeService = officeService;
    }

    @ApiOperation(value = "Получить офис по заданному фильтру", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public void save(@RequestBody OfficeView officeView) {
        officeService.saveOffice(officeView);
    }

    @ApiOperation(value = "Получить список всех офисов", httpMethod = "GET")
    @GetMapping("/list")
    public List<OfficeView> offices() { return officeService.offices();
    }

    @ApiOperation(value = "Получить список офисов по org_id", httpMethod = "GET")
    @GetMapping("/list/{org_id}")
    public List<OfficeView> loadByOrgId(@PathVariable Integer org_id ) { return officeService.loadByOrgId(org_id);
    }


    @ApiOperation(value = "Выбрать организацию по ID",httpMethod = "GET")
    @GetMapping("/{id}")
    public String loadById(@PathVariable Integer id ){
        //return officeService.loadById(id);
        return "{data:" +"\n"+ officeService.loadById(id).toString() + "}";}
}
