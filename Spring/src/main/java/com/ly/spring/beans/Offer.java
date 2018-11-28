package com.ly.spring.beans;

import com.mysql.jdbc.UpdatableResultSet;

import java.util.Map;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 11:08 2018/10/26
 * @Modified By:
 */
public class Offer {
    private Map<Company,Personal> personalMap;
    private int status;

    public Offer() {
        super();
    }

    public Offer(Map<Company, Personal> personalMap, int status) {
        this.personalMap = personalMap;
        this.status = status;
    }

    public Map<Company, Personal> getPersonalMap() {
        return personalMap;
    }

    public void setPersonalMap(Map<Company, Personal> personalMap) {
        this.personalMap = personalMap;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "personalMap=" + personalMap +
                ", status=" + status +
                '}';
    }
}
