package com.example.demo.service.impl;

import com.example.demo.model.Cote;
import com.example.demo.model.CoteDTO;
import com.example.demo.model.Feed;
import com.example.demo.model.Feed$;
import com.example.demo.repository.FeedRepository;
import com.example.demo.service.FeedService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.common.GlobalUtil.pageSize;


@Service
public class FeedServiceImpl implements FeedService {
    @Autowired
    private JPAStreamer jpaStreamer;

    @Autowired
    private FeedRepository feedRepository;

    @Override
    public List<Feed> getAll() {
        List<Feed> feedList;
        feedList = jpaStreamer.stream(Feed.class).collect(Collectors.toList());
        return feedList;
    }

    @Override
    public Optional<Feed> getById(int id) {
        return jpaStreamer.stream(Feed.class).filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public void save(Feed feed) {
        feedRepository.save(feed);
    }

    @Override
    public void delete(int[] ids) {
        Arrays.stream(ids).forEach(e ->
        {
            Feed feed = jpaStreamer.stream(Feed.class).filter(f -> f.getId() == e).findFirst().get();
            feed.setIsDeleted(1);
            feedRepository.save(feed);
        });
    }

    @Override
    public List<Feed> search(int pageNumber, String search) {
        List<Feed> res = new ArrayList<>();
        int amount = Integer.parseInt(search);
        jpaStreamer.stream(Feed.class)
                .filter(Feed$.amount.equal(amount))
                .filter(Feed$.code.contains())
                .skip(pageNumber).limit(pageSize)
                .forEach(e -> {
                 Feed feed = com.example.demo.model.Feed.builder().amount();
                 res.add(feed);
                });

        return res;
    }
}
