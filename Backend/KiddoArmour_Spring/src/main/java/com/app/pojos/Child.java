package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;



@Entity
@Table(name = "child")
public class Child extends BaseEntity{

        
    
    @Column(name = "firstName", length = 20, nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 20, nullable = false)
    private String lastName;
    
    @Column(name = "active", nullable = false)
    private boolean active;
    
    @Column(name = "gender", nullable = false)
    private String gender;
    
//    @NotNull(message = "Date of birth is required")
//    private LocalDate dateOfBirth;
    
    @Column(name = "dob", nullable = false)
    private LocalDate dateOfBirth;
    
//  @Column(name = "med_history") //Use this If we do not want to create another class for medical history  
//  private String medicalHistory;
    
//    @NotBlank(message = "Blood group is mandatory")
//    @Pattern(regexp = "^(A|B|AB|O)[+-]$", message = "Invalid blood group")
//    private String bloodGroup;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "blood_group", nullable = false)
    private BloodGroup bloodGroup;
    
    @Column(name = "allergies", length = 100)
    private String allergies;
    

    
    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicalHistory> medicalHistories = new ArrayList<>();
    
    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vaccination> vaccinations = new ArrayList<>();
   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private User createdBy;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Parent parent;
    
    @OneToMany(mappedBy = "child", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "child", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reminder> reminders = new ArrayList<>();
    
//  @OneToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "user_id", referencedColumnName = "id")
//  private User user;
    
//    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL)
//    private List<Log> logs = new ArrayList<>();
//  private Set<Log> logs;

    
    
    
    
	public String getFirstName() {
		return firstName;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<Reminder> getReminders() {
		return reminders;
	}

	public void setReminders(List<Reminder> reminders) {
		this.reminders = reminders;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public MedicalHistory getMedicalHistory() {
//		return medicalHistory;
//	}
//
//	public void setMedicalHistory(MedicalHistory medicalHistory) {
//		this.medicalHistory = medicalHistory;
//	}
//	public List<Log> getLogs() {
//		return logs;
//	}
//
//	public void setLogs(List<Log> logs) {
//		this.logs = logs;
//	}
	

	public Parent getParent() {
		return parent;
	}
	
	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public List<MedicalHistory> getMedicalHistories() {
		return medicalHistories;
	}

	public void setMedicalHistories(List<MedicalHistory> medicalHistories) {
		this.medicalHistories = medicalHistories;
	}

	public List<Vaccination> getVaccinations() {
		return vaccinations;
	}

	public void setVaccinations(List<Vaccination> vaccinations) {
		this.vaccinations = vaccinations;
	}
	

	

    


    
    
}

   
