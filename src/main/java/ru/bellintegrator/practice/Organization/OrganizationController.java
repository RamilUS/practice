package ru.bellintegrator.practice.Organization;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OrganizationController", description = "Управление информацией о организациях")
@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class OrganizationConrtoller {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;

    }

    /**
     * Блок для /list, возвращает список организаций List<Organization>
     */
    @ApiOperation(value = "getOrganizations", httpMethod = "GET")

    @GetMapping(value = "/list", consumes = APPLICATION_JSON_VALUE)
    public List<OrganizationView> organizations()throws Exception{
        return organizationService.organizations();
    }
}



