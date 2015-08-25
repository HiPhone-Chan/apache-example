package com.chf.example.domain;

public class AppInfo {

    private Long id;

    private String appName;

    private String appVersion;

    private String appDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }

    @Override
    public String toString() {
        return String
                .format("AppInfo [id=%s, appName=%s, appVersion=%s, appDescription=%s]",
                        id, appName, appVersion, appDescription);
    }

}
