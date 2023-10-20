package iocDI03_jc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// ** Java Bean Configuration class를 이용한 DI
// => Test04 : 스피커 2개 중 선택 
// => xml에서 JC 파일 import, @ 병행 사용
// => JC에서는 LgTVsi, AiTVsi, SpeakerB 생성

@Configuration
public class JavaConfig04 {
	@Bean
	public TV lgtv() { return new LgTVsi(new SpeakerB(), "Blue", 5566000); }
	
	public TV aitv() { return new AiTVsi(); }
}
