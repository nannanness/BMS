package org.nannanness.bms.domain;

import java.util.Objects;

public class Libarary {
    private String name;
    private String where;
    private String service;
    private String opentime;

    public Libarary() {
    }

    public Libarary(String name, String where, String service, String opentime) {
        this.name = name;
        this.where = where;
        this.service = service;
        this.opentime = opentime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getOpentime() {
        return opentime;
    }

    public void setOpentime(String opentime) {
        this.opentime = opentime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libarary libarary = (Libarary) o;
        return Objects.equals(name, libarary.name) &&
                Objects.equals(where, libarary.where) &&
                Objects.equals(service, libarary.service) &&
                Objects.equals(opentime, libarary.opentime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, where, service, opentime);
    }

    @Override
    public String toString() {
        return "Libarary{" +
                "name='" + name + '\'' +
                ", where='" + where + '\'' +
                ", service='" + service + '\'' +
                ", opentime='" + opentime + '\'' +
                '}';
    }
}
