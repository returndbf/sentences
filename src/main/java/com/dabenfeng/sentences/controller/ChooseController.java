package com.dabenfeng.sentences.controller;

import com.dabenfeng.sentences.entity.Choose;
import com.dabenfeng.sentences.entity.Result;
import com.dabenfeng.sentences.service.ChooseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChooseController {
    @Autowired
    private ChooseService chooseService;
    @Autowired
    private Result result;
    @RequestMapping("getRandomChoose")
    public Result<String> getRandomChoose() {
        String chooseResult = chooseService.getRandomChoose();
        if(chooseResult!=null){
            return result.successResult(chooseResult);
        }
        return result.failResult() ;
    }

    @RequestMapping("getAllChoose")
    public Result<List<Choose>> getAllChoose(){
        List<Choose> allChoose = chooseService.getAllChoose();
        if(allChoose.size()>0&&allChoose!=null){
            return result.successResult(allChoose);
        }else{
            return result.successResult("查询不到数据");
        }
    }
    //删除不能查
    @RequestMapping("getChooseByPrefix")
    public Result<List<String>>  getChooseByPrefix(String prefix) {
        List<Choose> list = chooseService.getChooseByPrefix(prefix);
        if(list.size()>0){
            return result.successResult(list);
        }else{
            return result.successResult("无数据",null);
        }

    }
    //删除也能查
    @RequestMapping("getAllChooseByPrefix")
    public Result<List<String>>  getAllChooseByPrefix(String prefix) {
        List<Choose> list = chooseService.getAllChooseByPrefix(prefix);
        if(list.size()>0){
            return result.successResult(list);
        }else{
            return result.successResult("无数据",null);
        }

    }

    @RequestMapping("getAllPrefix")
    public Result<List<String>> getAllPrefix() {
        List<String> list = chooseService.getAllPrefix();
        if(list.size()>0){
            return result.successResult(list);
        }else{
            return result.successResult("无数据",null);
        }

    }

    @RequestMapping("insertChoose")
    public Result<Choose> insertChoose(Choose choose) {
        int row = chooseService.insertChoose(choose);
        if(row>0){
            return result.successResult("添加成功",choose);
        }else{
            return result.failResult("添加失败");
        }
    }

    @RequestMapping("delChoose")
    public Result<Integer> delChoose(int id) {
        int row = chooseService.delChoose(id);
        if(row>0){
            return result.successResult("删除成功");
        }else{
            return result.failResult("删除失败");
        }

    }
}
