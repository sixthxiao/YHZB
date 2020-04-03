package com.yahu.live.bean;

import java.io.Serializable;

public class VersionResult implements Serializable {
    private String versionId;
    private String sort;
    private String summary;
    private boolean force;
    private String link;
    private String versionNo;

    public String getId() {
        return versionId;
    }

    public void setId(String id) {
        this.versionId = id;
    }

    public String getVersion() {
        return sort;
    }

    public void setVersion(String version) {
        this.sort = version;
    }

    public String getDetail() {
        return summary;
    }

    public void setDetail(String detail) {
        this.summary = detail;
    }

    public boolean isForce_update() {
        return force;
    }

    public void setForce_update(boolean force_update) {
        this.force = force_update;
    }

    public String getUrl() {
        return link;
    }

    public void setUrl(String url) {
        this.link = url;
    }

    public String getCreated_at() {
        return versionNo;
    }

    public void setCreated_at(String created_at) {
        this.versionNo = created_at;
    }

    public int getVersionCode() {
        int retcode = 0;
        if (null != getVersion() && getVersion().length() > 0) {
            try {
                retcode = Integer.parseInt(getVersion());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return retcode;
    }
}
