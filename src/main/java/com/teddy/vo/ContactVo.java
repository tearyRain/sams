package com.teddy.vo;

import com.teddy.entity.ContactInfo;
import com.teddy.entity.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class ContactVo {
    private String name;
    private String phone;
    private Gender gender;

    static public ContactVo fromContact(ContactInfo contactInfo) {
        ContactVo contactView = new ContactVo();
        BeanUtils.copyProperties(contactInfo, contactView);
        return contactView;
    }

    public ContactInfo toContact(ContactVo contactVo){
        ContactInfo contactInfo = new ContactInfo();
        BeanUtils.copyProperties(contactInfo, contactVo);
        return contactInfo;
    }
}
