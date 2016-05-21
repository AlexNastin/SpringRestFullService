package spring.restfullservice.example.bean;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;

public class Book implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	@JsonView
	private int idBook;

	@JsonView
	private String name;

	@JsonView
	private String author;

	@JsonView
	private Date dataPublishing;

	public Book() {
		super();
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDataPublishing() {
		return dataPublishing;
	}

	public void setDataPublishing(Date dataPublishing) {
		this.dataPublishing = dataPublishing;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((dataPublishing == null) ? 0 : dataPublishing.hashCode());
		result = prime * result + idBook;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (dataPublishing == null) {
			if (other.dataPublishing != null)
				return false;
		} else if (!dataPublishing.equals(other.dataPublishing))
			return false;
		if (idBook != other.idBook)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [idBook=" + idBook + ", name=" + name + ", author=" + author + ", dataPublishing=" + dataPublishing
				+ "]";
	}
}
