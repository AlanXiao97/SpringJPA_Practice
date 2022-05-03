package com.example.MySQLProject;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import javax.naming.directory.InvalidAttributeValueException;
import javax.transaction.Transactional;
import java.util.List;


@org.springframework.stereotype.Service
public class Service {
    private final record_repository repository;

    @Autowired
    public Service(com.example.MySQLProject.record_repository repository) {
        this.repository = repository;
    }

    public List<Record> get_all_records(){
        return repository.findAll();
    }


    public List<Record> get_specific_record_id(Integer id){
        return repository.get_specific_record_id(id);
    }

    public List<Record> get_specific_record_name(String name){
        return repository.get_specific_record_name(name);
    }

    public List<Record> get_specific_record_user(String createuseid){
        return repository.get_specific_record_user(createuseid);
    }

    public List<Record> last100_record_sorted(){
        return repository.last_100_record_sorted();
    }

    public void post_new_record(Record record){
        repository.save(record);
    }

    public void delete_record(Integer id){
        boolean x= repository.existsById(id);
        if (!x){
            throw new IllegalStateException("Record cannot be found!");
        }
        repository.deleteById(id);
    }

    @Transactional
    public void update_record(Integer id, String name,String status,String createtime,String createuseid){
        Record record= repository.findById(id).orElseThrow(() ->new IllegalStateException("Record cannot be found!"));
        if (name != null){
            record.setName(name);
        }
        if(status != null){
            record.setStatus(status);
        }
        if(createtime !=null){
            record.setcreatetime(createtime);
        }
        if(createuseid !=null) {
            record.setcreateuseid(createuseid);
        }
    }
}
