package com.greetlabs.School_Application.service;

import com.greetlabs.School_Application.constants.SchoolConstants;
import com.greetlabs.School_Application.model.Contact;
import com.greetlabs.School_Application.reository.ContactRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;


    public ContactService(){
        System.out.println("Contact Service Bean initialized");
    }


    public boolean saveMessageDetails(Contact contact){
        boolean isSaved=false;
        contact.setStatus(SchoolConstants.OPEN);
        Contact savedContact =contactRepository.save(contact);
        if(null !=savedContact && savedContact.getContactId()>0){
            isSaved=true;
        }
         return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findByStatus(SchoolConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId){
        boolean isUpdated=false;
        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 ->{
            contact1.setStatus(SchoolConstants.CLOSE);
        });
        Contact updatedContact=contactRepository.save(contact.get());
        if(null !=updatedContact && updatedContact.getContactId()>0){
            isUpdated=true;
        }
        return isUpdated;
    }
}
