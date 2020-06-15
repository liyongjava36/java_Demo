package cn.itcast.json;

import cn.itcast.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonTest {
    public static void main(String[] args) throws IOException {
        Person person = new Person();
        person.setAge(10);
        person.setGender("男");
        person.setName("张三");
        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(person);
        System.out.println(string);
        objectMapper.writeValue(new File("D://a.txt"),person);
    }
}
