package by.agency.travel.hibernate.dao.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TOURS")
public class TourPojo implements Serializable{
	private static final long serialVersionUID = 4L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "HEADING")
	private String heading;
	
	@Column(name = "TEXT", columnDefinition="TEXT")
	private String text;
	
	@Column(name = "DURATION")
	private Integer duration;
	
	@Column(name = "PRICE")
	private Integer price;
	
	public TourPojo(){
	}
	
	public TourPojo(Integer id, String heading, String text, Integer duration, Integer price) {
		this.id = id;
		this.heading = heading;
		this.text = text;
		this.duration = duration;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}

