package com.mrsdeus.panel.user.persitence.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private User user;

    @Column(length = 45)
    private String ip_user;

    private Timestamp ts_access;

    private String device;

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getIp_user() {
        return ip_user;
    }

    public void setIp_user(String ip_user) {
        this.ip_user = ip_user;
    }

    public Timestamp getTs_access() {
        return ts_access;
    }

    public void setTs_access(Timestamp ts_access) {
        this.ts_access = ts_access;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}
