package ru.bellintegrator.practice.user;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

public class UserView {@NotEmpty
public Integer id;

    @NotEmpty
    @Size(max = 45)
    public Integer office_id;

    @NotEmpty
    @Size(max = 45)
    public String first_name;

    @NotEmpty
    @Size(max = 45)
    public String last_name;

    @NotEmpty
    @Size(max = 45)
    public String second_name;

    @NotEmpty
    @Size(max = 45)
    public String middle_name;

    @NotEmpty
    @Size(max = 45)
    public String position;

    @NotEmpty
    @Size(max = 11)
    public String phone;

    @NotEmpty
    @Size(max = 45)
    public Integer doc_id;


    @NotEmpty
    @Size(max = 3)
    public Integer citizenship_id;
    @NotEmpty
    @Size(max = 3)
    public Boolean is_identified;



    public UserView() {
    }

    public UserView(@NotEmpty Integer id,@NotEmpty Integer office_id, @NotEmpty @Size(max = 45) String first_name,@NotEmpty @Size(max = 45) String last_name, @NotEmpty @Size(max = 45) String second_name, @NotEmpty @Size(max = 45) String middle_name, @NotEmpty @Size(max = 45) String position, @NotEmpty @Size(max = 11) String phone, @NotEmpty @Size(max = 45) Integer doc_id,  @NotEmpty @Size(max = 3) Integer citizenship_id, @NotEmpty Boolean is_identified) {
        this.id = id;
        this.office_id = office_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.second_name = second_name;
        this.middle_name = middle_name;
        this.position = position;
        this.phone = phone;
        this.doc_id = doc_id;
        this.citizenship_id = citizenship_id;
        this.is_identified = is_identified;
    }

    @Override
    public String toString(){
        return "{id: " + id + "; office_id: " + office_id + "; firstName: " + first_name +"; lastName: " + last_name + "; secondName: " + second_name + "; middleName: " + middle_name +
                "; position: " + position + "; doc_id: " + doc_id +
                "; citizenship_id: " + citizenship_id + "; is_identified: " + is_identified + "}";
    }
}
