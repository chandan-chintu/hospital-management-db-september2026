package com.jpaandhibernate.example.hospital_management_db.controller;

import com.jpaandhibernate.example.hospital_management_db.model.Doctor;
import com.jpaandhibernate.example.hospital_management_db.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
//@ResponseBody
@RequestMapping("/doctor/apis")
public class DoctorController {

    // request -> API(Controller) -> service -> repository -> service(response) -> API(response) -> user/frontend/postman(response)

    //spring boot application - takes input in the form of JSON(javascript object notation)

    // debugging - tracing the flow of the application(understanding line by line what is happening and all)

    // @RequestBody - it is used to take input request from UI or postman and it is used for only complete class inputs

    @Autowired
    DoctorService doctorService;

    @PostMapping("/save")
    public String addDoctor(@RequestBody Doctor doctor){
        String response = doctorService.saveDoctor(doctor);
        return response;
    }

    @GetMapping("/findAll")
    public List<Doctor> findAllDoctors(){
        List<Doctor> doctorList = doctorService.findAllDoctors();
        return doctorList;
    }

    //@PathVariable - it is used to take the inputs in input request url path
    @GetMapping("/findById/{id}")
    public Doctor findDoctorById(@PathVariable int id){
        Doctor doctor = doctorService.findDoctorById(id);
        return doctor;
    }

    @GetMapping("/count")
    public String countDoctors(){
        String response  = doctorService.countDoctors();
        return response;
    }

    @DeleteMapping("/deleteById/{id}/{name}")
    public String deleteDoctorById(@PathVariable int id,@PathVariable int name){
        String response  = doctorService.deleteDoctorById(id);
        return response;
    }

    @PutMapping("/updatePut/{doctorId}")
    public String updateDoctorUsingPut(@PathVariable int doctorId,@RequestBody Doctor newDoctorRequest){
        String response = doctorService.updateDoctorUsingPut(doctorId,newDoctorRequest);
        return response;
    }

    // @RequestParam - it takes the input in the form of parameter query
    @PatchMapping("/updatePatch/{doctorId}")
    public String updateDoctorUsingPatch(@PathVariable int doctorId,@RequestParam String newEmail,@RequestParam String newMobile){
        String response = doctorService.updateDoctorUsingPatch(doctorId,newEmail,newMobile);
        return response;
    }
}
