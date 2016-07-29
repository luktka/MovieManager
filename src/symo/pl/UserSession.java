package symo.pl;

import java.util.Date;

public class UserSession {
	private String accessKey;
	private String owner;
	private Date expirationDate; 

	public String getAccessKey() {  
		return accessKey;  
	}  
	public void setAccessKey(String accessKey) {  
		this.accessKey = accessKey;  
	} 
	public String getOwner() {  
		return owner;  
	}  
	public void setOwner(String owner) {  
		this.owner = owner;  
	}
	public Date getExpirationDate() {  
		return expirationDate;  
	}  
	public void setExpirationDate(Date expirationDate) {  
		this.expirationDate = expirationDate;  
	}  
}
