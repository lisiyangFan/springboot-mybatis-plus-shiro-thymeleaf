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
@TableName("sys_users_permissions")
public class SysUsersPermissions extends Model<SysUsersPermissions> {

    private static final long serialVersionUID = 1L;

    @TableId("user_id")
    private Integer userId;
    @TableField("permission_id")
    private Integer permissionId;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "SysUsersPermissions{" +
        ", userId=" + userId +
        ", permissionId=" + permissionId +
        "}";
    }
}
