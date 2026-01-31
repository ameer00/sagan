package sagan.site.projects;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Group of projects related by a particular theme or problem space
 */
@Entity
@Table(name = "project_groups")
public class ProjectGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String label;

	public ProjectGroup() {}

	public ProjectGroup(String name, String label) {
		this.name = name;
		this.label = label;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProjectGroup that = (ProjectGroup) o;
		return name.equals(that.name) &&
				label.equals(that.label);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, label);
	}

	@Override
	public String toString() {
		return "ProjectGroup{" +
				"id=" + id +
				", name='" + name + '\'' +
				", label='" + label + '\'' +
				'}';
	}
}
