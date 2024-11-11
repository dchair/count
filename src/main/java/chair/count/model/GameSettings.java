package chair.count.model;

import java.util.Date;

public class GameSettings {
    private Integer settingId;
    private Integer baseFanPrice;
    private Integer perFanPrice;
    private Integer calculateFan;
    private Date createdDate;
    private Date lastModifiedDate;

    public Integer getSettingId() {
        return settingId;
    }

    public void setSettingId(Integer settingId) {
        this.settingId = settingId;
    }

    public Integer getBaseFanPrice() {
        return baseFanPrice;
    }

    public void setBaseFanPrice(Integer baseFanPrice) {
        this.baseFanPrice = baseFanPrice;
    }

    public Integer getPerFanPrice() {
        return perFanPrice;
    }

    public void setPerFanPrice(Integer perFanPrice) {
        this.perFanPrice = perFanPrice;
    }

    public Integer getCalculateFan() {
        return calculateFan;
    }

    public void setCalculateFan(Integer calculateFan) {
        this.calculateFan = calculateFan;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
