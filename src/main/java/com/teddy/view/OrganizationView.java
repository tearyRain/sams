package com.teddy.view;

import com.teddy.entity.Organization;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class OrganizationView {
    private Long id;
    private String name;
    private ContactView contact;
    private String email;
    private String description;
    private Boolean banned;

    public static OrganizationView fromOrganization(Organization organization) {
        if (organization == null) return null;
        OrganizationView organizationView = new OrganizationView();
        BeanUtils.copyProperties(organization, organizationView);
        organizationView.setContact(ContactView.fromContact(organization.getContact()));
        return organizationView;
    }
}
