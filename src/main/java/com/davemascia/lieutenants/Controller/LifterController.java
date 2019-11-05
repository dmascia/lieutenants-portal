package com.davemascia.lieutenants.Controller;

import com.davemascia.lieutenants.Model.Lifter;
import com.davemascia.lieutenants.Repository.LifterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LifterController {
    @Autowired
    private LifterRepository lifterRepository;

    @GetMapping(path = "/lifters/all")
    public @ResponseBody
    Iterable<Lifter> getAllLifters() {
        return lifterRepository.findAll();
    }

}
