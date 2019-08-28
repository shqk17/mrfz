package com.mrfz.dao;

import com.mrfz.bean.HeroBaseInfoBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface IHeroInfoMapper {

    List<HeroBaseInfoBean> selectAllHero();


    List<HeroBaseInfoBean> selectInfoByTj(HeroBaseInfoBean heroBaseInfoBean);
}
