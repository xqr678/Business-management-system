package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XQR
 * @date 2022/8/15 2022/8/15
 * @dsecription 类的描述和介绍
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Img {
    private int id;
    private String url;
    private int pid;
}
