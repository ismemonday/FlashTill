package org.flash.till.base.persistent.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@TableName("ft_rbac_role")
public class RbacRoleEntity extends AbstractEntity{
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 租户ID
     */
    @TableField("tenant_id")
    private Long tenantId;

    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;

    /**
     * 父级角色ID
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 昵称
     */
    @TableField("`nick_name`")
    private String nickName;

    /**
     * 限制用户数量
     */
    @TableField("user_count")
    private Integer userCount;

    /**
     * 启用状态：0->禁用；1->启用
     */
    @TableField("`status`")
    private Boolean status;

    @TableField("sort")
    private Integer sort;

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
}
