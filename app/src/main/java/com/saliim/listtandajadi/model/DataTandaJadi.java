package com.saliim.listtandajadi.model;

import com.google.gson.annotations.SerializedName;

public class DataTandaJadi {

    @SerializedName("create_by")
    private String createBy;

    @SerializedName("tanda_jadi")
    private String tandaJadi;

    @SerializedName("created")
    private String created;

    @SerializedName("modified")
    private String modified;

    @SerializedName("id")
    private String id;

    @SerializedName("mod_by")
    private String modBy;

    public void setCreateBy(String createBy){
        this.createBy = createBy;
    }

    public String getCreateBy(){
        return createBy;
    }

    public void setTandaJadi(String tandaJadi){
        this.tandaJadi = tandaJadi;
    }

    public String getTandaJadi(){
        return tandaJadi;
    }

    public void setCreated(String created){
        this.created = created;
    }

    public String getCreated(){
        return created;
    }

    public void setModified(String modified){
        this.modified = modified;
    }

    public String getModified(){
        return modified;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
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
                "DataTandaJadi{" +
                        "create_by = '" + createBy + '\'' +
                        ",tanda_jadi = '" + tandaJadi + '\'' +
                        ",created = '" + created + '\'' +
                        ",modified = '" + modified + '\'' +
                        ",id = '" + id + '\'' +
                        ",mod_by = '" + modBy + '\'' +
                        "}";
    }
}
