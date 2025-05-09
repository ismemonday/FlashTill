package org.flash.till.base.persistent.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@TableName("ft_rbac_user")
public class RbacUserEntity extends AbstractEntity{
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("`password`")
    private String password;

    /**
     * 头像
     */
    @TableField("icon")
    private String icon;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 备注信息
     */
    @TableField("note")
    private String note;

    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    @TableField("`status`")
    private Boolean status;

    /**
     * 逻辑删除
     */
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;

    /**
     * 创建用户
     */
    @TableField(value = "created_by", fill = FieldFill.INSERT)
    private String createdBy;

    /**
     * 更新用户
     */
    @TableField(value = "modified_by", fill = FieldFill.INSERT_UPDATE)
    private String modifiedBy;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    public boolean isEnabled() {
        return this.getStatus();
    }
}
