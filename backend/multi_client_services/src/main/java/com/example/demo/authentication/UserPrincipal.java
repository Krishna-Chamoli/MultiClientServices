//package com.example.demo.authentication;
//
//import java.util.Collection;
//import java.util.Collections;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.example.demo.entity.CustomerEntity;
//
//public class UserPrincipal implements UserDetails {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 5041175435560088135L;
//	private CustomerEntity customerentity;
//
//	public UserPrincipal(CustomerEntity customerentity) {
//		super();
//		this.customerentity = customerentity;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return Collections.singleton(new SimpleGrantedAuthority("USER"));
//	}
//
//	@Override
//	public String getPassword() {
//		return customerentity.getCustomerPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		return customerentity.getCustomerEmail();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//
//}
