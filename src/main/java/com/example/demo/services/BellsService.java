package com.example.demo.services;

import com.example.demo.model.Bell;
import com.example.demo.repositories.BellRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BellsService {
    @Autowired
    private BellRepo bellRepo;

    public Bell addBell(Bell bell){
        bellRepo.saveAndFlush(bell);
        return bell;
    }

    public Bell getBell(int id){
        return bellRepo.findById(id).orElseThrow(()->null);
    }

    public Bell updateBell(int id , Bell bell){
        Bell bell1 = bellRepo.findById(id).orElseThrow(()->null);
        bell1=bell;
        bellRepo.save(bell1);
        return bell1;
    }
    public  Bell deleteBell(int id){
        bellRepo.deleteById(id);
        return bellRepo.findById(id).orElseThrow(()->null);
    }

}
