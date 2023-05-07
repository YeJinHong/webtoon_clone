package com.example.webtoon_api.api.auth.presentation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class KakaoProfile {
	public Long id;

	public String connected_at;
	public Properties properties;
	public KakaoAccount kakaoAccount;

}

@Getter
@Setter
class Properties {
	public String nickname;
	public String profile_image;
	public String thumbnail_image;
}

@Getter
@Setter
class KakaoAccount {
	public Boolean profile_nickname_needs_agreement;
	public Boolean profile_image_needs_agreement;
	public Profile profile;
}

@Getter
@Setter
class Profile {
	public String nickname;
	public String thumbnail_image_url;
	public String profile_image_url;
	public Boolean is_default_image;
}
