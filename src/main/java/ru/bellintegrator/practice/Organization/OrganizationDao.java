package ru.bellintegrator.practice.Organization;

import java.sql.SQLException;
import java.util.List;

public interface OrganizationDao {
    List<Organization> all() throws SQLException;

    Organization loadById(int id) throws SQLException;

    void save(Organization organization) throws SQLException;

    void update(Organization organization) throws SQLException;
}
