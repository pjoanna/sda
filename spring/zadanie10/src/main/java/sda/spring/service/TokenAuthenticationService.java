package sda.spring.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TokenAuthenticationService {

	public static final String AUTH_HEADER_NAME = "Authorization";
	public static final String API_KEY_HEADER_NAME = "api_key";
	public static final String MAIN_JWT_HEADER_NAME = "mainJwt";

	private static final Logger LOG = LoggerFactory.getLogger(TokenAuthenticationService.class);

	private final UserService userService;
	private final UserDetailsChecker userDetailsChecker;

	@Autowired
	public TokenAuthenticationService(final UserService userService, final UserDetailsChecker userDetailsChecker) {
		this.userService = userService;
		this.userDetailsChecker = userDetailsChecker;
	}

	public Authentication getAuthentication(final HttpServletRequest httpRequest,
			final HttpServletResponse httpResponse) {

		final Optional<String> currentUserToken = getCurrentUserToken(httpRequest);

		if (currentUserToken.isPresent()) {
			final UserDetails user = parseToken(currentUserToken.get());

			if (user != null) {
				userDetailsChecker.check(user);
				return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(),
						user.getAuthorities());
			}
		} else {
			LOG.warn("Auth Token was not found in " + API_KEY_HEADER_NAME + " nor in " + AUTH_HEADER_NAME);
		}
		return null;
	}

	private UserDetails parseToken(String token) {
		String[] usernameAndPassword = token.split("_");
		return userService.loadUserByUsername(usernameAndPassword[0]);
	}

	private Optional<String> getCurrentUserToken(final HttpServletRequest request) {
		String token = request.getHeader(API_KEY_HEADER_NAME);

		if (StringUtils.isEmpty(token)) {
			token = request.getHeader(AUTH_HEADER_NAME);
		}

		return StringUtils.isEmpty(token) ? Optional.empty() : Optional.of(token);
	}

	public String authenticate(final Authentication authentication) throws AuthenticationException {
		final String username = (String) authentication.getPrincipal();
		final UserDetails user = userService.loadUserByUsername(username);

		if (user == null || authentication.getCredentials() == null) {
			throw new BadCredentialsException("Wrong credentials.");
		}

		if (!authentication.getCredentials().equals(user.getPassword())) {
			throw new BadCredentialsException("Wrong credentials.");
		}

		userDetailsChecker.check(user);

		return createTokenForUser(user);
	}

	private String createTokenForUser(UserDetails user) {
		return user.getUsername() + "_" + user.getPassword();
	}

	public String getUserNameFromToken(final String token) {
		return parseToken(token).getUsername();
	}

}
