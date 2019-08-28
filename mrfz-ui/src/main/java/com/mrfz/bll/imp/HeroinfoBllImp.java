package com.mrfz.bll.imp;

import com.mrfz.bean.HeroBaseInfoBean;
import com.mrfz.bll.IHeroinfoBll;
import com.mrfz.dao.IHeroInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class HeroinfoBllImp implements IHeroinfoBll {
    @Resource
    private IHeroInfoMapper iHeroInfoMapper;

    @Override
    public List<HeroBaseInfoBean> getAllHero() {
        return iHeroInfoMapper.selectAllHero();
    }
}
