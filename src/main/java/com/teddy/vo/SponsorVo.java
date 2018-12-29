package com.teddy.vo;

import com.teddy.entity.Sponsor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@NoArgsConstructor
public class SponsorVo {
    private Long id;
    private String name;
    private ContactVo contact;
    private String email;
    private String address;
    private String description;
    private Boolean banned;
    private List<SupportedActivityVo> activityList;

    public static SponsorVo fromSponsor(Sponsor sponsor) {
        if (sponsor == null) return null;
        SponsorVo sponsorView = new SponsorVo();
        BeanUtils.copyProperties(sponsor, sponsorView);
        sponsorView.contact = ContactVo.fromContact(sponsor.getContact());
        return sponsorView;
    }

    public Sponsor toSponsor(){
        Sponsor sponsor = new Sponsor();
        BeanUtils.copyProperties(this, sponsor);
        return sponsor;
    }
}
