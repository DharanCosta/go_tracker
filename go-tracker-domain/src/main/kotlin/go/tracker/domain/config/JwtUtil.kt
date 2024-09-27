package go.tracker.domain.config

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*

@Component
@PropertySource(value = ["classpath:application-api-local.properties"])
class JwtUtil {

    @Value("\${jwt.secret}")
    private val secret: String? = null

    private val secretKey: Key = Keys.secretKeyFor(SignatureAlgorithm.HS512)

    @Value("\${jwt.expiration}")
    private val jwtExpiration: Long = 5 * 60 * 60 // 5 hours

    // Generate token for user
    fun generateToken(userDetails: UserDetails): String {
        val claims = HashMap<String, Any>()
        claims["roles"] = userDetails.authorities.map { it.authority }
//        claims["role"] = userDetails.authorities.map { it.authority }
        return doGenerateToken(claims, userDetails.username)
    }

    // While creating the token -
    // 1. Define claims of the token, like Issuer, Expiration, Subject, and the ID
    // 2. Sign the JWT using the HS512 algorithm and secret key.
    // 3. According to JWS Compact Serialization, compact the JWT to a URL-safe string
    private fun doGenerateToken(claims: Map<String, Any>, subject: String): String {
        val issuedDate = Date()
        val expirationDate = Date(issuedDate.time + jwtExpiration * 1000)
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(subject)
            .setIssuedAt(issuedDate)
            .setExpiration(expirationDate)
            .signWith(secretKey)
            .compact()
    }

    // Retrieve username from JWT token
    fun getUsernameFromToken(token: String): String {
        return getClaimFromToken(token, Claims::getSubject)
    }

    fun getRolesFromToken(token: String): List<String> {
        val claims = Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .body

        return claims["roles"] as List<String>
    }

    // Retrieve expiration date from JWT token
    fun getExpirationDateFromToken(token: String): Date {
        return getClaimFromToken(token, Claims::getExpiration)
    }

    // Retrieve claim from JWT token
    fun <T> getClaimFromToken(token: String, claimsResolver: (Claims) -> T): T {
        val claims = getAllClaimsFromToken(token)
        return claimsResolver(claims)
    }

    // For retrieving any information from token we will need the secret key
    private fun getAllClaimsFromToken(token: String): Claims {
        return Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .body
    }

    // Check if the token has expired
    private fun isTokenExpired(token: String): Boolean {
        val expiration = getExpirationDateFromToken(token)
        return expiration.before(Date())
    }

    // Validate token
    fun validateToken(token: String, userDetails: UserDetails): Boolean {
        val username = getUsernameFromToken(token)
        return (username == userDetails.username && !isTokenExpired(token))
    }
}