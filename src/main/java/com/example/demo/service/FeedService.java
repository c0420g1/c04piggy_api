package com.example.demo.service;

import com.example.demo.model.Feed;

import java.util.List;

public interface FeedService extends BaseService<Feed>  {
    List<Feed> search(int pageNumber, String search);
    List<Feed> searchUnit(int pageNumber, String search);
    List<Feed> searchAmount(int pageNumber, String search);
    List<Feed> searchCode(int pageNumber, String search);
    List<Feed> searchHeard(int pageNumber, String search);
    List<Feed> searchFeedType(int pageNumber, String search);
    List<Feed> searchDescription(int pageNumber, String search);
    List<Feed> getFeedPage(int pageNumber);
}
