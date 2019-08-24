package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.opjo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    /*
    * 功能:根据父节点id查询子节点
    * 时间:2019-8-21
    * */
    public List<Category> queryCategoriesByPid(Long id){
        Category category=new Category();
        category.setParentId(id);
        return this.categoryMapper.select(category);
    }
}
