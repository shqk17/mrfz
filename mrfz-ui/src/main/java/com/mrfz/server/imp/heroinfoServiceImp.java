package com.mrfz.server.imp;

import com.mrfz.bean.HeroBaseInfoBean;
import com.mrfz.bean.HeroJobEnum;
import com.mrfz.bean.HeroPlaceEnum;
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
            String[] jobIds = jobs.split(",");
            List<String> jobNames = new ArrayList<>();
            for(String jobId : jobIds){
                jobNames.add(HeroJobEnum.getName(jobId));
            }
            String jobsStr =String.join("','",jobNames);
            sql.append(" and job in ('").append(jobsStr).append("')");
        }
        if(sexs != null && sexs.length()>0){
            String sexsStr =String.join("','",sexs.split(","));
            sql.append(" and sex in ('").append(sexsStr).append("')");
        }
        if(places != null && places.length()>0){
            String[] placeIds = places.split(",");
            List<String> placeNames = new ArrayList<>();
            for(String placeId : placeIds){
                placeNames.add(HeroPlaceEnum.getName(placeId));
            }
            String placesStr =String.join("','",placeNames);
            sql.append(" and place in ('").append(placesStr).append("')");
        }
        StringBuilder tagStrs = new StringBuilder();
        tagStrs.append(" 1=1 ");
        int num = 0;

        if(tags != null && tags.length()>0){
            String[] tagsz = tags.split(",");
            List<String> taglist = new ArrayList<>();
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


        return iHeroinfoBll.getInfoByTj(sql.toString(),tagStrs.toString(),orderStr,num);
    }
}
