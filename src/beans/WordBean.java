package beans;

import java.io.Serializable;

public class WordBean implements Serializable {
	public static final long serialVersionUID=1L;
	private String english;
	private String japanese;
	
	public WordBean() {}
	
	public WordBean(String japanese) {
		this.japanese=japanese;
	}
	
	public WordBean(String english,String japanese) {
		this.english=english;
		this.japanese=japanese;
	}
	
	public String getEnglish() {
		return english;
	}
	public String getJapanese() {
		return japanese;
	}
	public void setJapanese(String japanese) {
		this.japanese=japanese;
	}
	
	public void setEnglish(String english) {
		this.english=english;
	}
	

}
