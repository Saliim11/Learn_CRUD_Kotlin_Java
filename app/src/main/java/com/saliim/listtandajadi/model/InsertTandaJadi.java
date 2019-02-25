package com.saliim.listtandajadi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InsertTandaJadi {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("tanda_jadi")
    @Expose
    private String tandaJadi;
    @SerializedName("create_by")
    @Expose
    private String createBy;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTandaJadi() {
        return tandaJadi;
    }

    public void setTandaJadi(String tandaJadi) {
        this.tandaJadi = tandaJadi;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
