package ru.bellintegrator.practice.organization;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.Application;
import ru.bellintegrator.practice.Organization.Organization;
import ru.bellintegrator.practice.Organization.OrganizationDao;
import ru.bellintegrator.practice.Organization.OrganizationService;
import ru.bellintegrator.practice.Organization.OrganizationView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OrganizationDaoTest {
    @Autowired
    private OrganizationDao organizationDao;

    @Test
        public void save() {
            Organization organization1 = new Organization("name","full_name","12345678","123456","Ufa Repablic Bashkortostan","+7927123456",true);
            organizationDao.save(organization1);
            List<Organization> organizationList = organizationDao.all();
            Assert.assertNotNull(organizationList);
        Assert.assertEquals(3, organizationList.size());
    }
    public void update(){

    }

}
