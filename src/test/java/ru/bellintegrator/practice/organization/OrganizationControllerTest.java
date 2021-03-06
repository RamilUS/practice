package ru.bellintegrator.practice.organization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockMvcClientHttpRequestFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import ru.bellintegrator.practice.Application;
import ru.bellintegrator.practice.Organization.OrganizationView;
import ru.bellintegrator.practice.Organization.Wrapper;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void findAll() throws Exception{
        String organizationAll = "{data:\n" +
                "[{\n" +
                "id:1;\n" +
                "name:Biline;\n" +
                "full_name:BEELINE LTD;\n" +
                "address:ул.Цюрупы, 16;\n" +
                "phone:8(499)123-45-67;\n" +
                "is_actiive:true" +
                "}, {\n" +
                "id:2;\n" +
                "name:Megafon;\n" +
                "full_name:MEGAFON LTD;\n" +
                "address:ул.Холмогоры, 16;\n" +
                "phone:8(499)123-99-99;\n" +
                "is_actiive:true" +
                "}]}";
        mockMvc.perform(get("/organization/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(organizationAll));
    }
    @Test
       public void findById() throws Exception{
        String organizationID = "{\"id\":1,\"name\":\"Biline\",\"full_name\":\"BEELINE LTD\",\"address\":\"ул.Цюрупы, 16\",\"inn\":\"beeline-inn\",\"kpp\":\"beeline-kpp\",\"phone\":\"8(499)123-45-67\",\"is_active\":true}";
        mockMvc.perform(get("/organization/{id}", 1L))
                .andExpect(status().isOk()).andExpect(content().string(organizationID));
    }
    @Test
    public void testPostNewOrganizationAndGet() {
        restTemplate = new RestTemplate(new MockMvcClientHttpRequestFactory(mockMvc));
        OrganizationView organizationView = new OrganizationView(3, "название", "полн.название", "1111111111", "000000000",
                "8 800 000 00 00", "Москва", true);
        HttpEntity<OrganizationView> entity = new HttpEntity<>(organizationView);
        ResponseEntity<Wrapper<OrganizationView>> responseEntity = restTemplate.exchange("/organization/save", HttpMethod.POST,
                entity, new ParameterizedTypeReference<Wrapper<OrganizationView>>() {});
        Assert.assertEquals(200, responseEntity.getStatusCodeValue());

        ResponseEntity<OrganizationView> responseEntityId3 = restTemplate.exchange("/organization/3", HttpMethod.GET,
                entity, new ParameterizedTypeReference<OrganizationView>() {});
        //organizationView.setId(3);
        Assert.assertEquals(organizationView,responseEntityId3.getBody());
    }
    @Test
    public void organizationUpdateTest() throws Exception {
        OrganizationView updt = new OrganizationView();
        updt .id = 2;
        updt .name = "Spring";
        updt .full_name = "Spring Boot";
        updt .address = "SinCity";
        updt .is_active = true;
        updt .phone = "9189788877";
        updt .inn = "233777777";
        updt .kpp = "555454555";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/organization/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(updt )))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
