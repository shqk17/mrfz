package com.mrfz.server.imp;

import com.mrfz.bean.HeroBaseInfoBean;
import com.mrfz.bll.IHeroinfoBll;
import com.mrfz.server.IHeroinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class heroinfoServiceImp implements IHeroinfoService {

    @Resource
    private IHeroinfoBll iHeroinfoBll;

    @Override
    public List<HeroBaseInfoBean> getAllHero(Integer starsOrder) {

        return iHeroinfoBll.getAllHero(starsOrder);
    }

    @Override
    public List<HeroBaseInfoBean> getInfoByTj(String starts, String jobs, String sexs, String places, String tags, Integer starsOrder, String name) {
        StringBuilder sql = new StringBuilder();
        sql.append(" 1=1");
        if (starts != null && starts.length()>0) {
            String starStr =String.join("','",starts.split(","));
            sql.append(" and stars in ('").append(starStr).append("')");
        }
        if (name  != null && name.length()>0) {
            sql.append(" and name like ('%").append(name).append("%')");
        }
        if(jobs != null && jobs.length()>0){
            String jobsStr =String.join("','",jobs.split(","));
            sql.append(" and job in ('").append(jobsStr).append("')");
        }
        if(sexs != null && sexs.length()>0){
            String sexsStr =String.join("','",sexs.split(","));
            sql.append(" and sex in ('").append(sexsStr).append("')");
        }
        if(places != null && places.length()>0){
            String placesStr =String.join("','",places.split(","));
            sql.append(" and place in ('").append(placesStr).append("')");
        }
        StringBuilder tagStrs = new StringBuilder();
        tagStrs.append(" 1=1 ");
        if(tags != null && tags.length()>0){
            String[] tagsz = tags.split(",");
            List<String> taglist = new ArrayList<>();
            int num = 0;
            for (String s :tagsz){
                if(s!=null&&s.length()>0){
                    num = num+1;
                    taglist.add(s);
                }
            }
            String tagStr =String.join("','",taglist);
            tagStrs.append(" and b.tagId in ('").append(tagStr).append("')");
        }


        String orderStr = " order by stars desc";
        if(starsOrder == 0){
            orderStr = " order by stars ";
        }


        return iHeroinfoBll.getInfoByTj(sql.toString(),tagStrs.toString(),orderStr);
    }
}
