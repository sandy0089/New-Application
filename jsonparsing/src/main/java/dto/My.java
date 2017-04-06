package dto;

import junit.runner.Version;

import java.util.ArrayList;

/**
 * Created by Sandy on 06-04-2017.
 */

public class My {

    private String name;
    private String os;
    private double ver;
    private Versions allVersions;
    private ArrayList<Device> devices;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public double getVer() {
        return ver;
    }

    public void setVer(double ver) {
        this.ver = ver;
    }

    public Versions getAllVersions() {
        return allVersions;
    }

    public void setAllVersions(Versions allVersions) {
        this.allVersions = allVersions;
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }

    public void setDevices(ArrayList<Device> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "My{" +
                "name='" + name + '\'' +
                ", os='" + os + '\'' +
                ", ver=" + ver +
                ", allVersions=" + allVersions +
                ", devices=" + devices +
                '}';
    }
}
