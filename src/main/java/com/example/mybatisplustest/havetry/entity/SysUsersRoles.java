package com.example.mybatisplustest.havetry.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lisiyang
 * @since 2018-03-31
 */
@TableName("sys_users_roles")
public class SysUsersRoles extends Model<SysUsersRoles> {

    private static final long serialVersionUID = 1L;

    @TableId("user_id")
    private Integer userId;
    @TableField("role_id")
    private Integer roleId;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "SysUsersRoles{" +
        ", userId=" + userId +
        ", roleId=" + roleId +
        "}";
    }
}
