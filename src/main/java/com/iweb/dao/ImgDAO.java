package com.iweb.dao;

import com.iweb.pojo.Img;

import java.util.List;

/**
 * @author XQR
 * @date 2022/8/15 2022/8/15
 * @dsecription 类的描述和介绍
 */
public interface ImgDAO  {
    void add(Img img);
    void delete(int id);
    List<Img> select(int pid);
}
