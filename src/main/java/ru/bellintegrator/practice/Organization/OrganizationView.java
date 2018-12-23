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
    public String full_name;

    @NotNull(message = "address cannot be null")
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


    @ApiModelProperty
    public Boolean is_active;

    public OrganizationView() {
    }

    public OrganizationView(Integer id, @NotEmpty @Size(max = 45) String name, @NotEmpty @Size(max = 12) String inn, @NotEmpty Boolean is_active) {
        this.id = id;
        this.name = name;
        this.inn = inn;
        this.is_active = is_active;
    }

    public OrganizationView(@NotEmpty Integer id, @NotEmpty @Size(max = 45) String name, @NotEmpty @Size(max = 100) String full_name, @NotEmpty @Size(max = 12) String inn, @NotEmpty @Size(max = 9) String kpp, @NotEmpty @Size(max = 100) String address, @Size(max = 11) String phone, @NotEmpty Boolean is_active) {
        this.id = id;
        this.name = name;
        this.full_name = full_name;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.is_active = is_active;
    }


    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name+ ";full_name:" + full_name + ";address:" + address + ";phone:" + phone + ";is_actiive:" + is_active + "}";
    }
}
