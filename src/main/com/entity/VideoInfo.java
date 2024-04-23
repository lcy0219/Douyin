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
 * 视频信息表
 * </p>
 *
 * @author chenyuan
 * @since 2023年11月28日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("video_info")
@AllArgsConstructor
public class VideoInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 视频ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 视频播放地址
     */
    @TableField("play_url")
    private String playUrl;

    /**
     * 视频封面地址
     */
    @TableField("cover_url")
    private String coverUrl;

    /**
     * 视频的点赞总数
     */
    @TableField("favorite_count")
    private Long favoriteCount;

    /**
     * 视频的评论总数
     */
    @TableField("comment_count")
    private Long commentCount;

    /**
     * 视频标题
     */
    @TableField("title")
    private String title;

    /**
     * 创建时间
     */
    @TableField("created_at")
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
