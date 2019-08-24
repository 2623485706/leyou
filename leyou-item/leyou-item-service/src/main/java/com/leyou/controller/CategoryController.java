package com.leyou.controller;

import com.leyou.item.opjo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.Request;

import javax.xml.ws.Response;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    /*
     * 功能:根据父节点id查询子节点
     * 时间:2019-8-21
     * */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoriesByPid(@RequestParam(value = "pid",defaultValue = "0") Long id){
        if(id==null|| id<0){
            //400 参数不合法
            return ResponseEntity.badRequest().build();
        }
        List<Category> categories= this.categoryService.queryCategoriesByPid(id);
        if (CollectionUtils.isEmpty(categories)){
            //404 资源服务器未找到
            return ResponseEntity.notFound().build();
        }
        //200：查询成功
        return ResponseEntity.ok(categories);
    }

    /*
     * 功能:根据父节点id查询子节点
     * 时间:2019-8-21
     * */

    @PostMapping
    public ResponseEntity<Void> handleAdd(Category category){
        System.out.println(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("list/handleDelete")
    public void c1(@RequestParam(value = "pid") Long id){
        System.out.println("ccccc2");
    }
}
