package com.mrfz.dao;

import com.mrfz.bean.HeroBaseInfoBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface IHeroInfoMapper {

    List<HeroBaseInfoBean> selectAllHero(String orderStr);


    List<HeroBaseInfoBean> selectInfoByTj(HeroBaseInfoBean heroBaseInfoBean);
}
