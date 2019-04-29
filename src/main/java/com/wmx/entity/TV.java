package com.wmx.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2019/2/27 0027.
 * 电视机实体。应用启动时自动，配置文件中配置 ddl-auto: update：如果数据库不存在，则自动新建，否则不再新建。
 */
@Entity
public class TV {
    //strategy 指定主键生成的方式，AUTO 可以指定 H2 数据库主键自动增长，IDENTITY 可以指定 mysql 主键自动增长
    @Id//标识为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tvId;//电视id，主键

    /**
     * 下面没标识的属性都会以默认值和数据库表的字段进行映射对应
     * 如果修改默认值，又不属性的，可以参考：https://blog.csdn.net/wangmx1993328/article/details/82048775
     * 中的 "domain Area" 部分
     */
    @Column(length = 16)//长度为16个字符
    private String tvName;//电视名称
    private Float tvPrice;//电视价格
    private Date dateOfProduction;//生产日期

    public Date getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(Date dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    public Integer getTvId() {
        return tvId;
    }

    public void setTvId(Integer tvId) {
        this.tvId = tvId;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public Float getTvPrice() {
        return tvPrice;
    }

    public void setTvPrice(Float tvPrice) {
        this.tvPrice = tvPrice;
    }

    @Override
    public String toString() {
        return "TV{" +
                "tvId=" + tvId +
                ", tvName='" + tvName + '\'' +
                ", tvPrice=" + tvPrice +
                ", dateOfProduction=" + dateOfProduction +
                '}';
    }
}
