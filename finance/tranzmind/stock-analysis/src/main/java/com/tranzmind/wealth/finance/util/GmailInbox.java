package com.tranzmind.wealth.finance.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;
import javax.mail.search.FromStringTerm;

import org.jsoup.Jsoup;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GmailInbox {
	
	private boolean textIsHtml = false;
 
    public static void main(String[] args) {   	

        GmailInbox gmail = new GmailInbox();
        gmail.read();
 
    }
 
    public void read() {
 
        Properties props = new Properties();
 
        try {
            props.load(new FileInputStream(new File("smtp.properties")));
            Session session = Session.getDefaultInstance(props, null);
 
            Store store = session.getStore("imaps");
            store.connect(props.getProperty("mail.smtp.host"), 
            		props.getProperty("mail.smtp.username"), 
            		props.getProperty("mail.smtp.password"));
 
            Folder inbox = store.getFolder("inbox");
            
            inbox.open(Folder.READ_ONLY);
            //int messageCount = inbox.getMessageCount();
            
            //Message[] messages = inbox.search(
            //        new FlagTerm(new Flags(Flags.Flag.SEEN), false));
            
            Message[] messages = inbox.search(new FromStringTerm("@stocktwits.com"));
 
            log.debug("Total Messages:- " + messages.length);
 
            log.debug("------------------------------");
            
            int messageCount = messages.length;
 
            for (int i = (messageCount - 1); i >= (messageCount - 5); i--) {
                log.debug("############################ Mail Subject:- " + messages[i].getSubject());
                try {
                	
                	log.debug("Date : {} ",messages[i].getReceivedDate());
                	log.debug(messages[i].getContentType());
                	if(messages[i].getContentType().startsWith("TEXT/HTML")) {
                		
                		String html = messages[i].getContent().toString();
                		//log.info(Jsoup.parse(html).text());
                	}else {
                		//printText((Multipart) messages[i].getContent());
                	}
                	
                	log.info("Date : {} -> {}",messages[i].getReceivedDate(), messages[i].getSubject());
                }catch(Exception ex) {
                	System.err.println("Error Printing Message "+ ex.getMessage());
                	ex.printStackTrace();                	
                }
            }
 
            inbox.close(true);
            store.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void printText(Multipart messageContent) throws Exception {
  	
		String contentType = messageContent.getContentType();
		
		//log.info("Content Type -> "+contentType);
		//log.info("Message Body Part Count -> "+messageContent.getCount());
		
		if(contentType.startsWith("multipart/ALTERNATIVE")) {
			log.info("Message Count ->"+ messageContent.getCount());
			
			for (int i = 0; i < messageContent.getCount(); i++) {
				
				Part bodyPart = messageContent.getBodyPart(i);
				
				if (bodyPart.isMimeType("text/plain")) {
					
					log.info("Print Text **********************************");
					
					log.info((String) bodyPart.getContent());
					
					log.info("Print Text END **********************************");
					
				}else if(bodyPart.isMimeType("text/html")) {
					
					log.info("Print HTML **********************************");
					
					log.info(
							Jsoup.parse(bodyPart
									.getContent()
									.toString())
									.getAllElements()
									.text()
									);
					
					log.info("Print HTML END **********************************");
				}
			}	    		
		}
    }
    
    /**
     * Return the primary text content of the message.
     */
    private String getText(Part bp2) throws MessagingException, IOException {
        if (((Part) bp2).isMimeType("text/*")) {
            String s = (String)bp2.getContentType();
            textIsHtml = ((Part) bp2).isMimeType("text/html");
            return s;
        }

        if (((Part) bp2).isMimeType("multipart/alternative")) {
            // prefer html text over plain text
            Multipart mp = (Multipart) bp2;
            String text = null;
            for (int i = 0; i < mp.getCount(); i++) {
                Part bp = mp.getBodyPart(i);
                if (bp.isMimeType("text/plain")) {
                    if (text == null)
                        text = getText(bp);
                    continue;
                } else if (bp.isMimeType("text/html")) {
                    String s = getText(bp);
                    if (s != null)
                        return s;
                } else {
                    return getText(bp);
                }
            }
            return text;
        } else if (bp2.isMimeType("multipart/*")) {
            Multipart mp = (Multipart) bp2;
            for (int i = 0; i < mp.getCount(); i++) {
                String s = getText(mp.getBodyPart(i));
                if (s != null)
                    return s;
            }
        }

        return null;
    }
 
}
