package com.example.demo.Model;

/**
 * 有个Person类，包括姓、名、性别、年龄属性：现在有个需求，需要对Person进行以下规则的排序
 * 谁的姓拼音靠前，谁就排前面。
 * 然后对名字进行排序。如果同名，女性排前头。
 * 如果名字和性别都相同，年龄小的排前头。
 *
 int compare(Object o1, Object o2) 返回一个基本类型的整型
 如果要按照升序排序，
 则o1 小于o2，返回-1（负数），相等返回0，01大于02返回1（正数）
 如果要按照降序排序
 则o1 小于o2，返回1（正数），相等返回0，01大于02返回-1（负数）
 */
public class Person {
    String firstname,lastname;
    char sex;
    Integer age;

    public Person(String firstname, String lastname, char sex, Integer age) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.sex = sex;
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public char getSex() {
        return sex;
    }
    public void setSex(char sex) {
        this.sex = sex;
    }
}
