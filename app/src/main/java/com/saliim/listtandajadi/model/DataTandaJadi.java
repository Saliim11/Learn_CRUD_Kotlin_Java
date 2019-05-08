package com.saliim.listtandajadi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataTandaJadi {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("tanda_jadi")
    @Expose
    private String tandaJadi;
    @SerializedName("kategori_motor")
    @Expose
    private String kategoriMotor;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("create_by")
    @Expose
    private String createBy;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("mod_by")
    @Expose
    private String modBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTandaJadi() {
        return tandaJadi;
    }

    public void setTandaJadi(String tandaJadi) {
        this.tandaJadi = tandaJadi;
    }

    public String getKategoriMotor() {
        return kategoriMotor;
    }

    public void setKategoriMotor(String kategoriMotor) {
        this.kategoriMotor = kategoriMotor;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getModBy() {
        return modBy;
    }

    public void setModBy(String modBy) {
        this.modBy = modBy;
    }

}
