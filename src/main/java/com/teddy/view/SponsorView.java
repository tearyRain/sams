package com.teddy.view;

import com.teddy.entity.Sponsor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class SponsorView {
    private Long id;
    private String name;
    private ContactView contact;
    private String email;
    private String address;
    private String description;
    private Boolean banned;

    public static SponsorView fromSponsor(Sponsor sponsor) {
        if (sponsor == null) return null;
        SponsorView sponsorView = new SponsorView();
        BeanUtils.copyProperties(sponsor, sponsorView);
        sponsorView.contact = ContactView.fromContact(sponsor.getContact());
        return sponsorView;
    }
}
