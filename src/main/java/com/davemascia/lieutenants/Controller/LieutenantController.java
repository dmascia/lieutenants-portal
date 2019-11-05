package com.davemascia.lieutenants.Controller;

import com.davemascia.lieutenants.Model.Lieutenant;
import com.davemascia.lieutenants.Repository.LieutenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LieutenantController {
    @Autowired
    private LieutenantRepository lieutenantRepository;

    @GetMapping(path = "/lieutenants/all")
    public @ResponseBody Iterable<Lieutenant> getAllLieutenants() {
        return lieutenantRepository.findAll();
    }
}
