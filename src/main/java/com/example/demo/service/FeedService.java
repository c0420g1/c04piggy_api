package com.example.demo.service;

import com.example.demo.model.Feed;

import java.util.List;

public interface FeedService extends BaseService<Feed>  {
    List<Feed> search(int pageNumber, String search);
}
