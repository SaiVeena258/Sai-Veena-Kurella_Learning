package com.mappings.one_one.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mappings.one_one.model.Idcard;
import com.mappings.one_one.model.Student;
import com.mappings.one_one.repository.IdcardRepository;
import com.mappings.one_one.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IdcardService {

    @Autowired
    private IdcardRepository idRepo;

    @Autowired
    private StudentRepository stuRepo;

    public Idcard createIdcard(Idcard idcard) {
        return idRepo.save(idcard);
    }

    public List<Idcard> getAllIdcards() {
        return idRepo.findAll();
    }

    public Idcard getIdcardById(Long id) {
        return idRepo.findById(id).orElse(null);
    }

    public Idcard updateIdcard(Long id, Idcard updatedIdcard) {
        Optional<Idcard> existingIdcardOpt = idRepo.findById(id);

        if (existingIdcardOpt.isPresent()) {
            Idcard existingIdcard = existingIdcardOpt.get();
            existingIdcard.setBranch(updatedIdcard.getBranch());
            existingIdcard.setSection(updatedIdcard.getSection());

            return idRepo.save(existingIdcard);
        } else {
            throw new RuntimeException("Idcard not found with ID: " + id);
        }
    }

    @Transactional
    public void deleteIdcard(Long id) {
        Optional<Idcard> idcarddetails = idRepo.findById(id);

        if (idcarddetails.isPresent()) {
            Idcard idcard = idcarddetails.get();

            Optional<Student> studetails = stuRepo.findByIdCard(idcard);
            if (studetails.isPresent()) {
                Student stu = studetails.get();
                stu.setIdCard(null);
                stuRepo.save(stu);
            }

            idRepo.deleteById(id);
        } else {
            throw new RuntimeException("Idcard not found with ID: " + id);
        }
    }
}
