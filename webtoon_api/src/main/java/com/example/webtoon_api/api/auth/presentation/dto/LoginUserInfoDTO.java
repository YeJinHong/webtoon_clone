package com.example.webtoon_api.api.auth.presentation.dto;

import com.example.webtoon_api.api.common.TokenDTO;
import com.example.webtoon_api.api.user.persistence.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class LoginUserInfoDTO {

	private UserEntity user;
	private TokenDTO tokenDto;

}
