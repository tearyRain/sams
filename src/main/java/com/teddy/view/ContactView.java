package com.teddy.view;

import com.teddy.entity.ContactInfo;
import com.teddy.entity.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class ContactView {
    private String name;
    private String phone;
    private Gender gender;

    static public ContactView fromContact(ContactInfo contactInfo) {
        ContactView contactView = new ContactView();
        BeanUtils.copyProperties(contactInfo, contactView);
        return contactView;
    }
}
