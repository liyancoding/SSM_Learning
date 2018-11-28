package com.ly.spring.beans;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 11:06 2018/10/26
 * @Modified By:
 */
public class Company {
    private String name;
    private String industry;

    public Company() {
        super();
    }

    public Company(String name, String industry) {
        super();
        this.name = name;
        this.industry = industry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", industry='" + industry + '\'' +
                '}';
    }
}
