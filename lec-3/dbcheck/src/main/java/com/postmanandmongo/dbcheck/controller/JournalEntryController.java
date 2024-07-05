package com.postmanandmongo.dbcheck.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import com.postmanandmongo.dbcheck.entity.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/journal")
public class JournalEntryController {

   
  
    private Map<Long ,JournalEntry> journalEntries=new HashMap<>();
   
    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myentry){
        journalEntries.put(myentry.getId(), myentry);
        return true;
    }

    @GetMapping("/id/{myid}")
    public JournalEntry getJournalEntrybyId(@PathVariable long myid){
        return journalEntries.get(myid);
    }
    @DeleteMapping ("/id/{myid}")
    public boolean deleteJournalEntrybyId(@PathVariable long myid){
        journalEntries.remove(myid);
        return true;
    }


    @PutMapping ("id/{myid}")
    public JournalEntry UpdateJournalEntrybyId(@PathVariable long myid,@RequestBody JournalEntry mEntry){
        return journalEntries.put(myid,mEntry);
    }



    
    @GetMapping("/healthcheck")
    public String Health_check() {
    
        return "ok";
        
    }
}
