package ru.bellintegrator.practice.Organization;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.Organization.OrganizationService;
import ru.bellintegrator.practice.housePerson.view.PersonView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OrganizationController", description = "Управление информацией о организациях")
@RestController
@RequestMapping(value = "/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {
    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController (OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @ApiOperation(value = "Получить организацию по заданному фильтру", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public void save(@RequestBody OrganizationView organizationView) {
        organizationService.saveOrganization(organizationView);
    }

    @ApiOperation(value = "Получить список всех орг", httpMethod = "GET")
    @GetMapping("/list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public String organizations() { return "{data:" +"\n"+organizationService.organizations().toString() + "}";
    }
    @ApiOperation(value = "Выбрать организацию по ID",httpMethod = "GET")
    @GetMapping("/{id}")
    public String loadById(@PathVariable Integer id ){
       // Integer idI=new Integer(id);
        return "{data:" +"\n"+organizationService.loadById(id).toString() + "}";
    }

    @ApiOperation(value = "Обновить информацию об организации", httpMethod = "POST")
    @PostMapping("/update")
    public void updateOrganization(@RequestBody OrganizationView view) throws Exception {
         organizationService.updateOrganization(view);
    }

}
