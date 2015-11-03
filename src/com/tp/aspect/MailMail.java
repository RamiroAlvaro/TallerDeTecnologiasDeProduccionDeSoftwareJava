package com.tp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.tp.actions.InicioAction;




public class MailMail {
	
//	@Around("execution(* com.tp.actions.DenunciaAction.execute())")
//	public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
//		
//		
//		joinPoint.proceed();
//	
//		
//		
//	}
	
//	@After ("execution(* com.tp.actions.DenunciaAction.execute())")
//	public void logLuego () {
//	System.out.println("Log After Luego de la ejecución del DAO");
//	InicioAction inicio = new InicioAction();
//	inicio.execute();
//	}
	
	private MailSender mailSender;
	 
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	

 
	public void sendMail(String from, String to, String subject, String msg) {
 
		SimpleMailMessage message = new SimpleMailMessage();
 
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);	
	}
	
}
