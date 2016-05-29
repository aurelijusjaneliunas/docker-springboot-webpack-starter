package springboot.config.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.SessionRepositoryFilter;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
// @EnableRedisHttpSession
public class EmbeddedSessionConfig {

  @Bean
  public SessionRepositoryFilter<?> springSessionRepositoryFilter() {
    SessionRepositoryFilter<?> sessionRepositoryFilter = new SessionRepositoryFilter<>(new MapSessionRepository());
    sessionRepositoryFilter.setHttpSessionStrategy(new HeaderHttpSessionStrategy());
    return sessionRepositoryFilter;
  }

}
