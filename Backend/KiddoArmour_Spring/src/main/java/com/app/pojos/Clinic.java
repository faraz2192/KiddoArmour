package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "clinic")

public class Clinic extends BaseEntity{

	
    
    @Column(name = "clinic_name")
    private String clinicName;

    
    @Column(name = "clinic_address",length = 30,nullable = false)
    private String clinicAddress;

    
    @Column(name = "city", length = 20, nullable = false)
    private String city;

    @Column(name = "state", length = 20, nullable = false)
    private String state;

    @Column(name = "zip_code", length = 20, nullable = false) 
    private String zipCode;

    
    @Column(name = "clinic_email", length = 30, nullable = false)
    private String clinicEmail;

    @Column(name = "clinic_website", length = 20, nullable = false)
    private String clinicWebsite;

    
    @Column(name = "clinic_contact", length = 20, nullable = false)
    private String clinicContact;
    
    @OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClinicHours> clinicHours = new ArrayList<>();
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private Admin admin;
    
    

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
    public List<ClinicHours> getClinicHours() {
		return clinicHours;
	}

	public void setClinicHours(List<ClinicHours> clinicHours) {
		this.clinicHours = clinicHours;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getClinicAddress() {
		return clinicAddress;
	}

	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getClinicEmail() {
		return clinicEmail;
	}

	public void setClinicEmail(String clinicEmail) {
		this.clinicEmail = clinicEmail;
	}

	public String getClinicWebsite() {
		return clinicWebsite;
	}

	public void setClinicWebsite(String clinicWebsite) {
		this.clinicWebsite = clinicWebsite;
	}

	public String getClinicContact() {
		return clinicContact;
	}

	public void setClinicContact(String clinicContact) {
		this.clinicContact = clinicContact;
	}

//	public List<ClinicHours> getOperatingHours() {
//		return operatingHours;
//	}
//
//	public void setOperatingHours(List<ClinicHours> operatingHours) {
//		this.operatingHours = operatingHours;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
}

