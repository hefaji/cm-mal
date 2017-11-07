package com.xiaobaidu.mall.entity;

import java.math.BigDecimal;

/**
 * @author hefaji
 * @create 2017-09-20 15:15
 **/
public class CommThemeEventDetail {
    private String id;

    private String eventId;

    private Commodity relateCommodity;

    private BigDecimal themeSellPrice;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Commodity getRelateCommodity() {
        return relateCommodity;
    }

    public void setRelateCommodity(Commodity relateCommodity) {
        this.relateCommodity = relateCommodity;
    }

    public BigDecimal getThemeSellPrice() {
        return themeSellPrice;
    }

    public void setThemeSellPrice(BigDecimal themeSellPrice) {
        this.themeSellPrice = themeSellPrice;
    }
}
