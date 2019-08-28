package com.mrfz.bll;

import com.mrfz.bean.HeroBaseInfoBean;

import java.util.List;

public interface IHeroinfoBll {
    List<HeroBaseInfoBean> getAllHero();

    List<HeroBaseInfoBean> getInfoByTj(HeroBaseInfoBean heroBaseInfoBean);
}
