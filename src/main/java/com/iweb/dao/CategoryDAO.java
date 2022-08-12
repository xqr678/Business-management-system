package com.iweb.dao;

import com.iweb.pojo.Category;

import java.util.List;

/**
 * @author XQR
 * @date 2022/8/11 2022/8/11
 * @dsecription 类的描述和介绍
 */
public interface CategoryDAO {
    /**
     * 增
     *
     * @param category
     * @return
     */
     List<Category> add(Category category);

    /**
     * @param id 删
     * @return
     */
     List<Category> delete(int  id);

    /**
     * @param category 改
     */
     void update(Category category);

    /**
     * @param id 查
     * @return
     */
     Category get(int id);

    /**分页
     * @param start 查询语句起始戒指行数
     * @param count 截取行数
     * @return
     */
     List<Category> listByLimit(int start,int count);

    /**默认查询所有分类
     * @return
     */
    List<Category> list();


}
