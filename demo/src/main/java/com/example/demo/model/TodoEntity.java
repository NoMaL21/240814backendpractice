package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.NamedQuery;

import org.hibernate.annotations.UuidGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Todo")
@NamedQuery(name="TodoRepository.searchByUserId",
		query = "select t from TodoEntity t where t.userId = ?1")
public class TodoEntity {
	@Id
	@GeneratedValue(generator="system-uuid")
	@UuidGenerator(style = UuidGenerator.Style.TIME)
	private String id;
	private String userId;
	private String title;
	private boolean done;
	
}
