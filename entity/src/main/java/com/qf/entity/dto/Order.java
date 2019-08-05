package com.qf.entity.dto;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qf.entity.base.BaseDto;

import java.sql.Timestamp;
import java.util.Date;

@TableName("order")
public class Order extends BaseDto {

  @TableField("merchant_user_id")
  private Long merchantUserId;
  @TableField("phone")
  private String phone;
  @TableField("name")
  private String name;
  @TableField("goods_id")
  private Long goodsId;
  @TableField("num")
  private Long num;
  @TableField("province")
  private String province;
  @TableField("city")
  private String city;
  @TableField("area")
  private String area;
  @TableField("address")
  private String address;
  @TableField("remark")
  private String remark;
  @TableField("pay_type")
  private Long payType;
  @TableField("sku_id")
  private Long skuId;
  @TableField("price")
  private Long price;
  @TableField("pay_state")
  private Long payState;
  @TableField("create_time")
  private Date createTime;


  public Long getMerchantUserId() {
    return merchantUserId;
  }

  public void setMerchantUserId(Long merchantUserId) {
    this.merchantUserId = merchantUserId;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Long goodsId) {
    this.goodsId = goodsId;
  }

  public Long getNum() {
    return num;
  }

  public void setNum(Long num) {
    this.num = num;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Long getPayType() {
    return payType;
  }

  public void setPayType(Long payType) {
    this.payType = payType;
  }

  public Long getSkuId() {
    return skuId;
  }

  public void setSkuId(Long skuId) {
    this.skuId = skuId;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public Long getPayState() {
    return payState;
  }

  public void setPayState(Long payState) {
    this.payState = payState;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
