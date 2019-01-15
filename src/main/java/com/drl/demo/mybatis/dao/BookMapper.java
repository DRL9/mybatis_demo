package com.drl.demo.mybatis.dao;

import com.drl.demo.mybatis.dto.TBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BookMapper {

    @Select(" select * from t_book; ")
    List<TBook> findBookList();
}
