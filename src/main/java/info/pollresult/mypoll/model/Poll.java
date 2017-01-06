package info.pollresult.mypoll.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import infopollresult.mypoll.Util.PollType;

@Document(collection="polls")
public class Poll {
	@Id
	private int id;
	private String title;
	private String description;
	private PollType pollType;
	private long yesCount;
	private long noCount;
	private long ratingCount;
	
	//private List<Category> categories;

	public Poll() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PollType getPollType() {
		return pollType;
	}

	public void setPollType(PollType pollType) {
		this.pollType = pollType;
	}

	public long getYesCount() {
		return yesCount;
	}

	public void setYesCount(long yesCount) {
		this.yesCount = yesCount;
	}

	public long getNoCount() {
		return noCount;
	}

	public void setNoCount(long noCount) {
		this.noCount = noCount;
	}

	public long getRatingCount() {
		return ratingCount;
	}

	public void setRatingCount(long ratingCount) {
		this.ratingCount = ratingCount;
	}

	/*public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}*/
}
