package com.gh.springboot.readlist.controller;


import com.gh.springboot.readlist.entity.Book;
import com.gh.springboot.readlist.model.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingListController {
    private ReadingListRepository readingListRepository;
    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }
    @RequestMapping(value="/{reader}", method= RequestMethod.GET)
    public String readersBooks( @PathVariable("reader") String reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        //返回readingList作为呈现模型的视图逻辑名称,所以，必须创建该视图(readingList.html).
        return "readingList";
    }
    @RequestMapping(value="/{reader}", method=RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }
}
