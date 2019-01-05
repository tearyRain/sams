package com.teddy.vo;

import com.teddy.entity.ContactInfo;
import com.teddy.entity.Gender;
import lombok.NoArgsConstructor;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
public class ContactVo {
    @JSON
    public String getName() {
        return name;
    }

    @JSON
    public void setName(String name) {
        this.name = name;
    }

    @JSON
    public String getPhone() {
        return phone;
    }

    @JSON
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JSON
    public Gender getGender() {
        return gender;
    }

    @JSON
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    private String name;
    private String phone;
    private Gender gender;

    static public ContactVo fromContact(ContactInfo contactInfo) {
        ContactVo contactView = new ContactVo();
        BeanUtils.copyProperties(contactInfo, contactView);
        return contactView;
    }

    public ContactInfo toContact(ContactVo contactVo) {
        ContactInfo contactInfo = new ContactInfo();
        BeanUtils.copyProperties(contactVo, contactInfo);
        return contactInfo;
    }

}
