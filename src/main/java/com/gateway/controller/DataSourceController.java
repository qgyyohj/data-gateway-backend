package com.gateway.controller;

import com.gateway.entity.Datasource;
import com.gateway.service.DataSourceService;
import com.gateway.service.DatasourceManageService;
import com.gateway.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Z
 */
@RestController
@RequestMapping("/ds")
public class DataSourceController {

    private final static Logger log = LoggerFactory.getLogger(DataSourceController.class);

    @Autowired
    DatasourceManageService datasourceManageService;

    @GetMapping("/addDataSource")
    public Map<String,Object> addDataSource(Datasource datasource){
        try {
            log.info("添加数据源"+datasource);
            datasourceManageService.addDatasource(datasource);
            return Response.commonSuccess("添加成功");
        }catch (Exception e){
            return Response.commonFail("添加数据源失败");
        }
    }

    @GetMapping("/delete")
    public Map<String,Object> removeDatasource(@RequestParam(value = "ids")List<String> ids){
        try{
            log.info("删除数据源"+ids);
            ids.stream().forEach(id->datasourceManageService.removeDatasource(Integer.parseInt(id)));
            return Response.commonSuccess("删除数据源成功");
        }catch (Exception e){
            log.error(e.getMessage());
            return Response.commonFail("删除数据源失败");
        }
    }

    @GetMapping("/queryDatasource")
    public Map<String,Object> getDatasources(Integer id){
        try{
            log.info("查询数据源，用户id:",id);
            return Response.commonSuccess(datasourceManageService.queryAll(id));
        }catch (Exception e){
            log.error(e.getMessage());
            return Response.commonFail("查询失败");
        }
    }

    @GetMapping("/update")
    public Map<String, Object> update(Datasource datasource){
        try{
            log.info("更新数据源",datasource);
            datasourceManageService.updateDatasource(datasource);
            return Response.commonSuccess("更新成功");
        }catch (Exception e){
            log.error(e.getMessage());
            return Response.commonFail("更新失败");
        }
    }

    @GetMapping("/queryDetail")
    public Map<String, Object> queryDetail(Integer id){
        try{
            log.info("获取数据源详情:"+id);
            datasourceManageService.queryAll(null).stream().filter(x->x.getId().equals(id)).findFirst().get();
            return Response.commonSuccess(datasourceManageService.queryAll(null).stream().filter(x->x.getId().equals(id)).findFirst().get());
        }catch (Exception e){
            log.error(e.getMessage());
            return Response.commonFail("获取数据源详情失败");
        }
    }
}
