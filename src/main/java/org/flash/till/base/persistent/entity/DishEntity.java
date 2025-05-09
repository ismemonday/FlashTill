package org.flash.till.base.persistent.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.flash.till.base.persistent.enums.DishCategoryEnum;

@TableName("ft_dish")
public class DishEntity extends AbstractEntity{
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private long id;

    @TableField("name")
    private String name;

    @TableField("shop_id")
    private long shopId;

    @TableField("category")
    private DishCategoryEnum category;

    @TableField("in_price")
    private double inPrice;

    @TableField("out_price")
    private double outPrice;

    @TableField("desc")
    private String desc;

    @TableField("img")
    private byte[] img;
}
