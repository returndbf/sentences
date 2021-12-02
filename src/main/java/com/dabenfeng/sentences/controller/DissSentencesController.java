package com.dabenfeng.sentences.controller;

import com.dabenfeng.sentences.entity.Result;
import com.dabenfeng.sentences.entity.Sentence;
import com.dabenfeng.sentences.service.impl.DissSentenceServiceImpl;

import com.dabenfeng.sentences.utils.GetTimeUtils;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dissSentence")
public class DissSentencesController {
    @Autowired
    private DissSentenceServiceImpl dissSentenceService;
    @Autowired
    private Result result;
    @Autowired
    private GetTimeUtils getTimeUtils;
    //获取全部怼人句子对象
    @GetMapping("dissSentenceObj")
    public Result getAllDissSentenceObj(@RequestParam(value="page",defaultValue="1")Integer page, @RequestParam(value="pageSize",defaultValue="5")Integer pageSize) {
        //分页容器
        PageInfo<Sentence> pageInfo = dissSentenceService.getAllDissSentenceObj(page,pageSize);
        //获取真正的数据
        List<Sentence> DissSentencesObj = pageInfo.getList();
        if (DissSentencesObj.size() > 0) {
            return result.successResult(DissSentencesObj);
        } else {
            return result.failResult();
        }
    }
    //获取全部怼人句子
    @GetMapping("dissSentence")
    public Result getAllDissSentence(@RequestParam(value="page",defaultValue="1")Integer page, @RequestParam(value="pageSize",defaultValue="5")Integer pageSize) {
        //分页容器
        PageInfo<String> pageInfo = dissSentenceService.getAllDissSentence(page,pageSize);
        //获取真正的数据
        List<String> DissSentences = pageInfo.getList();
        if (DissSentences.size() > 0) {
            return result.successResult(DissSentences);
        } else {
            return result.failResult();
        }

    }
    //添加怼人句子
    //@RequiresPermissions("add")
    @PostMapping("dissSentence/sentence")
    public Result insertDissSentence(Sentence sentence) {
        //句子添加时间
        sentence.setAddTime(getTimeUtils.getCurrentTime());
        //获取添加受影响行数
        Integer res = dissSentenceService.insertDissSentence(sentence);
        //获取添加完毕的对象,id为数据库id
        Sentence addedSentence = dissSentenceService.getDissSentenceObjById(sentence.getId());
        if (addedSentence != null && res > 0) {
            return result.successResult(addedSentence);
        } else {
            return result.failResult();
        }
    }
    //删除
    //@RequiresPermissions("delete")
    @PutMapping("dissSentence/{id}")
    public Result deleteDissSentence(@PathVariable("id") Integer id) {
        //获取要修改的句子
        Sentence deletedSentence = dissSentenceService.getDissSentenceObjById(id);
        System.out.println(deletedSentence);
        //句子删除时间
        deletedSentence.setDeleteTime(getTimeUtils.getCurrentTime());
        System.out.println(deletedSentence);
        if (deletedSentence.getDelFlag() == 0) {
            if (dissSentenceService.deleteDissSentence(deletedSentence) > 0) {
                return result.successResult(dissSentenceService.getDissSentenceObjById(deletedSentence.getId()));
            } else {
                return result.failResult();
            }
        } else {
            return result.failResult("已经为删除状态");
        }
    }

    @GetMapping("dissSentenceObjById/{id}")
    public Result getDissSentenceObjById(@PathVariable("id") Integer id) {
        Sentence sentenceObj = dissSentenceService.getDissSentenceObjById(id);
        if (sentenceObj != null) {
            return result.successResult(sentenceObj);
        } else {
            return result.failResult();
        }
    }

    @GetMapping("dissSentenceById/{id}")
    public Result getDissSentenceById(@PathVariable("id") Integer id) {
        String sentence = dissSentenceService.getDissSentenceById(id);
        if (sentence != null) {
            return result.successResult(sentence);
        } else {
            return result.failResult();
        }
    }

    @GetMapping("randomDissSentence")
    public Result getRandomDissSentence(){
        String sentence=null;
        sentence=dissSentenceService.getRandomDissSentence();
        if(sentence!=null){
            return result.successResult(sentence);
        }else{
            return result.failResult();
        }
    }

    @GetMapping("randomDissSentenceObj")
    public Result getRandomDissSentenceObj(){
        Sentence sentenceObj = null;
        sentenceObj=dissSentenceService.getRandomDissSentenceObj();
        if(sentenceObj!=null){
            return result.successResult(sentenceObj);
        }else{
            return result.failResult();
        }
    }
}
