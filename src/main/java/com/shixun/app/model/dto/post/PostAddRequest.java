package com.shixun.app.model.dto.post;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

/**
 * 创建请求
 *
 * @author Huang
 * @from Huang
 */
@Data
public class PostAddRequest implements Serializable {

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表
     */
    private List<String> tags;

    /**
     * 文件属性
     */
    private MultipartFile file;

    private static final long serialVersionUID = 1L;
}