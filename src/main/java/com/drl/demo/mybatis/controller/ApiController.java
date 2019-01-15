package com.drl.demo.mybatis.controller;

import com.drl.demo.mybatis.dao.UserMapper;
import com.drl.demo.mybatis.dao.BookMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final BookMapper bookMapper;

    private final UserMapper userMapper;

    public ApiController(BookMapper bookMapper, UserMapper userMapper) {
        this.bookMapper = bookMapper;
        this.userMapper = userMapper;
    }


    @RequestMapping(value = "/book")
    public Object getBook() {
        return bookMapper.findBookList();
    }

    @RequestMapping(value = "/user")
    public Object getUser() {
        return userMapper.findUserList();
    }
}
