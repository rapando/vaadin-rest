package com.example.application.data;

public class AppDTO {
    /*
    app_id
    app_name
    active
    created
    modified
     */
    private int app_id;
    private String app_name;
    private int active;
    private String created;
    private String modified;

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    @Override
    public int hashCode() {
        return app_id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof  AppDTO)) {
            return false;
        }
        return app_id == ((AppDTO) obj).app_id;
    }

    @Override
    public String toString() {
        return app_name;
    }
}
