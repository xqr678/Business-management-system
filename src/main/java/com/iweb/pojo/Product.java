package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author XQR
 * @date 2022/8/12 2022/8/12
 * @dsecription 类的描述和介绍
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private float price;
    private int stock;
    private int cid;
    /**
     * 商品关联的图片集合
     */
    private List<Img> images;
}
