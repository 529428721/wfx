package com.qf.entity.dto;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qf.entity.base.BaseDto;

@TableName("goods")
public class Goods extends BaseDto {

  @TableField("goods_name")
  private String goodsName;
  @TableField("goods_time")
  private String goodsTime;
  @TableField("goods_describe")
  private String goodsDescribe;


  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }


  public String getGoodsTime() {
    return goodsTime;
  }

  public void setGoodsTime(String goodsTime) {
    this.goodsTime = goodsTime;
  }


  public String getGoodsDescribe() {
    return goodsDescribe;
  }

  public void setGoodsDescribe(String goodsDescribe) {
    this.goodsDescribe = goodsDescribe;
  }

}
