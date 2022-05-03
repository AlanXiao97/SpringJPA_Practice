package com.example.MySQLProject;

import javax.persistence.*;


@javax.persistence.Entity
@Table
public class Record {
    @Id
    @SequenceGenerator(
            name = "Entity_Generator",
            sequenceName= "Entity_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Entity_Generator"
    )

    @Column(
            name = "id",
            updatable = false
    )
    private Integer id;
    @Column(
            name = "name",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String name;
    @Column(
            name = "status",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String status;
    @Column(
            name = "createtime",
            nullable = false
    )
    private String createtime;
    @Column(
            name = "createuseid",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String createuseid;

    public Record() {
    }

    public Record(String name,
                  String status,
                  String createtime,
                  String createuseid) {
        this.name = name;
        this.status = status;
        this.createtime = createtime;
        this.createuseid = createuseid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getcreatetime() {
        return createtime;
    }

    public void setcreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getcreateuseid() {
        return createuseid;
    }

    public void setcreateuseid(String createuseid) {
        this.createuseid = createuseid;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", createtime='" + createtime + '\'' +
                ", UseID=" + createuseid +
                '}';
    }
}
