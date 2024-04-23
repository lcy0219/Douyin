package com.service.impl;

import com.entity.VideoInfo;
import com.dao.VideoInfoMapper;
import com.service.VideoInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.utils.ExtractVideoFirstFrameUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 视频信息表 服务实现类
 * </p>
 *
 * @author chenyuan
 * @since 2023年11月28日
 */
@Service
public class VideoInfoServiceImpl extends ServiceImpl<VideoInfoMapper, VideoInfo> implements VideoInfoService {

    @Override
    public void publishVideo(byte[] data, String title, Long id) {
        String baseUrl = "C:\\Users\\10242\\Videos\\Captures\\douyin\\" + title + System.currentTimeMillis() + ".mp4";
        try (FileOutputStream outputStream = new FileOutputStream(baseUrl)) {
            // 将字节数组写入文件
            outputStream.write(data);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File file = new File(baseUrl);
            String coverPath = ExtractVideoFirstFrameUtil.extract(baseUrl, "C:\\Users\\10242\\Pictures\\douyin");
            File cover = new File(coverPath);

            this.baseMapper.insert(new VideoInfo(
                    null,
                    id,
                    file.toURI().toURL().toExternalForm(),
                    cover.toURI().toURL().toExternalForm(),
                    null,
                    null,
                    title,
                    LocalDateTime.now(),
                    null,
                    null
            ));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<VideoInfo> showVideoList(Long id) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", id);
        List<VideoInfo> videoInfos = this.baseMapper.selectByMap(map);
        return videoInfos;
    }

    @Override
    public List<VideoInfo> showVideoWithoutLogin() {
        this.baseMapper.getVideoListBefore(LocalDateTime.now());
        return this.baseMapper.getVideoListBefore(LocalDateTime.now());
    }

}
