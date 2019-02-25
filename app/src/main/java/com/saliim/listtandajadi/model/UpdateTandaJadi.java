package com.saliim.listtandajadi.model;

import com.google.gson.annotations.SerializedName;

public class UpdateTandaJadi {

    @SerializedName("tanda_jadi")
    private String tandaJadi;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private String status;

    @SerializedName("mod_by")
    private String modBy;

    public void setTandaJadi(String tandaJadi){
        this.tandaJadi = tandaJadi;
    }

    public String getTandaJadi(){
        return tandaJadi;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    public void setModBy(String modBy){
        this.modBy = modBy;
    }

    public String getModBy(){
        return modBy;
    }

    @Override
    public String toString(){
        return
                "UpdateTandaJadi{" +
                        "tanda_jadi = '" + tandaJadi + '\'' +
                        ",message = '" + message + '\'' +
                        ",status = '" + status + '\'' +
                        ",mod_by = '" + modBy + '\'' +
                        "}";
    }
}
