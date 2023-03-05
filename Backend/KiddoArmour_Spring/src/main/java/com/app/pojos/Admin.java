package com.app.pojos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin extends BaseEntity{

            
    @Column(name = "admin_phone")
    private String phone;
    
    @Column(name = "is_superadmin")
    private Boolean isSuperadmin;

    // One-to-One with User
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user; 
    
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> createAdmins = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private Admin createdBy;
    
    // One-to-Many with Clinic
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Clinic> clinics = new ArrayList<>();

    
//	One-to-Many with Doctor
 	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Doctor> doctors = new ArrayList<>();

    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //Getting notifications for doctors approval.
    private List<Notification> notifications = new ArrayList<>();

    
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL) // Connection with Log class to store logs generated as arraylist.
    private List<Log> logs = new ArrayList<>();
    
//    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL) //Getting notifications for doctors approval.
//    private Set<Notification> notifications;    
    //Using Set here ensures that only new notifications are stored in database and not same ones.
    // See text file Set from this project for more ***

    
    
    
    
	public String getPhone() {
		return phone;
	}

	

	public List<User> getCreateAdmins() {
		return createAdmins;
	}



	public void setCreateAdmins(List<User> createAdmins) {
		this.createAdmins = createAdmins;
	}



	public Admin getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(Admin createdBy) {
		this.createdBy = createdBy;
	}



	public List<Clinic> getClinics() {
		return clinics;
	}

	public void setClinics(List<Clinic> clinics) {
		this.clinics = clinics;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getIsSuperadmin() {
		return isSuperadmin;
	}

	public void setIsSuperadmin(Boolean isSuperadmin) {
		this.isSuperadmin = isSuperadmin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

//	public Set<Notification> getNotifications() {
//		return notifications;
//	}
//
//	public void setNotifications(Set<Notification> notifications) {
//		this.notifications = notifications;
//	}
    


}