package com.lilejun.nouseifelse.entity;

public class Student implements Comparable<Student> {

    private int id;

    private String name;

    //年级
    private String grade;

    //学分
    private double score;

    public Student() {
    }

    public Student(int id, String name, String grade, double score) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        if(o.score==score){
            //分数相同，则按照id排序：由大到小
            return o.id-id;
        }else{
            //按分数从高到低排序
            return (int) (o.score-score);
        }
    }
}
