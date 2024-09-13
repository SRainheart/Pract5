package com.example.pract5;
import com.example.pract5.controller.StudentApiController;
import com.example.pract5.model.Student;
import com.example.pract5.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentApiControllerTestJUnit {
    @Autowired
    private StudentApiController studentApiController;
    @MockBean
    private StudentRepository repository;
    @Test
    public void getStudentsTest(){
        when(repository.findAll()).thenReturn(Stream
                .of(new Student(376L, "Рома", "Частин", "Нет", 12, null)).collect(Collectors.toList()));
        assertEquals(1, studentApiController.getAllStudents().size());
    }
    @Test
    public void saveStudentsTest(){
        Student student = new Student(999L, "Рома", "Частин", "Нет", 12, null);
        when(repository.save(student)).thenReturn(student);
        assertEquals(student, studentApiController.createStudent(student));
    }
    @Test
    public void deleteStudentTest(){
        Student student = new Student(999L, "Рома", "Частин", "Нет", 12, null);
        studentApiController.deleteStudent(student.getId());
        verify(repository, times(1)).deleteById(student.getId());
    }
}
