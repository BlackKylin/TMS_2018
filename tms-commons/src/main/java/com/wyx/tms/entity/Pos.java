package com.wyx.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Pos implements Serializable {
    private Integer id;

    /**
     * 销售点名称
     */
    private String posName;

    /**
     * 经营者身份证正面照片
     */
    private String posPic;

    /**
     * 营业执照
     */
    private String posLicense;

    /**
     * 经营者的姓名
     */
    private String ownerName;

    /**
     * 销售点所在地址
     */
    private String posSite;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 创建时间
     */
    private Date obsoleteTime;

    /**
     * 修改时间
     */
    private Date modificationTime;

    /**
     * 联系电话
     */
    private String posNumber;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public String getPosPic() {
        return posPic;
    }

    public void setPosPic(String posPic) {
        this.posPic = posPic;
    }

    public String getPosLicense() {
        return posLicense;
    }

    public void setPosLicense(String posLicense) {
        this.posLicense = posLicense;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPosSite() {
        return posSite;
    }

    public void setPosSite(String posSite) {
        this.posSite = posSite;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Date getObsoleteTime() {
        return obsoleteTime;
    }

    public void setObsoleteTime(Date obsoleteTime) {
        this.obsoleteTime = obsoleteTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getPosNumber() {
        return posNumber;
    }

    public void setPosNumber(String posNumber) {
        this.posNumber = posNumber;
    }
}