package com.example.demo20204q.Model;

public class Corporation {

    
    private String corporationId;
    
    private String userName;
    
    public Corporation(String corporationId, String userId){
        this.corporationId = corporationId;
        this.userName = userId;
    }

    public String getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(String corporationId) {
        this.corporationId = corporationId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
}
