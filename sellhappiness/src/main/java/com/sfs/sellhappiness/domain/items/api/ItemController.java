package com.sfs.sellhappiness.domain.items.api;

import com.sfs.sellhappiness.domain.items.application.ItemServiceImpl;
import com.sfs.sellhappiness.domain.items.dto.ItemFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemServiceImpl itemService;

//    @GetMapping("/category")
//    public ResponseEntity<?> getCategoryList(){
//        return ResponseEntity.ok(itemService.getCategoryList());
//    }

    @PostMapping("/register")
    public ResponseEntity<?> getCategoryList(@RequestBody ItemFormDto itemFormDto){

        itemService.registItem(itemFormDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
