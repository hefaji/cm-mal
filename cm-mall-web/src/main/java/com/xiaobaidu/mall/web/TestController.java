package com.xiaobaidu.mall.web;


import com.xiaobaidu.mall.service.TestService;
import com.xiaobaidu.mall.util.JsonUtils;
import com.xiaobaidu.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author hefaji
 * @create 2017-09-14 9:49
 **/
@RestController
public class TestController {
    @Autowired
    private TestService testService;
    @RequestMapping(value="/test")
    public String index(){
        String data = testService.test();
        return data ;
    }
}
