package com.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户点赞视频
 * </p>
 *
 * @author chenyuan
 * @since 2023年11月28日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("video_user_like")
@AllArgsConstructor
public class VideoUserLike implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 视频id
     */
    private Long videoId;


}
