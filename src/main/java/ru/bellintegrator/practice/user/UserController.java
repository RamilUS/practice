package ru.bellintegrator.practice.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "UserController", description = "Управление информацией о работниках")
@RestController
@RequestMapping(value = "/user", produces = APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Получить работника по заданному фильтру", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public void save(@RequestBody UserView userView) {
        userService.saveUser(userView);
    }

    @ApiOperation(value = "Получить список всех работников", httpMethod = "GET")
    @GetMapping("/list")
    public String users() { return "{data:" +"\n"+userService.users().toString() + "}";
    }
    @ApiOperation(value = "Выбрать работника по ID",httpMethod = "GET")
    @GetMapping("/{id}")
    public String loadById(@PathVariable Integer id ){
        // Integer idI=new Integer(id);
        return "{data:" +"\n"+userService.loadById(id).toString() + "}";
    }

    @ApiOperation(value = "Обновить информацию об работнике", httpMethod = "POST")
    @PostMapping("/update")
    public void updateOrganization(@RequestBody UserView view) throws Exception {
        userService.updateUser(view);
    }
}
