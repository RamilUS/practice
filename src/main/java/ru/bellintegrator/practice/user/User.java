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
    private Long id;
    @Version
    private Integer Version;
    @Column(name = "office_id")
    private Long office_id;
    @Column (name = "first_name", length = 50,nullable = false)
    private String first_name;
    @Column (name = "second_name", length = 50,nullable = false)
    private String second_name;
    @Column (name = "middle_name", length = 50,nullable = false)
    private String middle_name;
    @Column (name = "position", length = 30,nullable = false)
    private String position;
    @Column (name = "phone", length = 15,nullable = false)
    private String phone;
    @Column(name = "doc_code" , nullable = false)
    private Integer doc_code;
    @Column (name = "doc_name", length = 50,nullable = false)
    private String doc_name;
    @Column (name = "doc_number", length = 15,nullable = false)
    private String doc_number;
    @Column(name = "doc_date" , nullable = false)
    @Temporal(TemporalType.DATE)
    private Date doc_date;
    @Column (name = "citizenship_code", length = 10,nullable = false)
    private String citizenship_code;
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

    public User(Long id , Long office_id, String first_name, String second_name, String middle_name, String position, String phone, Integer doc_code, String doc_name, String doc_number, Date doc_date, String citizenship_code, Boolean is_identified){
        this.id = id;
        this.office_id = office_id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.middle_name = middle_name;
        this.position = position;
        this.phone = phone;
        this.doc_code = doc_code;
        this.doc_name = doc_name;
        this.doc_number = doc_number;
        this.doc_date = doc_date;
        this.citizenship_code = citizenship_code;
        this.is_identified = is_identified;
    }

    public User(Long office_id, String first_name, String second_name, String middle_name, String position, String phone, Integer doc_code, String doc_name, String doc_number, Date doc_date, String citizenship_code, Boolean is_identified){
        this.office_id = office_id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.middle_name = middle_name;
        this.position = position;
        this.phone = phone;
        this.doc_code = doc_code;
        this.doc_name = doc_name;
        this.doc_number = doc_number;
        this.doc_date = doc_date;
        this.citizenship_code = citizenship_code;
        this.is_identified = is_identified;
    }

    public Long getId() {
        return id;
    }

    public Long getOffice_id(){
        return office_id;
    }

    public String getPhone() {
        return phone;
    }

    public Date getDoc_date() {
        return doc_date;
    }

    public Integer getDoc_Code() {
        return doc_code;
    }

    public Boolean isIs_identified() {
        return is_identified;
    }

    public String getCitizenship_code() {
        return citizenship_code;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public String getDoc_number() {
        return doc_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getPosition() {
        return position;
    }

    public String getSecond_name() {
        return second_name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}