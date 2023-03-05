package com.app.pojos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;



/**
 * @author MohammedFaraz
 *
 */
@Entity
@Table(name = "parent")
public class Parent extends BaseEntity{
    
        
	@Column(name = "phoneNumber", length = 13, nullable = false)
    private String phoneNumber;
    
	@Column(name = "address", length = 50, nullable = false)
    private String address;
    
	@Column(nullable = false)
    private boolean active;
    
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

//    @OneToOne(mappedBy = "parent")
//    private Child child;
    
    
	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Child> children = new ArrayList<>();

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Reminder> reminders = new ArrayList<>();

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<Appointment> appointments = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private User createdBy;
    
    @OneToMany//(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Notification> notifications = new ArrayList<>();
    
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Log> logs = new ArrayList<>();
//  private Set<Log> logs;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "parent_doctor", 
        joinColumns = @JoinColumn(name = "parent_id"), 
        inverseJoinColumns = @JoinColumn(name = "doctor_id"))
    private List<Doctor> doctors = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "parent_clinic", 
        joinColumns = @JoinColumn(name = "parent_id"), 
        inverseJoinColumns = @JoinColumn(name = "clinic_id"))
    private List<Clinic> clinics = new ArrayList<>();
    
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })
        @JoinTable(name = "parent_vaccination",
            joinColumns = @JoinColumn(name = "parent_id"),
            inverseJoinColumns = @JoinColumn(name = "vaccination_id")
        )
        private List<Vaccination> vaccinations = new ArrayList<>();

    
    
	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public List<Reminder> getReminders() {
		return reminders;
	}

	public void setReminders(List<Reminder> reminders) {
		this.reminders = reminders;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Clinic> getClinics() {
		return clinics;
	}

	public void setClinics(List<Clinic> clinics) {
		this.clinics = clinics;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

//	public Set<Notification> getNotifications() {
//		return notifications;
//	}
//
//	public void setNotifications(Set<Notification> notifications) {
//		this.notifications = notifications;
//	}

	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public List<Vaccination> getVaccinations() {
		return vaccinations;
	}

	public void setVaccinations(List<Vaccination> vaccinations) {
		this.vaccinations = vaccinations;
	}
    
    
    
}

