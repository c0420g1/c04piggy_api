package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.common.GlobalUtil.pageSize;

import com.example.demo.common.Regex;
import com.example.demo.model.Feed;
import com.example.demo.model.FeedDTO;
import com.example.demo.repository.FeedRepository;
import com.example.demo.service.FeedService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedServiceImpl implements FeedService {

    @Autowired
    private JPAStreamer jpaStreamer;

    @Autowired
    private FeedRepository feedRepository;

    Regex regex = new Regex();

    // thịnh
    // trả về list feed
    @Override
    public List<Feed> getAll() {
        try {
            List<Feed> feedList;
            feedList = jpaStreamer.stream(Feed.class).collect(Collectors.toList());
            return feedList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //thịnh
    // lấy ra Feed theo ID
    @Override
    public Optional<Feed> getById(int id) {
        try {
            return jpaStreamer.stream(Feed.class).filter(e -> e.getId() == id).findFirst();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }


    // thịnh
    // cập nhật feed
    @Override
    public int save(Feed feed) {
        try {
            feedRepository.save(feed);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    //thịnh
    // xóa Feed
    @Override
    public int delete(int[] ids) {
        try{
        Arrays.stream(ids).forEach(e ->
        {
            Feed feed = jpaStreamer.stream(Feed.class).filter(f -> f.getId() == e).findFirst().get();
            feed.setIsDeleted(1);
            feedRepository.save(feed);
        });
        return 1;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }

    //thịnh
    // tìm kiếm feed theo tất cả thuộc tính
    @Override
    public List<Feed> search(int pageNumber, String search) {
        String s = search.toLowerCase();
        List<Feed> res;
        try {
            if (regex.regexNumber(search)) {
                int amount = Integer.parseInt(search);
                res = jpaStreamer.stream(Feed.class).filter(e ->
                        e.getAmount() == amount)
                        .skip((pageNumber - 1) * pageSize).limit(pageSize)
                        .collect(Collectors.toList());
                return res;
            } else
                res = jpaStreamer.stream(Feed.class).filter(e ->
                        e.getFeedType().getName().toLowerCase().contains(s)
                                || e.getHerd().getName().toLowerCase().contains(s)
                                || e.getCode().toLowerCase().contains(s)
                                || e.getUnit().toLowerCase().contains(s)
                                || e.getDescription().toLowerCase().contains(s))
                        .skip((pageNumber - 1) * pageSize).limit(pageSize)
                        .collect(Collectors.toList());
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // thịnh
    // tìm kiếm feed theo unit
    @Override
    public List<Feed> searchUnit(int pageNumber, String search) {
        String s = search.toLowerCase();
        List<Feed> res;
        try {
            res = jpaStreamer.stream(Feed.class).filter(e ->
                    e.getUnit().toLowerCase().contains(s))
                    .skip((pageNumber - 1) * pageSize).limit(pageSize)
                    .collect(Collectors.toList());
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // thịnh
    // tìm kiếm feed theo Amount
    @Override
    public List<Feed> searchAmount(int pageNumber, String search) {
        List<Feed> res;
        try {
            if (!regex.regexNumber(search)) {
                int amount = Integer.parseInt(search);
                res = jpaStreamer.stream(Feed.class).filter(e ->
                        e.getAmount() == amount)
                        .skip((pageNumber - 1) * pageSize).limit(pageSize)
                        .collect(Collectors.toList());
                return res;
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // thịnh
    // Tiền kiếm Feed theo COde
    @Override
    public List<Feed> searchCode(int pageNumber, String search) {
        String s = search.toLowerCase();
        try {
            List<Feed> res;
            res = jpaStreamer.stream(Feed.class).filter(e ->
                    e.getCode().toLowerCase().contains(s))
                    .skip((pageNumber - 1) * pageSize).limit(pageSize)
                    .collect(Collectors.toList());
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // thịnh
    // Tìm kiếm feed theo Heard
    @Override
    public List<Feed> searchHeard(int pageNumber, String search) {
        String s = search.toLowerCase();
        try {
            List<Feed> res;
            res = jpaStreamer.stream(Feed.class).filter(e ->
                    e.getHerd().getName().toLowerCase().contains(s))
                    .skip((pageNumber - 1) * pageSize).limit(pageSize)
                    .collect(Collectors.toList());
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // tìm kiếm feed theo Feedtype
    @Override
    public List<Feed> searchFeedType(int pageNumber, String search) {
        String s = search.toLowerCase();
        try {
            List<Feed> res;
            res = jpaStreamer.stream(Feed.class).filter(e ->
                    e.getFeedType().getName().toLowerCase().contains(s))
                    .skip((pageNumber - 1) * pageSize).limit(pageSize)
                    .collect(Collectors.toList());
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //thịnh
    // tìm kiếm Feed theo mô tả
    @Override
    public List<Feed> searchDescription(int pageNumber, String search) {
        List<Feed> res;
        String s = search.toLowerCase();
        try {
            res = jpaStreamer.stream(Feed.class).filter(e ->
                    e.getDescription().toLowerCase().contains(s))
                    .skip((pageNumber - 1) * pageSize).limit(pageSize)
                    .collect(Collectors.toList());
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Feed> getFeedPage(int pageNumber) {
        try {
            List<Feed> res;
            res = jpaStreamer.stream(Feed.class)
                    .skip((pageNumber - 1) * pageSize).limit(pageSize)
                    .collect(Collectors.toList());
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<FeedDTO> getAllFeed(int pageNumber) {
        try {
            List<FeedDTO> feedDTOList = new ArrayList<>();
            jpaStreamer.stream(Feed.class).skip((pageNumber - 1) * pageSize).limit(pageSize).forEach(e -> {
                FeedDTO feedDTO = new FeedDTO(e.getId(), e.getIsDeleted(), e.getDescription(), e.getCode(), e.getAmount(), e.getUnit(), e.getFeedType().getName(),e.getFeedType().getId(), e.getHerd().getName(),e.getHerd().getId());
                feedDTOList.add(feedDTO);
            });
            return feedDTOList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<FeedDTO> getAllFeed() {
        try {
            List<FeedDTO> feedDTOList = new ArrayList<>();
            jpaStreamer.stream(Feed.class).forEach(e -> {
                FeedDTO feedDTO = new FeedDTO(e.getId(), e.getIsDeleted(), e.getDescription(), e.getCode(), e.getAmount(), e.getUnit(), e.getFeedType().getName(),e.getFeedType().getId(), e.getHerd().getName(),e.getHerd().getId());
                feedDTOList.add(feedDTO);
            });
            return feedDTOList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Feed findById(int id) {
        try {
            return feedRepository.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
