package net.back.vo;

import java.util.Arrays;

public class MailRequest {
	
    private String[] to;
    private String body;
    private String subject;

    /**
     * Get the MailRequest receiver
     * 
     * @return a String array of MailRequest receiver
     */
    public String[] getTo() {
        return to;
    }

    /**
     * Set the MailRequest receiver
     * 
     * @param to: the list of MailRequest receiver as a String array to set
     */
    public void setTo(String[] to) {
        this.to = to;
    }

    /**
     * Get the MailRequest body
     * 
     * @return a String containing the MailRequest body
     */
    public String getBody() {
        return body;
    }

    /**
     * Set the MailRequest body
     * 
     * @param body: the MailRequest body as a String to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Get the MailRequest subject
     * 
     * @return a String containing the MailRequest subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Set the MailRequest subject
     * 
     * @param subject: the MailRequest subject as a String to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Get the designation of the MailRequest object
     * 
     * @return a String containing the designation of the MailRequest object
     */
	@Override
	public String toString() {
		return "MailRequest [to=" + Arrays.toString(to) + ", body=" + body + ", subject=" + subject + "]";
	}
    
    
}
