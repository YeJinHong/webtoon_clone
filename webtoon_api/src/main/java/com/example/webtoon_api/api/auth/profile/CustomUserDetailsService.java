package com.example.webtoon_api.api.auth.profile;

import java.util.NoSuchElementException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.webtoon_api.entity.UserEntity;
import com.example.webtoon_api.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("loadUserByUsername username : {}", username);

		long id = Long.parseLong(username);
		UserEntity user = userRepository.findById(id)
			.orElseThrow(() -> new NoSuchElementException("해당 유저 정보를 찾을 수 없습니다."));
		return new CustomUserDetails(user);
	}
}
