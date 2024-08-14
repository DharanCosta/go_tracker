package go.tracker.domain.config

import go.tracker.models.user.UserLogin
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl(private val user: UserLogin) : UserDetails {
    override fun getAuthorities() : Collection<GrantedAuthority> =
        user.role.map {SimpleGrantedAuthority(it) }

    override fun isEnabled() = true

    override fun getUsername() = user.email

    override fun isCredentialsNonExpired() = true

    override fun getPassword() = user.password

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true
}