package ru.bellintegrator.practice.Organization;


import java.util.List;

public interface OrganizationDao {
    List<Organization> all() ;

    Organization loadById(int id) ;

    void save(Organization organization) ;

    void update(Organization organization) ;
}
