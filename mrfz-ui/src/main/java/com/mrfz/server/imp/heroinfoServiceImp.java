package com.mrfz.server.imp;

import com.mrfz.bean.HeroBaseInfoBean;
import com.mrfz.bll.IHeroinfoBll;
import com.mrfz.dao.IHeroInfoMapper;
import com.mrfz.server.IHeroinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class heroinfoServiceImp implements IHeroinfoService {
    @Resource
    private IHeroinfoBll iHeroinfoBll;
    @Override
    public List<HeroBaseInfoBean> getAllHero() {

        return iHeroinfoBll.getAllHero();
    }

    @Override
    public List<HeroBaseInfoBean> getInfoByTj(HeroBaseInfoBean heroBaseInfoBean) {
        return iHeroinfoBll.getInfoByTj(heroBaseInfoBean);
    }
}
