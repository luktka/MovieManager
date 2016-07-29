package symo.pl;

public class Movie {
		
	private String uuid; 
	private String owner; 
	private String title;
	private String description; 
	private boolean watched;
	

	public String getUuid() {  
		return uuid;  
	}  
	public void setUuid(String uuid) {  
		this.uuid = uuid;  
	}  
	public String getOwner() {  
		return owner;  
	}  
	public void setOwner(String owner) {  
		this.owner = owner;  
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
	public boolean getWatched() {  
		return watched;  
	}  
	public void setWatched(boolean watched) {  
		this.watched = watched;  
	}  

}
