package com.example.MySQLProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;


@Repository
public interface record_repository extends JpaRepository<Record, Integer> {
    @Query("SELECT x FROM Record x WHERE x.id = :id")
    List<Record> get_specific_record_id(@Param("id") Integer id);

    @Query("SELECT x FROM Record x WHERE x.name = :name")
    List<Record> get_specific_record_name(@Param("name") String name);

    @Query("SELECT x FROM Record x WHERE x.createuseid = :createuseid")
    List<Record> get_specific_record_user(@Param("createuseid") String createuseid);

    //Select the last 100 records and sort them by createtime
    @Query(value="SELECT * FROM (SELECT * FROM Record ORDER BY id DESC LIMIT 100) sub ORDER BY createtime DESC",nativeQuery = true)
    List<Record> last_100_record_sorted();

}
