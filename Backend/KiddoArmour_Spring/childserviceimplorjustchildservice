package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Child;
import com.app.repository.ChildRepository;

@Service
public class ChildServices {

    @Autowired
    private ChildRepository childRepository;

    public Child saveChild(Child child) {
        return childRepository.save(child);
    }

    public List<Child> getAllChildren() {
        return childRepository.findAll();
    }

    public Optional<Child> getChildById(Long id) {
        return childRepository.findById(id);
    }

    public void deleteChild(Child child) {
        childRepository.delete(child);
    }

    public Child getChildrenByName(String fname, String lname) {
        return childRepository.findByFirstNameAndLastName(fname,lname);
    }
    
    public Child getChildrenByFirstName(String fname) {
        return childRepository.findByFirstName(fname);
    }
    
    public Child getChildrenByLastName(String lname) {
        return childRepository.findByLastName(lname);
    }
}

