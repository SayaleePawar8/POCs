package com.example.jwt.demo.Models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JwtResponse {

	private String userName;
	private String jwtToken;

}
