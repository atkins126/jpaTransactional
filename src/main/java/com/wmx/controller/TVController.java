package com.wmx.controller;

import com.wmx.entity.TV;
import com.wmx.service.TVService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;


@Controller
public class TVController {
    @Resource
    private TVService tvService;

    @GetMapping("findAll")
    @ResponseBody
    public String findAll() {
        return tvService.findAll().toString();
    }

    @GetMapping("save")
    public String save() {
        TV tv = new TV();
        tv.setTvName("海信RS" + new Random().nextInt(1000));
        tv.setTvPrice(new Random().nextFloat() * 1000 + 6000);
        tv.setDateOfProduction(new Date());
        tvService.save(tv);
        return "redirect:/findAll";
    }
}
