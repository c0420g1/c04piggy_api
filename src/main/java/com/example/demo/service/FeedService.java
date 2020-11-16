package com.example.demo.service;

import com.example.demo.model.Feed;
import com.example.demo.model.FeedDTO;

import java.util.List;

public interface FeedService extends BaseService<Feed>  {
    List<FeedDTO> search(int pageNumber, int pageSize,  String search);
    List<FeedDTO> searchUnit(int pageNumber, String search);
    List<FeedDTO> searchAmount(int pageNumber, String search);
    List<FeedDTO> searchCode(int pageNumber, String search);
    List<FeedDTO> searchHeard(int pageNumber, String search);
    List<FeedDTO> searchFeedType(int pageNumber, String search);
    List<FeedDTO> searchDescription(int pageNumber, String search);
    List<FeedDTO> getFeedPage(int pageNumber);
    List<FeedDTO> getAllFeed(int pageNumber);
    List<FeedDTO> getAllFeed();
    Feed findById(int id);
}
