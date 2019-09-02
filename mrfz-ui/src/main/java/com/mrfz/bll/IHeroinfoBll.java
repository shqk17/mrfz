package com.mrfz.bll;

import com.mrfz.bean.HeroBaseInfoBean;

import java.util.List;

public interface IHeroinfoBll {


    List<HeroBaseInfoBean> getAllHero(Integer starsOrder);

    List<HeroBaseInfoBean> getInfoByTj(String sql, String tagsql, String orderStr);
}
