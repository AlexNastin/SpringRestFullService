package spring.restfullservice.example.bean;

import com.fasterxml.jackson.annotation.JsonView;

public class AjaxResponse {

	@JsonView
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
