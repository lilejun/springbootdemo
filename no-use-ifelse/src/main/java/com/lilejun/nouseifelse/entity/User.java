package com.lilejun.nouseifelse.entity;

public class User {
    private String name;

    private String sex;

    private int age;

    private String school;

    private Double score;

    public User(){}

    public User(String name, String sex, int age, String school,double score) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.school = school;
        this.score=score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }


    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    //为了实现对象去重，重写hashcode和equels方法

    @Override
    public int hashCode() {
        int hashno = 7;
        int hashObject = (name+sex+age+school).hashCode();
        hashno = 13 * hashno + hashObject;
        return hashno;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        final User user = (User) obj;
        if (this == user) {
            return true;
        } else {
            return (this.name.equals(user.name) && this.sex.equals(user.sex)&&this.age==user.age&&this.school.equals(user.getSchool()));
        }
    }

}
