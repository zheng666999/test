package com.background.demo.service;

import com.background.demo.dao.StoreDao;
import com.background.demo.entity.Page;
import com.background.demo.entity.Store;
import com.background.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Service
public class StoreService {
    @Resource
    StoreDao sd;

    public int selectToatal(){
        return sd.selectToatal();
    }
    public List<Store>  selectByPage(Page page){
        int offset = page.getPagenum()*page.getPagesize();
        return sd.selectByPage(offset,page.getPagesize());
    }
    public Store findStoreById(int store_id){
        return sd.findStoreById(store_id);
        }
    public boolean insertStore(Store store){
        if(sd.insertStore(store)>0){
            return true;
        }
        return false;
    }
    public boolean deleteStore(Store store){
        if(sd.deleteStore(store)>0){
            return true;
        }
        return false;
    }
    public boolean updateActive(Store store){
        if(sd.updateActive(store)>0){
            return true;
        }
        return false;
    }
    public boolean updateConf(Store store){
        if(sd.updateConf(store)>0){
            return true;
        }
        return false;
    }
}
