package ru.bellintegrator.practice.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Офис")
public class OfficeView {
    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Integer id;

    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "название офиса", example = "Рога и копыта")
    public String name;

    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "название офиса", example = "Рога и копыта")
    public Integer org_id;


    @NotNull(message = "address cannot be null")
    @ApiModelProperty(value = "Адрес", example = "Сосновая 27")
    public String address;


    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String phone;


    @ApiModelProperty
    public Boolean active;

    public OfficeView() {
    }

    public OfficeView(Integer org_id, @NotEmpty @Size(max = 45) String name, @NotEmpty @Size(max = 12) String phone, @NotEmpty Boolean active) {
        this.org_id = org_id;
        this.name = name;
        this.phone = phone;
        this.active = active;
    }

    public OfficeView(@NotEmpty Integer id, @NotEmpty @Size(max = 45) String name, @NotEmpty @Size(max = 100) String address, @Size(max = 11) String phone, @NotEmpty Boolean active) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.active = active;
    }


    @Override
    public String toString() {
        return "{" +"\n"+"id:" + id +";"+"\n"+ "name:" + name+";"+"\n"+  "address:" + address+";" +"\n"+ "phone:" + phone +";"+"\n"+ "active:" + active+";" +"\n"+ "}";
    }
}
