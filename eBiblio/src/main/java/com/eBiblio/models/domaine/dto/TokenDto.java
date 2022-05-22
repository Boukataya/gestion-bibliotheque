package com.eBiblio.models.domaine.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TokenDto implements Serializable {
	private static final long serialVersionUID = -8983972106948531914L;
	private String username;
	private String jwttoken;
	private List<String> roles=new ArrayList<>();

}

