package org.fyh.es.demo.controller;


import org.fyh.es.demo.bean.BookBean;
import org.fyh.es.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
public class ElasticController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/book/{id}")
    @ResponseBody
    public BookBean getBookById(@PathVariable String id){
        Optional<BookBean> opt =bookService.findById(id);
        BookBean book=opt.get();
        System.out.println(book);
        return book;
    }

    @RequestMapping("/save")
    @ResponseBody
    public void Save(String id, String title, String author, String postDate){
        BookBean book=new BookBean(id,title,author,postDate);
        System.out.println(book);
        BookBean save = bookService.save(book);
        System.out.println(save);
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable String id){
        bookService.deleteById(id);
        return "ok";
    }
    
    /**
     * @description
     * @param id
     * @param title
     * @param author
     * @param postDate
     * @return java.lang.String
     * @author fangyunhe
     * @time 2019/12/12 14:10
     **/
    @RequestMapping("update")
    @ResponseBody
    public String delete(String id, String title, String author, String postDate){
        Optional<BookBean> bookBean = bookService.findById(id);
        if(bookBean == null){
            return "没有这个id对应的对象";
        }
        BookBean book=bookBean.get();
        if(title != null){
            book.setTitle(title);
        }
        if(author != null){
            book.setAuthor(author);
        }
        if(postDate != null){
            book.setPostDate(postDate);
        }
        bookService.update(book);
        return "ok";
    }

}

