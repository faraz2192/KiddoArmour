package com.app.pojos;

import org.springframework.security.crypto.bcrypt.BCrypt;

import edu.sjsu.cmpe275.vms.model.Appointment;

//import com.app.pojos.Role;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    

	@Column(length = 20, nullable = false)
    private String username;

    @Column(length = 20, nullable = false)
    private String firstName;

    @Column(length = 20, nullable = false)
    private String lastName;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false)
    private String hint;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

//    @Enumerated(EnumType.STRING)
//    @Column(length = 20, nullable = false)
//    private Role role;
    @OneToMany(mappedBy = "patientId", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Appointment> appointmentList;

    public List<Appointment> getAppointmentList(){return appointmentList;}
    
    @ManyToMany
	@JoinTable(name = "user_roles", 
	joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> userRoles = new HashSet<>();

    @Column(nullable = false)
    private String hashedPassword;
    
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Doctor> createdDoctors = new ArrayList<>();

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Admin> createdAdmins = new ArrayList<>();

    @OneToMany(mappedBy = "createdBy")
    private List<User> createAdmins = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private Admin createdBy;
    
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Parent> createdParents = new ArrayList<>();

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> createdChildren = new ArrayList<>();

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Log> logs = new ArrayList<>();

//    @ManyToMany(mappedBy = "users")
//    private List<Notification> notifications = new ArrayList<>();

 // User.java

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Reminder> reminders = new ArrayList<>();

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<MedicalHistory> medicalHistories = new ArrayList<>();

    

//    @ManyToMany
//    @JoinTable(
//        name = "clinic_hours_users", 
//        joinColumns = @JoinColumn(name = "user_id"), 
//        inverseJoinColumns = @JoinColumn(name = "clinic_hours_id")
//    )
//    private List<ClinicHours> clinicHours = new ArrayList<>();

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Appointment> appointments = new ArrayList<>();

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "user_vaccination", 
//        joinColumns = @JoinColumn(name = "user_id"), 
//        inverseJoinColumns = @JoinColumn(name = "vaccination_id"))
//    private List<Vaccination> vaccinations = new ArrayList<>();

//    public List<User> getCreateAdmins() {
//		return createAdmins;
//	}
//
//	public void setCreateAdmins(List<User> createAdmins) {
//		this.createAdmins = createAdmins;
//	}
//
//	public Admin getCreatedBy() {
//		return createdBy;
//	}
//
//	public void setCreatedBy(Admin createdBy) {
//		this.createdBy = createdBy;
//	}
//
//	public List<Doctor> getCreatedDoctors() {
//		return createdDoctors;
//	}
//
//	public void setCreatedDoctors(List<Doctor> createdDoctors) {
//		this.createdDoctors = createdDoctors;
//	}
//
//	public List<Admin> getCreatedAdmins() {
//		return createdAdmins;
//	}
//
//	public void setCreatedAdmins(List<Admin> createdAdmins) {
//		this.createdAdmins = createdAdmins;
//	}
//
//	public List<Parent> getCreatedParents() {
//		return createdParents;
//	}
//
//	public void setCreatedParents(List<Parent> createdParents) {
//		this.createdParents = createdParents;
//	}
//
//	public List<Child> getCreatedChildren() {
//		return createdChildren;
//	}
//
//	public void setCreatedChildren(List<Child> createdChildren) {
//		this.createdChildren = createdChildren;
//	}
	
	public Set<Role> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<Role> userRoles) {
		this.userRoles = userRoles;
	}

//	public List<Log> getLogs() {
//		return logs;
//	}
//
//	public void setLogs(List<Log> logs) {
//		this.logs = logs;
//	}

//	public List<Notification> getNotifications() {
//		return notifications;
//	}
//
//	public void setNotifications(List<Notification> notifications) {
//		this.notifications = notifications;
//	}

//	public List<Reminder> getReminders() {
//		return reminders;
//	}
//
//	public void setReminders(List<Reminder> reminders) {
//		this.reminders = reminders;
//	}

//	public List<MedicalHistory> getMedicalHistories() {
//		return medicalHistories;
//	}
//
//	public void setMedicalHistories(List<MedicalHistory> medicalHistories) {
//		this.medicalHistories = medicalHistories;
//	}

//	public List<ClinicHours> getClinicHours() {
//		return clinicHours;
//	}
//
//	public void setClinicHours(List<ClinicHours> clinicHours) {
//		this.clinicHours = clinicHours;
//	}
//
//	
//	public List<Appointment> getAppointments() {
//		return appointments;
//	}
//
//	public void setAppointments(List<Appointment> appointments) {
//		this.appointments = appointments;
//	}

//	public List<Vaccination> getVaccinations() {
//		return vaccinations;
//	}
//
//	public void setVaccinations(List<Vaccination> vaccinations) {
//		this.vaccinations = vaccinations;
//	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String password) {
        this.hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.hashedPassword);
    }
    

    
}

/*
 * package com.app.pojos;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.crypto.bcrypt.BCrypt;

import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{

    
    //@NotBlank(message = "Username is required")
    @Column(name = "username", nullable = false)
    @Size(max = 20, message = "Maximum username length is 20 characters")
    private String username;
    
    @NotBlank(message = "First name is required")
    @Size(max = 20, message = "Maximum first name length is 20 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 20, message = "Maximum last name length is 20 characters")
    private String lastName;

    
    @Column(name = "email", unique = true,nullable = false)
    @Email(message = "Invalid email address")
    private String email;
    
    @Column(name = "hint")
    private String hint;
    
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "hashed_password")
    private String hashedPassword;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

    public void setHashedPassword(String password) {
        this.hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
    }
    
    public String getHashedPassword() {
        return hashedPassword;
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.hashedPassword);
    }
    
    
    //@NotBlank(message = "Password is required")
//    @Column(name = "password", nullable = false, length = 100)
//    @Getter(AccessLevel.NONE)
//    private String password;
    
    

}

*/
