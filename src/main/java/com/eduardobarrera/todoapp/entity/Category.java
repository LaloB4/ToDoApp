package com.eduardobarrera.todoapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Category.
 */
@Entity
@Table(name = "category")
public class Category {

	/** The category id. */
	@Id
	@GeneratedValue
	@Column(name = "category_id", unique = true, nullable = false)
	private Integer categoryId;

	/** The category description. */
	@Column(name = "category_description")
	private String categoryDescription;

	/**
	 * Gets the category id.
	 *
	 * @return the category id
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * Sets the category id.
	 *
	 * @param categoryId the new category id
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * Gets the category description.
	 *
	 * @return the category description
	 */
	public String getCategoryDescription() {
		return categoryDescription;
	}

	/**
	 * Sets the category description.
	 *
	 * @param categoryDescription the new category description
	 */
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	/**
	 * Instantiates a new category.
	 *
	 * @param categoryId the category id
	 * @param categoryDescription the category description
	 */
	public Category(Integer categoryId, String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryDescription = categoryDescription;
	}

	/**
	 * Instantiates a new category.
	 */
	public Category() {
	}

}
