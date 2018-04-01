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
@TableName("sys_roles_permissions")
public class SysRolesPermissions extends Model<SysRolesPermissions> {

    private static final long serialVersionUID = 1L;

    @TableId("role_id")
    private Integer roleId;
    @TableField("permission_id")
    private Integer permissionId;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }

    @Override
    public String toString() {
        return "SysRolesPermissions{" +
        ", roleId=" + roleId +
        ", permissionId=" + permissionId +
        "}";
    }
}
