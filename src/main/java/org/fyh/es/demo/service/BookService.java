package org.fyh.es.demo.service;
import org.fyh.es.demo.bean.BookBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<BookBean> findById(String id);

    BookBean save(BookBean blog);

    void delete(BookBean blog);

    Optional<BookBean> findOne(String id);

    List<BookBean> findAll();

    Page<BookBean> findByAuthor(String author, PageRequest pageRequest);

    Page<BookBean> findByTitle(String title, PageRequest pageRequest);

    void deleteById(String id);

    void update(BookBean blog);
}

