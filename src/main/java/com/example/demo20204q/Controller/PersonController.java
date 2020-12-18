package com.example.demo20204q.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo20204q.Form.PersonForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("api/person")
@CrossOrigin(origins = {"http://localhost:8081"})
public class PersonController {

    @GetMapping
    public String getAll() throws JsonProcessingException {
        
        List<PersonForm> list = new ArrayList<PersonForm>();
        list.add(new PersonForm(1, "社員1"));
        list.add(new PersonForm(2, "社員2"));
        
       // return list;
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(list);

    }
}
