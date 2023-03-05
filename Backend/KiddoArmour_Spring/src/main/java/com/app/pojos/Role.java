package com.app.pojos;
import javax.persistence.*;

public class Role extends BaseEntity{
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20,unique = true)
	private User roleName;

	public Role(User roleName) {
		super();
		this.roleName = roleName;
	}
//    ADMIN("Admin"),
//    DOCTOR("Doctor"),
//    PATIENT("Patient");
//
//    private final String displayName;
//
//    Role(String displayName) {
//        this.displayName = displayName;
//    }
//
//    public String getDisplayName() {
//        return displayName;
//    }
}
