package com.example.MySQLProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "MySQLProject")

public class Controller {
    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping
    public List<Record> get_all_records(){
        return service.get_all_records();
    }

    @GetMapping(path="/id")
    public List<Record> get_specific_record_id(@RequestParam Integer id){
        return service.get_specific_record_id(id);
    }

    @GetMapping(path="/name")
    public List<Record> get_specific_record_name(@RequestParam String name){
        return service.get_specific_record_name(name);
    }

    @GetMapping(path="/user")
    public List<Record> get_specific_record_user(@RequestParam String createuseid){
        return service.get_specific_record_user(createuseid);
    }

    @GetMapping(path="/sorted")
    public List<Record> last100_record_sorted(){
        return service.last100_record_sorted();
    }

    @PostMapping
    public void post_new_record(@RequestBody Record record){ //take request body, mapping into record
        service.post_new_record(record);
    }

    @DeleteMapping //to delete the record by sending the id of the record
    public void delete_record(@RequestBody Integer id){
        service.delete_record(id);
    }

    @PutMapping
    public void update_record(@RequestParam Integer id,
                         @RequestParam(required = false) String name,
                         @RequestParam(required = false) String status,
                         @RequestParam(required = false) String createtime,
                         @RequestParam(required = false) String createuseid){
        service.update_record(id,name,status,createtime,createuseid);
    }
}
