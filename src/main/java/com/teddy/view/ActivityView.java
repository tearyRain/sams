package com.teddy.view;

import com.teddy.entity.Activity;
import com.teddy.entity.CheckStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ActivityView {
    private Long id;
    private OrganizationView organization;
    private String name;
    private String description;
    private Integer attendanceNum;
    private Integer volunteers;
    private String volunteerRequired;
    private String sponsorRequired;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private CheckStatus checkStatus;
    private Long totalStudentScore;
    private Long studentScoreNum;
    private LocalDateTime submittedTime;

    private List<StudentAttendanceView> studentsList;

    public static ActivityView fromActivity(Activity activity) {
        if (activity == null) return null;
        ActivityView activityView = new ActivityView();
        BeanUtils.copyProperties(activity, activityView);
        activityView.setOrganization(OrganizationView.fromOrganization(activity.getOrganization()));
        return activityView;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getStartTime() {
        return startTime;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getEndTime() {
        return endTime;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getSubmittedTime() {
        return submittedTime;
    }
}
