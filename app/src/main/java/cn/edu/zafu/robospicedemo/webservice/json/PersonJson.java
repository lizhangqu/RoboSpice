package cn.edu.zafu.robospicedemo.webservice.json;

import com.google.api.client.util.Key;

/**
 * Created by lizhangqu on 2015/4/15.
 */
public class PersonJson {
    @Key
    private int id;
    @Key
    private String name;
    @Key
    private int age;
    @Key
    private String address;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
