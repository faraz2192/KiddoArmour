package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "vaccination")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vaccination extends BaseEntity{

    
    @Column(name = "vaccine_name", nullable = false)
    private String vaccineName;

    @Column(name = "description")
    private String description;
    
    @Column(name = "forDisease")
    private String forDisease;
    
    @Column(name = "agegroup")
    private int ageGroup;

    @Column(name = "deadline", nullable = false)
    private LocalDate deadline;

    @Column(name = "no_of_doses", nullable = false)
    private Integer noOfDoses;

    @Column(name = "dose_given", nullable = false)
    private Integer doseGiven;

    @Column(name = "priority", nullable = false)
    private String priority;

    @Column(name = "risk", nullable = false)
    private String risk;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "recommendation_status", nullable = false)
    private String recommendationStatus;
    
 // Many-to-One relationship with Child
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_id", referencedColumnName = "id")
    private Child child;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reminder_id")
    private Reminder reminder;
    
    @ManyToMany(mappedBy = "vaccinations")
    private List<Parent> parents = new ArrayList<>();
    
 // Many-to-One relationship with Doctor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "vaccination_medical_history", 
        joinColumns = @JoinColumn(name = "vaccination_id"), 
        inverseJoinColumns = @JoinColumn(name = "medical_history_id"))
    private List<MedicalHistory> medicalHistories = new ArrayList<>();
    
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;

	public List<MedicalHistory> getMedicalHistories() {
		return medicalHistories;
	}

	public Reminder getReminder() {
		return reminder;
	}

	public void setReminder(Reminder reminder) {
		this.reminder = reminder;
	}

	public void setMedicalHistories(List<MedicalHistory> medicalHistories) {
		this.medicalHistories = medicalHistories;
	}

	public String getVaccineName() {
		return vaccineName;
	}
	
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getForDisease() {
		return forDisease;
	}

	public void setForDisease(String forDisease) {
		this.forDisease = forDisease;
	}

	public int getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(int ageGroup) {
		this.ageGroup = ageGroup;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public Integer getNoOfDoses() {
		return noOfDoses;
	}

	public void setNoOfDoses(Integer noOfDoses) {
		this.noOfDoses = noOfDoses;
	}

	public Integer getDoseGiven() {
		return doseGiven;
	}

	public void setDoseGiven(Integer doseGiven) {
		this.doseGiven = doseGiven;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRecommendationStatus() {
		return recommendationStatus;
	}

	public void setRecommendationStatus(String recommendationStatus) {
		this.recommendationStatus = recommendationStatus;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public List<Parent> getParents() {
		return parents;
	}

	public void setParents(List<Parent> parents) {
		this.parents = parents;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
    
    
}

