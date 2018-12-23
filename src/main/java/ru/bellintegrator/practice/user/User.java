package ru.bellintegrator.practice.user;



import ru.bellintegrator.practice.country.Country;
import ru.bellintegrator.practice.docs.Docs;
import ru.bellintegrator.practice.office.Office;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false)
    private Integer id;
    @Version
    private Integer Version;
    @Column(name = "office_id")
    private Integer office_id;
    @Column (name = "first_name", length = 50,nullable = false)
    private String first_name;
    @Column (name = "second_name", length = 50,nullable = false)
    private String second_name;
    @Column (name = "last_name", length = 50,nullable = false)
    private String last_name;
    @Column (name = "middle_name", length = 50,nullable = false)
    private String middle_name;
    @Column (name = "position", length = 30,nullable = false)
    private String position;
    @Column (name = "phone", length = 15,nullable = false)
    private String phone;
    @Column(name = "doc_id" , nullable = false)
    private Integer doc_id;
    @Column (name = "citizenship_id", length = 10,nullable = false)
    private Integer citizenship_id;
    @Column(name = "is_identified" , nullable = false)
    private Boolean is_identified;

    @ManyToOne
    @JoinColumn(name = "office_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Office office;

    @ManyToOne
    @JoinColumn(name = "doc_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Docs docs;

    @ManyToOne
    @JoinColumn(name = "citizenship_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Country country;


    public User(){

    }

    public User(Integer id , Integer office_id, String first_name,String last_name, String second_name, String middle_name, String position, String phone, Integer doc_id, Integer citizenship_id, Boolean is_identified){
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOffice_id() {
        return office_id;
    }

    public void setOffice_id(Integer office_id) {
        this.office_id = office_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(Integer doc_id) {
        this.doc_id = doc_id;
    }

    public Integer getCitizenship_id() {
        return citizenship_id;
    }

    public void setCitizenship_id(Integer citizenship_id) {
        this.citizenship_id = citizenship_id;
    }

    public Boolean getIs_identified() {
        return is_identified;
    }

    public void setIs_identified(Boolean is_identified) {
        this.is_identified = is_identified;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}