package com.qf.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qf.entity.base.BaseDto;

@TableName("admin")
public class Admin extends BaseDto {

  @TableField("role_id")
  private Long roleId;
  @TableField("name")
  private String name;
  @TableField("account")
  private String account;
  @TableField("password")
  private String password;
  @TableField("description")
  private String description;

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
