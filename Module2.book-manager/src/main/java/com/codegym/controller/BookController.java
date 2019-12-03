package com.codegym.controller;


import com.codegym.model.Book;
import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public ModelAndView listBooks(){
        Iterable<Book> books = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("/book/list");
        modelAndView.addObject("books",books);
        return modelAndView;
    }

    @GetMapping("/create-book")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }
    @PostMapping("/create-book")
    public ModelAndView saveBook(@ModelAttribute("book") Book book){
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("book",new Book());
        modelAndView.addObject("message","New book create successfully!");
        return modelAndView;
    }


}
