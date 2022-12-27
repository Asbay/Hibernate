package com.hb01.annototion;


import javax.persistence.*;

@Entity
//entity annotation i koydugumuz  Class i veritabani db de bir tabloya karsilik getirir
@Table(name="t_student01") // db deki tablo ismini vermek icin kullanilir. bu komutla tablo ismi "t_student01 oldu.
public class Student01 { //db ye gider ve student01 isminde bir tablo olusturur


    @Id //primary key olusmasini sagliyor
    //@Column(name="std_id")
    private int id;


    @Column(name="student_name", length = 100,nullable = false, unique = false) // sqlde ki ismi "student_name oldu . java da ulasicaksam Studemnt.name. Ama sql de student_name
    //ismini girdik,uzunlugunu yazdik kac karakter olabilir, nullable olamaz mutlaka isim girilcek null olamaz,
    private String name;

    // @Transient // DB deki tabloda "grade" adında bir kolon oluşmasını engeller
    private int grade;

//    @Lob // ---> large object ile büyük boyurlu datalar tutulabilir
//    private byte[] image ;

    //getter setter lari yaz

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    //toString methodunu ekle

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

}




