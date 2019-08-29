package com.mrfz.controller;

import com.mrfz.bean.HeroBaseInfoBean;
import com.mrfz.bean.ResultBean;
import com.mrfz.server.IHeroinfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/hero")
public class HeroInfoController {
    @Resource
    private IHeroinfoService iHeroinfoService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllHero(Integer starsOrder, Integer seniorityOrder) {

        try {
            if (starsOrder == null) {
                starsOrder = 1;
            }
            List<HeroBaseInfoBean> heroBaseInfoBeanList = iHeroinfoService.getAllHero(starsOrder);
            if (heroBaseInfoBeanList != null && heroBaseInfoBeanList.size() > 0) {
                return new ResponseEntity<>(new ResultBean<>(true, "查询成功", heroBaseInfoBeanList),
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResultBean<>(false, "未查询到数据", null),
                        HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ResultBean<>(false, "系统异常" + e.getMessage(), null),
                    HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/getInfoBy", method = RequestMethod.GET)
    public ResponseEntity<Object> getInfoByTj(HeroBaseInfoBean heroBaseInfoBean) {

        try {
            List<HeroBaseInfoBean> heroBaseInfoBeanList = iHeroinfoService.getInfoByTj(heroBaseInfoBean);
            if (heroBaseInfoBeanList != null && heroBaseInfoBeanList.size() > 0) {
                return new ResponseEntity<>(new ResultBean<>(true, "查询成功", heroBaseInfoBeanList),
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResultBean<>(false, "未查询到数据", null),
                        HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ResultBean<>(false, "系统异常" + e.getMessage(), null),
                    HttpStatus.OK);
        }

    }
}
