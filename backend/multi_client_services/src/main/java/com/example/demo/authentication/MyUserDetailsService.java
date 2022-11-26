//package com.example.demo.authentication;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.entity.CustomerEntity;
//import com.example.demo.repository.CustomerRepository;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	CustomerRepository customerrepo;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		CustomerEntity customer = customerrepo.findByCustomerEmail(username);
//		if (customer == null) {
//			throw new UsernameNotFoundException("user not found");
//		}
//		return new UserPrincipal(customer);
//	}
//
//}
