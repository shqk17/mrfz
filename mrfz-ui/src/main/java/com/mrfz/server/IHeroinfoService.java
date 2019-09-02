package com.mrfz.server;

import com.mrfz.bean.HeroBaseInfoBean;

import java.util.List;

public interface IHeroinfoService {
    List<HeroBaseInfoBean> getAllHero(Integer starsOrder);

    List<HeroBaseInfoBean> getInfoByTj(String starts, String jobs, String sexs, String places, String tags, Integer starsOrder, String name);
}
