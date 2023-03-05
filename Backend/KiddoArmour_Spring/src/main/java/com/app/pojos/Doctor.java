package com.app.pojos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "doctor")
public class Doctor extends BaseEntity{
    
    
	@Column(name = "phoneNumber", length = 13, nullable = false)
    private String phoneNumber;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "speciality", nullable = false)
    private String speciality;

//    @Column(name = "available_days", nullable = false)
//    @NotBlank(message = "Available days are mandatory")
//    private String availableDays;
//
//    @Column(name = "start_time", nullable = false)
//    @NotBlank(message = "Start time is mandatory")
//    private String startTime;
//
//    @Column(name = "end_time", nullable = false)
//    @NotBlank(message = "End time is mandatory")
//    private String endTime;
    
    @Column(nullable = false)
    private Boolean verified;

    @Column(name = "active", nullable = false)
    private boolean active;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private Admin admin;
// 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_id")
    private Child child;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private User createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", insertable = false, updatable = false)
    private Doctor doctor;

    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "clinic_id", referencedColumnName = "id")
//    private Clinic clinic;
    //Since One Doctor Can have Multiple Clinics
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private List<Clinic> clinics = new ArrayList<>();
    
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();
    
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private Set<Notification> notifications;
    
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Log> logs = new ArrayList<>();
//  private Set<Log> logs;
    
//    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Vaccination> vaccinations = new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "doctor_vaccination", 
        joinColumns = @JoinColumn(name = "doctor_id"), 
        inverseJoinColumns = @JoinColumn(name = "vaccination_id"))
    private List<Vaccination> vaccinations = new ArrayList<>();
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    
    
	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public List<Clinic> getClinics() {
		return clinics;
	}

	public void setClinics(List<Clinic> clinics) {
		this.clinics = clinics;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<Vaccination> getVaccinations() {
		return vaccinations;
	}

	public void setVaccinations(List<Vaccination> vaccinations) {
		this.vaccinations = vaccinations;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

//	public Child getChild() {
//		return child;
//	}
//
//	public void setChild(Child child) {
//		this.child = child;
//	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

//	public Clinic getClinic() {
//		return clinic;
//	}
//
//	public void setClinic(Clinic clinic) {
//		this.clinic = clinic;
//	}

	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
    
}

