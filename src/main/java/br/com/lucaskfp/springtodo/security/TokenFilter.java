package br.com.lucaskfp.springtodo.security;

import java.io.IOException;

import javax.security.auth.login.CredentialNotFoundException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import br.com.lucaskfp.springtodo.user.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

@Component
public class TokenFilter extends OncePerRequestFilter {

    @Autowired
    UserRepository userRepository;

    @Value("${TOKEN_KEY}")
    private String tokenkey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authorization = request.getHeader("Authorization");

        if (authorization != null) {

            String token = authorization.substring(7);

            try {
                JwtParser parser = Jwts.parser().setSigningKey(tokenkey);
                parser.parse(token);
                Claims claims = parser.parseClaimsJws(token).getBody();
                String email = (String) claims.get("email");
                int userId = Integer.valueOf((String) claims.get("id"));

                userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));

                CustomUserDetails userDetails = new CustomUserDetails(email, userId);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null,
                        userDetails.getAuthorities());

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

        filterChain.doFilter(request, response);
    }

}
