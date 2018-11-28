package com.ly.spring.beans;

import javax.xml.stream.events.ProcessingInstruction;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 11:04 2018/10/26
 * @Modified By:
 */
public class Personal {
    private String name;
    private String background;
    private String major;
    private String college;

    public Personal() {
        super();
    }

    public Personal(String name, String background, String major, String college) {
        super();
        this.name = name;
        this.background = background;
        this.major = major;
        this.college = college;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "name='" + name + '\'' +
                ", background='" + background + '\'' +
                ", major='" + major + '\'' +
                ", college='" + college + '\'' +
                '}';
    }
}
