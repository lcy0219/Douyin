package com.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户基本信息表
 * </p>
 *
 * @author chenyuan
 * @since 2023年11月28日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("user_profile")
@AllArgsConstructor
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名称
     */
    @TableField("name")
    private String name;

    /**
     * 关注总数
     */
    @TableField("follow_count")
    private Integer followCount;

    /**
     * 粉丝总数
     */
    @TableField("follower_count")
    private Long followerCount;

    /**
     * 用户头像
     */
    @TableField("avater")
    private String avater;

    /**
     * 用户个人页顶部大图
     */
    @TableField("background_image")
    private String backgroundImage;

    /**
     * 个人简介
     */
    @TableField("signature")
    private String signature;

    /**
     * 获赞总数
     */
    @TableField("total_favorited")
    private Long totalFavorited;

    /**
     * 作品数
     */
    @TableField("work_count")
    private Integer workCount;

    /**
     * 喜欢数
     */
    @TableField("favorite_count")
    private Integer favoriteCount;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    @TableField("updated_at")
    private LocalDateTime updatedAt;

    /**
     * 删除时间
     */
    @TableField("deleted_at")
    private LocalDateTime deletedAt;


}
