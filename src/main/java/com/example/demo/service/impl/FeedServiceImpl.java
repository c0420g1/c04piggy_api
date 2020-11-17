package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.common.GlobalUtil.pageSize;

import com.example.demo.common.Regex;
import com.example.demo.model.Feed;
import com.example.demo.model.Feed$;
import com.example.demo.model.FeedDTO;
import com.example.demo.model.StockDTO;
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
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
        try {
            List<Feed> feedList;
            feedList = jpaStreamer.stream(Feed.class).collect(Collectors.toList());
            return feedList;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
           jpaStreamer.close();
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
    public List<FeedDTO> search(int pageNumber, int pageSize,  String s) {
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
        List<FeedDTO> res = new ArrayList<>();
        try {
            if(pageNumber==-1){
                jpaStreamer.stream(Feed.class).filter(f -> f.getIsDeleted() == 0)
                        .forEach(e -> {
                            FeedDTO feedDTO = new FeedDTO(e.getId(), e.getIsDeleted(), e.getDescription(), e.getCode(), e.getAmount(), e.getUnit(),  e.getFeedType().getName(),e.getFeedType().getId(), e.getHerd().getName(),e.getHerd().getId());
                            res.add(feedDTO);
                        });
                return res;
            }
            if (regex.regexNumber(s)) {
                int amount = Integer.parseInt(s);
                jpaStreamer.stream(Feed.class).filter(e ->
                        e.getAmount() == amount)
                        .skip((pageNumber - 1) * pageSize).limit(pageSize)
                        .forEach(e -> {
                            FeedDTO feedDTO = new FeedDTO(e.getId(), e.getIsDeleted(), e.getDescription(), e.getCode(), e.getAmount(), e.getUnit(),  e.getFeedType().getName(),e.getFeedType().getId(), e.getHerd().getName(),e.getHerd().getId());
                            res.add(feedDTO);
                        });
                return res;
            } else
                jpaStreamer.stream(Feed.class).filter(e ->
                        e.getIsDeleted() == 0 &&
                                ( e.getFeedType().getName().toLowerCase().contains(s)
                                || e.getHerd().getName().toLowerCase().contains(s)
                                || e.getCode().toLowerCase().contains(s)
                                || e.getUnit().toLowerCase().contains(s)
                                || e.getDescription().toLowerCase().contains(s)))
                        .sorted(Feed$.id.reversed()).collect(Collectors.toList()).stream().skip((pageNumber - 1) * pageSize).limit(pageSize)
                        .forEach(e -> {
                            FeedDTO feedDTO = new FeedDTO(e.getId(), e.getIsDeleted(), e.getDescription(), e.getCode(), e.getAmount(), e.getUnit(),  e.getFeedType().getName(),e.getFeedType().getId(), e.getHerd().getName(),e.getHerd().getId());
                            res.add(feedDTO);
                        });
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // thịnh
    // tìm kiếm feed theo unit
    @Override
    public List<FeedDTO> searchUnit(int pageNumber, String search) {
        String s = search.toLowerCase();
        List<FeedDTO> res = new ArrayList<>();
        try {
            jpaStreamer.stream(Feed.class).filter(e ->
                    e.getUnit().toLowerCase().contains(s))
                    .skip((pageNumber - 1) * pageSize).limit(pageSize)
                    .forEach(e -> {
                        FeedDTO feedDTO = new FeedDTO(e.getId(), e.getIsDeleted(), e.getDescription(), e.getCode(), e.getAmount(), e.getUnit(), e.getFeedType().getName(),e.getFeedType().getId(), e.getHerd().getName(),e.getHerd().getId());
                        res.add(feedDTO);
                    });
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // thịnh
    // tìm kiếm feed theo Amount
    @Override
    public List<FeedDTO> searchAmount(int pageNumber, String search) {
        List<FeedDTO> res = new ArrayList<>();
        try {
            if (!regex.regexNumber(search)) {
                int amount = Integer.parseInt(search);
                jpaStreamer.stream(Feed.class).filter(e ->
                        e.getAmount() == amount)
                        .skip((pageNumber - 1) * pageSize).limit(pageSize)
                        .forEach(e -> {
                            FeedDTO feedDTO = new FeedDTO(e.getId(), e.getIsDeleted(), e.getDescription(), e.getCode(), e.getAmount(), e.getUnit(), e.getFeedType().getName(),e.getFeedType().getId(), e.getHerd().getName(),e.getHerd().getId());
                            res.add(feedDTO);
                        });
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
    public List<FeedDTO> searchCode(int pageNumber, String search) {
        String s = search.toLowerCase();
        try {
            List<FeedDTO> res = new ArrayList<>();
            jpaStreamer.stream(Feed.class).filter(e ->
                    e.getCode().toLowerCase().contains(s))
                    .skip((pageNumber - 1) * pageSize).limit(pageSize)
                    .forEach(e -> {
                        FeedDTO feedDTO = new FeedDTO(e.getId(), e.getIsDeleted(), e.getDescription(), e.getCode(), e.getAmount(), e.getUnit(), e.getFeedType().getName(),e.getFeedType().getId(), e.getHerd().getName(),e.getHerd().getId());
                        res.add(feedDTO);
                    });
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // thịnh
    // Tìm kiếm feed theo Heard
    @Override
    public List<FeedDTO> searchHeard(int pageNumber, String search) {
        String s = search.toLowerCase();
        try {
            List<FeedDTO> res = new ArrayList<>();
            jpaStreamer.stream(Feed.class).filter(e ->
                    e.getHerd().getName().toLowerCase().contains(s))
                    .skip((pageNumber - 1) * pageSize).limit(pageSize)
                    .forEach(e -> {
                        FeedDTO feedDTO = new FeedDTO(e.getId(), e.getIsDeleted(), e.getDescription(), e.getCode(), e.getAmount(), e.getUnit(), e.getFeedType().getName(),e.getFeedType().getId(), e.getHerd().getName(),e.getHerd().getId());
                        res.add(feedDTO);
                    });
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // tìm kiếm feed theo Feedtype
    @Override
    public List<FeedDTO> searchFeedType(int pageNumber, String search) {
        String s = search.toLowerCase();
        try {
            List<FeedDTO> res = new ArrayList<>();
            jpaStreamer.stream(Feed.class).filter(e ->
                    e.getFeedType().getName().toLowerCase().contains(s))
                    .skip((pageNumber - 1) * pageSize).limit(pageSize)
                    .forEach(e -> {
                        FeedDTO feedDTO = new FeedDTO(e.getId(), e.getIsDeleted(), e.getDescription(), e.getCode(), e.getAmount(), e.getUnit(), e.getFeedType().getName(),e.getFeedType().getId(), e.getHerd().getName(),e.getHerd().getId());
                        res.add(feedDTO);
                    });
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //thịnh
    // tìm kiếm Feed theo mô tả
    @Override
    public List<FeedDTO> searchDescription(int pageNumber, String search) {
        List<FeedDTO> res = new ArrayList<>();
        String s = search.toLowerCase();
        try {
                    jpaStreamer.stream(Feed.class).filter(e ->
                    e.getDescription().toLowerCase().contains(s))
                    .skip((pageNumber - 1) * pageSize).limit(pageSize)
                    .forEach(e -> {
                        FeedDTO feedDTO = new FeedDTO(e.getId(), e.getIsDeleted(), e.getDescription(), e.getCode(), e.getAmount(), e.getUnit(), e.getFeedType().getName(),e.getFeedType().getId(), e.getHerd().getName(),e.getHerd().getId());
                        res.add(feedDTO);
                    });
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<FeedDTO> getFeedPage(int pageNumber) {
        try {
                     List<FeedDTO> res = new ArrayList<>();
                    jpaStreamer.stream(Feed.class)
                    .skip((pageNumber - 1) * pageSize).limit(pageSize)
                    .forEach(e -> {
                        FeedDTO feedDTO = new FeedDTO(e.getId(), e.getIsDeleted(), e.getDescription(), e.getCode(), e.getAmount(), e.getUnit(), e.getFeedType().getName(),e.getFeedType().getId(), e.getHerd().getName(),e.getHerd().getId());
                        res.add(feedDTO);
                    });
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<FeedDTO> getAllFeed(int pageNumber) {
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
        try {
            List<FeedDTO> feedDTOList = new ArrayList<>();
            jpaStreamer.stream(Feed.class).skip((pageNumber - 1) * pageSize).limit(pageSize).forEach(e -> {
                FeedDTO feedDTO = new FeedDTO(e.getId(), e.getIsDeleted(), e.getDescription(), e.getCode(), e.getAmount(), e.getUnit(), e.getFeedType().getName(),e.getFeedType().getId(), e.getHerd().getName(),e.getHerd().getId());
                feedDTOList.add(feedDTO);
            });
            return feedDTOList;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            jpaStreamer.close();
        }
        return null;
    }

    @Override
    public List<FeedDTO> getAllFeed() {
        JPAStreamer jpaStreamer= JPAStreamer.of("c04piggy");
        try {
            List<FeedDTO> feedDTOList = new ArrayList<>();
            jpaStreamer.stream(Feed.class).forEach(e -> {
                FeedDTO feedDTO = new FeedDTO(e.getId(), e.getIsDeleted(), e.getDescription(), e.getCode(), e.getAmount(), e.getUnit(), e.getFeedType().getName(),e.getFeedType().getId(), e.getHerd().getName(),e.getHerd().getId());
                feedDTOList.add(feedDTO);
            });
            return feedDTOList;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            jpaStreamer.close();
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
