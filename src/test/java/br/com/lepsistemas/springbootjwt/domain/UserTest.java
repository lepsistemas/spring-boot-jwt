package br.com.lepsistemas.springbootjwt.domain;

import static br.com.lepsistemas.springbootjwt.AssertAnnotations.assertField;
import static br.com.lepsistemas.springbootjwt.AssertAnnotations.assertType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserTest {
	
	@Test
	public void class_should_have_entity_annotation() {
		assertType(User.class, Entity.class);
	}
	
	@Test
	public void field_id_should_have_id_and_generated_value_annotations() {
		assertField(User.class, "id", Id.class, GeneratedValue.class);
	}
	
	@Test
	public void field_username_should_have_column_annotation() {
		assertField(User.class, "username", Column.class);
	}
	
	@Test
	public void field_password_should_have_json_ignore_annotation() {
		assertField(User.class, "password", JsonIgnore.class);
	}

}
