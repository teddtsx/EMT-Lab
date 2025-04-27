package ukim.finki.mk.lab1.security;

public class JWTConstants {
    public static final String SECRET_KEY="ed389ccf2ed5e4ed7f7ba8bcf943d91177be04736ddd02736e6d51a859da4488";
    public static final String TOKEN_PREFIX="Bearer ";
    public static final String HEADER_STRING="Authorization";
    public static final Long EXPIRATION_TIME= 864000000L ;
}
