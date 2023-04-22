package com.example.webtoon_api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "password", length = 200)
	private String password;

	@Column(name = "nickname", length = 100)
	private String nickname;

	@Column(name = "phone", length = 100)
	private String phone;

	@Column(name = "profile_url", length = 200)
	// @Column(name = "profile_url", length = 200, columnDefinition = "카카오에서 주는 url")
	private String profileUrl;

	@Column(name = "status", nullable = false, columnDefinition = "TINYINT default 1")
	private int status;

	@Column(name = "provider_id", length = 200)
	private String providerId;

	@Column(name = "provider", length = 100)
	private String provider;
}
