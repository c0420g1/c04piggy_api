package com.example.demo.controller;
import com.example.demo.model.Feed;
import com.example.demo.model.FeedDTO;
import com.example.demo.model.FeedType;
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

    //thinh
    //getAll feed ok
    @GetMapping("/feeds")
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
    public List<Feed> listFeedPage(@PathVariable int pageNum){
        try{
            return this.feedService.getFeedPage(pageNum);
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

    //thinh
    //deleteFeed ok
    @DeleteMapping("deleteFeed")
    public List<Error> deleteFeed(@RequestBody int[] idf){
        List<Error> errors = new ArrayList<>();
        try{
            this.feedService.delete(idf);
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
    public List<Error> createFeed(@RequestBody FeedDTO feed){
        List<Error> errors = new ArrayList<>();
        try{
            this.feedService.save(feed);
            errors.add(new Error("success", "Create success"));
            return errors;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }


    //thinh
    //search ok
    @GetMapping("searchFeed/{properties}/{key}/{page}")
    public List<Feed> searchFeed(@PathVariable String properties,@PathVariable String key,@PathVariable int page){
        try{
            List<Feed> feedList;
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
                    feedList = this.feedService.search(page,key);
                    return feedList;
                default:
                    break;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }


}
