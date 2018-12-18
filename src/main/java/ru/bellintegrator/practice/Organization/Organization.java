package ru.bellintegrator.practice.Organization;



import ru.bellintegrator.practice.office.Office;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "organization")

public class
Organization {

    public Organization() {

    }

    public Organization(String Name, String full_name,  String address , String phone , String inn, String kpp, Boolean is_active) {
        this.name = Name;
        this.full_name = full_name;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.is_active = is_active;
    }
    public Organization(Integer id, String Name, String full_name ,  String address , String phone , String inn, String kpp, Boolean is_active) {
        this.id = id;
        this.name = Name;
        this.full_name = full_name;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.is_active = is_active;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id", nullable = false)
    private Integer id;

    @Version
    private Integer version;

    @Column (name = "name", nullable = false)
    private String name;

    @Column(name = "full_name", length = 50, nullable = false)
    private String full_name;

    @Column (name = "address", nullable = false)
    private String address;

    @Column (name = "phone", nullable = false)
    private String phone;

    @Column (name = "inn", nullable = false)
    private String inn;

    @Column (name = "kpp", nullable = false)
    private String kpp;

    @Column (name="is_active")
    private Boolean is_active;

    @OneToMany (mappedBy = "organization")
    public Set<Office> office;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getFullname() {
        return full_name;
    }

    public void setFullname(String fullName) {
        this.full_name = full_name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsactive() {
        return is_active;
    }

    public void setIsactive(Boolean is_active) {
        this.is_active = is_active;
    }

    public Set<Office> getOffices() {
        return office;
    }

    public void setOffices(Set<Office> office) {
        this.office = office;
    }

}
