package ru.bellintegrator.practice.Organization;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

@ApiModel(description = "Организация")
public class OrganizationView {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Integer id;

    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "название организации", example = "Рога и копыта")
    public String name;

    @Size(max = 50)
    @NotEmpty(message = "full name cannot be null")
    @ApiModelProperty(value = "Полное название организации", example = "OOO Рога и копыта")
    public String fullName;

    @NotNull(message = "address cannot be null")
    @Min(18)
    @Max(200)
    @ApiModelProperty(value = "Адрес", example = "Сосновая 27")
    public String address;

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String inn;

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String kpp;

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String phone;

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Boolean isActive;

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name+ ";fullName:" + fullName + ";address:" + address + ";phone:" + phone +  "}";
    }
}
