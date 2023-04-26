package cn.study.test.controller;

import org.apache.commons.collections4.ListUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ListSplitController
 * @Description TODO
 * @Author v-xupengyuan
 * @Date 2023/4/26 15:07
 * @Version 1.0
 */
@RestController
@RequestMapping("/list")
public class ListSplitController {


    /**
     *  list 分批 ->按照size大小分割list集合
     */
    @GetMapping("/split")
    public void splitList(){
        List list = new ArrayList<String>();
        for(int i =0;i<500;i++){
            list.add(i);
        }

        List<List<String>> partition = ListUtils.partition(list, 120);
        for (List<String> strings : partition) {
            System.out.println(strings.size());
        }

    }
}
