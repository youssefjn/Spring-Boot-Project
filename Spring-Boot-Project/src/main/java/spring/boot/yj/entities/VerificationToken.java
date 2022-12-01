package spring.boot.yj.entities;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table (name = "VERIFICATION_TOKEN")
public class VerificationToken {
	@Id
	@GeneratedValue (strategy =GenerationType.IDENTITY)
	private Long id;
	@Lob
	@Column(name = "token", nullable = false,unique = true)
	private String token;
	@Column(nullable = false)
	private Timestamp createdTimeStamp;

	@ManyToOne (optional = false )
	@JoinColumn(name = "user_id",nullable = false)
	private User user;
}
