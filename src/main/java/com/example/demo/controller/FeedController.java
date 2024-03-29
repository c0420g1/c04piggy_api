package com.example.demo.controller;
import com.example.demo.common.Regex;
import com.example.demo.model.*;
import com.example.demo.service.HerdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.FeedService;
import com.example.demo.service.FeedTypeService;
import com.example.demo.common.Error;

import java.util.ArrayList;
import java.util.List;



@RestController
@CrossOrigin(origins = {"*"})
public class FeedController {

    @Autowired
    private FeedService feedService;

    @Autowired
    private FeedTypeService feedTypeService;


    @Autowired
    private HerdService herdService;

    Regex regex = new Regex();

    //thinh
    //getAll feed ok
    @GetMapping("/feedDTOs")
    public List<FeedDTO> listFeed(){
        try{
            return this.feedService.getAllFeed();
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    //thinh
    // getFeed theo page ok
    @GetMapping("/feeds/{pageNum}")
    public List<FeedDTO> listFeedPage(@PathVariable int pageNum, @RequestParam int pageSize, @RequestParam(defaultValue = "") String search){
        try{
            return this.feedService.search(pageNum,pageSize, search);
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    //thinh
    //getFeed Type ok
    @GetMapping("/feedsType")
    public List<FeedType> listFeedType(){
        try{
            return this.feedTypeService.getAll();
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @GetMapping("/feeds")
    public List<Feed> Feed(){
        try{
            return this.feedService.getAll();
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    //thinh
    //deleteFeed ok
    @PatchMapping("deleteFeed")
    public List<Error> deleteFeed(@RequestBody int[] ids){
        List<Error> errors = new ArrayList<>();
        try{
            this.feedService.delete(ids);
            errors.add(new Error("success", "Delete success"));
            return errors;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    //thinh
    // update Feed ok
    @PatchMapping("updateFeed")
    public List<Error> updateFeed(@RequestBody Feed feed){
        List<Error> errors = new ArrayList<>();
        try{
            this.feedService.save(feed);
            errors.add(new Error("success", "Update success"));
            return errors;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    //thinh
    //create feed ok
    @PostMapping("createFeed")
    public List<Error> createFeed(@RequestBody Feed feed){
        List<Error> errors = new ArrayList<>();
        String amount = Integer.toString(feed.getAmount());
        List<FeedType> feedTypeList = feedTypeService.getAll();
        List<Herd> herdList = herdService.getAll();
        try{
            if (!regex.regexCode(feed.getCode())) {
                errors.add(new Error("code", "code invalid format FEXXXX with X is number."));
            }
//            if (feed.getDescription().length() < 0) {
//                errors.add(new Error("description", "description is not null"));
//            }
            if (!regex.regexUnit(feed.getUnit())) {
                errors.add(new Error("unit", "unit invalid format."));
            }
//            if (!regex.regexNumber(amount)){
//                errors.add(new Error("amount", "amount invalid format is number"));
//            }
            for (FeedType feedType : feedTypeList) {
                for (Herd herd : herdList) {
                    if (errors.isEmpty() && herd.getName().equals(feed.getHerd().getName()) && feedType.getName().equals(feed.getFeedType().getName())) {
                        this.feedService.save(feed);
                        errors.add(new Error("success", "Create success."));
                        return errors;
                    }
                }
            }
            errors.add(new Error("notNull", "FeedType or herd is required. "));
            return errors;
        }catch (Exception e){
            System.out.println(e);
            errors.add(new Error("nullPoint", "System error !"));
            return errors;
        }
    }


    //thinh
    //search ok
    @GetMapping("searchFeed/{properties}/{key}/{page}")
    public List<FeedDTO> searchFeed(@PathVariable String properties,@PathVariable String key,@PathVariable int page){
        try{
            List<FeedDTO> feedList;
            switch (properties){
                case "description":
                    feedList = this.feedService.searchDescription(page,key);
                    return feedList;
                case "code":
                    feedList = this.feedService.searchCode(page,key);
                    return feedList;
                case "amount":
                    feedList = this.feedService.searchAmount(page,key);
                    return feedList;
                case "unit":
                    feedList = this.feedService.searchUnit(page,key);
                    return feedList;
                case "herd":
                    feedList = this.feedService.searchHeard(page,key);
                    return feedList;
                case "feedType":
                    feedList = this.feedService.searchFeedType(page,key);
                    return feedList;
                case "all":
//                    feedList = this.feedService.search(page,key);
//                    return feedList;
                default:
                    break;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }



}
