package com.example.pract5;
import com.example.pract5.controller.DirectorApiController;
import com.example.pract5.model.Director;
import com.example.pract5.repository.DirectorRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@WebMvcTest(DirectorApiController.class)
public class DirectorApiControllerTestMockito {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DirectorRepository directorService;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test//Mockito
    public void getDirectorMockitoTest() throws Exception{
        when(directorService.findAll()).thenReturn(Stream
                .of(new Director(12L, "HI", "USA", "UK", 35, 958)).collect(Collectors.toList()));
        mockMvc.perform(get("/v1/api/Director/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":12, \"name\":\"HI\", \"lastname\": \"USA\", \"midelname\": \"UK\", \"age\": 35, \"salary\": 958}"))
                .andExpect(status().isOk());
    }
    @Test//Mockito
    public void postDirectorMockitoTest() throws Exception{
        Director director = new Director();
        director.setId(10L);
        director.setName("Иван");
        director.setLastname("Семенов");
        director.setMidelname("Валерьевич");
        director.setAge(33);
        director.setSalary(220000);
        when(directorService.save(any(Director.class))).thenReturn(director);
        mockMvc.perform(post("/v1/api/Director/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":10, \"name\":\"Иван\", \"lastname\": \"Семенов\", \"midelname\": \"Валерьевич\", \"age\": 33, \"salary\": 220000}"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value(10L))
                .andExpect(jsonPath("$.name").value("Иван"))
                .andExpect(jsonPath("$.lastname").value("Семенов"))
                .andExpect(jsonPath("$.midelname").value("Валерьевич"))
                .andExpect(jsonPath("$.age").value(33))
                .andExpect(jsonPath("$.salary").value(220000));
    }
}