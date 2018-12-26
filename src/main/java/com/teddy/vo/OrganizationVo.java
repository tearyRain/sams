package com.teddy.vo;

import com.teddy.entity.Organization;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class OrganizationVo {
    private Long id;
    private String name;
    private ContactVo contact;
    private String email;
    private String description;
    private Boolean banned;

    public static OrganizationVo fromOrganization(Organization organization) {
        if (organization == null) return null;
        OrganizationVo organizationView = new OrganizationVo();
        BeanUtils.copyProperties(organization, organizationView);
        organizationView.setContact(ContactVo.fromContact(organization.getContact()));
        return organizationView;
    }
}
