package com.example2.demo2.bean;

import javax.persistence.*;

public class Jobs {
    @Id
    @Column(name = "job_id")
    private String jobId;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "min_salary")
    private Integer minSalary;

    @Column(name = "max_salary")
    private Integer maxSalary;

    public Jobs(String jobId, String jobTitle, Integer minSalary, Integer maxSalary) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public Jobs() {
        super();
    }

    /**
     * @return job_id
     */
    public String getJobId() {
        return jobId;
    }

    /**
     * @param jobId
     */
    public void setJobId(String jobId) {
        this.jobId = jobId == null ? null : jobId.trim();
    }

    /**
     * @return job_title
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * @param jobTitle
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle == null ? null : jobTitle.trim();
    }

    /**
     * @return min_salary
     */
    public Integer getMinSalary() {
        return minSalary;
    }

    /**
     * @param minSalary
     */
    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

    /**
     * @return max_salary
     */
    public Integer getMaxSalary() {
        return maxSalary;
    }

    /**
     * @param maxSalary
     */
    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", jobId=").append(jobId);
        sb.append(", jobTitle=").append(jobTitle);
        sb.append(", minSalary=").append(minSalary);
        sb.append(", maxSalary=").append(maxSalary);
        sb.append("]");
        return sb.toString();
    }
}