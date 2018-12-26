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
import ru.bellintegrator.practice.Organization.Wrapper;
import ru.bellintegrator.practice.office.OfficeView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
public class OfficeControllerTest {
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
        String officeAll = "{data:\n" +
                "[{\n" +
                "id:1;\n" +
                "name:Билайн-отрадное;\n" +
                "address:ул.отрадная, 7;\n" +
                "phone:8(499)123-45-01;\n" +
                "active:true;\n" +
                "}, {\n" +
                "id:2;\n" +
                "name:Билайн-вднх;\n" +
                "address:ул.вднх, 7;\n" +
                "phone:8(499)123-45-02;\n" +
                "active:true;\n" +
                "}, {\n" +
                "id:3;\n" +
                "name:Мегафон-измайлово;\n" +
                "address:ул.измайлово, 7;\n" +
                "phone:8(499)123-99-01;\n" +
                "active:true;\n" +
                "}, {\n" +
                "id:4;\n" +
                "name:Мегафон-марьино;\n" +
                "address:ул.марьино, 7;\n" +
                "phone:8(499)123-99-02;\n" +
                "active:true;\n" +
                "}]}";
        mockMvc.perform(get("/office/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(officeAll));
    }
    @Test
    public void findById() throws Exception{
        String organizationID = "{\"id\":1,\"name\":\"Билайн-отрадное\",\"org_id\":1,\"address\":\"ул.отрадная, 7\",\"phone\":\"8(499)123-45-01\",\"active\":true}";
        mockMvc.perform(get("/office/{id}", 1L))
                .andExpect(status().isOk()).andExpect(content().string(organizationID));
    }
    @Test
    public void testPostNewOrganizationAndGet() {
        restTemplate = new RestTemplate(new MockMvcClientHttpRequestFactory(mockMvc));
        OfficeView officeView = new OfficeView(9, "название", 1, "адресс","569678568", true);
        HttpEntity<OfficeView> entity = new HttpEntity<>(officeView);
        ResponseEntity<Wrapper<OfficeView>> responseEntity = restTemplate.exchange("/office/save", HttpMethod.POST,
                entity, new ParameterizedTypeReference<Wrapper<OfficeView>>() {});
        Assert.assertEquals(200, responseEntity.getStatusCodeValue());

        ResponseEntity<OfficeView> responseEntityId3 = restTemplate.exchange("/office/9", HttpMethod.GET,
                entity, new ParameterizedTypeReference<OfficeView>() {});
        //organizationView.setId(3);
        Assert.assertEquals(officeView,responseEntityId3.getBody());
    }
    @Test
    public void organizationUpdateTest() throws Exception {
        OfficeView updt = new OfficeView();
        updt .id = 2;
        updt.name = "Spring";
        updt.org_id=1;
        updt .address = "updAddress";
        updt .phone = "782488877";
        updt .active = true;


        this.mockMvc.perform(MockMvcRequestBuilders.post("/office/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(updt )))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
