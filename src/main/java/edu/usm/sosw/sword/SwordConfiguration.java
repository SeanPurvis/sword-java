package edu.usm.sosw.sword;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.UnsupportedEncodingException;

import javax.validation.Valid;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.NotEmpty;

public class SwordConfiguration extends Configuration {
    // TODO: implement service configuration
	
	@Valid
	@NotNull
	@JsonProperty
	private DataSourceFactory database = new DataSourceFactory();
	
	public DataSourceFactory getDataSourceFactory() {
		return database;
	}

    @NotEmpty
    private String jwtTokenSecret = "dfwzsdzwh823zebdwdz772632gdsbdaw";

    public byte[] getJwtTokenSecret() throws UnsupportedEncodingException {
        return jwtTokenSecret.getBytes("UTF-8");
    }
}
