package ru.bellintegrator.practice.organization;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockMvcClientHttpRequestFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import ru.bellintegrator.practice.Application;
import ru.bellintegrator.practice.Organization.OrganizationView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
public class OrganizationControllerTest {//Add web application context here
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private RestTemplate restTemplate;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void findAll() throws Exception{
        String organizationAll = "[{\"id\":1,\"name\":\"Biline\",\"full_name\":\"BEELINE LTD\",\"address\":\"ул.Цюрупы, 16\",\"inn\":\"beeline-inn\",\"kpp\":\"beeline-kpp\",\"phone\":\"8(499)123-45-67\",\"is_active\":true},{\"id\":2,\"name\":\"Megafon\",\"full_name\":\"MEGAFON LTD\",\"address\":\"ул.Холмогоры, 16\",\"inn\":\"megafon-inn\",\"kpp\":\"megafon-kpp\",\"phone\":\"8(499)123-99-99\",\"is_active\":true}]";
        mockMvc.perform(get("/organization/list")).andExpect(status().isOk()).andExpect(content().json(organizationAll));
    }
    @Test
       public void findById() throws Exception{
        String organizationID = "{\"id\":1,\"name\":\"Biline\",\"full_name\":\"BEELINE LTD\",\"address\":\"ул.Цюрупы, 16\",\"inn\":\"beeline-inn\",\"kpp\":\"beeline-kpp\",\"phone\":\"8(499)123-45-67\",\"is_active\":true}";
        mockMvc.perform(get("/organization/{id}", 1L))
                .andExpect(status().isOk()).andExpect(content().json(organizationID));
    }
   /* @Test
    public void testPostNewOrganizationAndGet() {
        restTemplate = new RestTemplate(new MockMvcClientHttpRequestFactory(mockMvc));
        OrganizationView organizationView = new OrganizationView(null, "название", "полн.название", "1111111111", "000000000",
                "8 800 000 00 00", "Москва", true);
        HttpEntity<OrganizationView> entity = new HttpEntity<>(organizationView);
        ResponseEntity<Wrapper<ResponseView>> responseEntity = restTemplate.exchange("/api/organization/save", HttpMethod.POST,
                entity, new ParameterizedTypeReference<Wrapper<ResponseView>>() {});
        Wrapper<ResponseView> wrapper = responseEntity.getBody();
        Assert.assertEquals(new ResponseView("success"), wrapper.getData());
        Assert.assertEquals(200, responseEntity.getStatusCodeValue());

        ResponseEntity<Wrapper<OrganizationView>> responseEntityId3 = restTemplate.exchange("/api/organization/3", HttpMethod.GET,
                entity, new ParameterizedTypeReference<Wrapper<OrganizationView>>() {});
        organizationView.setId("3");
        Assert.assertEquals(organizationView, responseEntityId3.getBody().getData());
    }*/

}
